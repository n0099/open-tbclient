package com.baidu.searchbox.bddownload.core.download;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.NamedRunnable;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.download.DownloadCache;
import com.baidu.searchbox.bddownload.core.file.ProcessFileStrategy;
import com.baidu.searchbox.bddownload.core.priority.PriorityStrategy;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class DownloadCall extends NamedRunnable implements Comparable<DownloadCall> {
    public static final ExecutorService EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("BdDownload Block", false));
    public static final int MAX_COUNT_RETRY_FOR_PRECONDITION_FAILED = 1;
    public static final String TAG = "DownloadCall";
    public final boolean asyncExecuted;
    @NonNull
    public final ArrayList<DownloadChain> blockChainList;
    @Nullable
    public volatile DownloadCache cache;
    public volatile boolean canceled;
    public volatile Thread currentThread;
    public volatile boolean finishing;
    @NonNull
    public final DownloadStore store;
    public final DownloadTask task;

    public DownloadCall(DownloadTask downloadTask, boolean z, @NonNull DownloadStore downloadStore) {
        this(downloadTask, z, new ArrayList(), downloadStore);
    }

    public static DownloadCall create(DownloadTask downloadTask, boolean z, @NonNull DownloadStore downloadStore) {
        return new DownloadCall(downloadTask, z, downloadStore);
    }

    private void inspectTaskEnd(DownloadCache downloadCache, @NonNull EndCause endCause, @Nullable Exception exc) {
        if (endCause != EndCause.CANCELED) {
            synchronized (this) {
                if (this.canceled) {
                    return;
                }
                this.finishing = true;
                this.store.onTaskEnd(this.task.getId(), endCause, exc);
                if (endCause == EndCause.COMPLETED) {
                    this.store.markFileClear(this.task.getId());
                    BdDownload.with().processFileStrategy().completeProcessStream(downloadCache.getOutputStream(), this.task);
                }
                BdDownload.with().callbackDispatcher().dispatch().taskEnd(this.task, endCause, exc);
                return;
            }
        }
        throw new IllegalAccessError("can't recognize cancelled on here");
    }

    private void inspectTaskStart() {
        this.store.onTaskStart(this.task.getId());
        BdDownload.with().callbackDispatcher().dispatch().taskStart(this.task);
    }

    public void assembleBlockAndCallbackFromBeginning(@NonNull BreakpointInfo breakpointInfo, @NonNull BreakpointRemoteCheck breakpointRemoteCheck, @NonNull ResumeFailedCause resumeFailedCause) {
        Util.assembleBlock(this.task, breakpointInfo, breakpointRemoteCheck.getInstanceLength(), breakpointRemoteCheck.isAcceptRange());
        BdDownload.with().callbackDispatcher().dispatch().downloadFromBeginning(this.task, breakpointInfo, resumeFailedCause);
    }

    public boolean cancel() {
        synchronized (this) {
            if (this.canceled) {
                return false;
            }
            if (this.finishing) {
                return false;
            }
            this.canceled = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            BdDownload.with().downloadDispatcher().flyingCanceled(this);
            DownloadCache downloadCache = this.cache;
            if (downloadCache != null) {
                downloadCache.setUserCanceled();
            }
            List<DownloadChain> list = (List) this.blockChainList.clone();
            for (DownloadChain downloadChain : list) {
                if (downloadChain != null) {
                    downloadChain.cancel();
                }
            }
            if (list.isEmpty() && this.currentThread != null) {
                Util.d(TAG, "interrupt thread with cancel operation because of chains are not running " + this.task.getId());
                this.currentThread.interrupt();
            }
            if (downloadCache != null) {
                downloadCache.getOutputStream().cancelAsync();
            }
            Util.d(TAG, "cancel task " + this.task.getId() + " consume: " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
            return true;
        }
    }

    public DownloadCache createCache(@NonNull BreakpointInfo breakpointInfo) {
        return new DownloadCache(BdDownload.with().processFileStrategy().createProcessStream(this.task, breakpointInfo, this.store));
    }

    @NonNull
    public BreakpointLocalCheck createLocalCheck(@NonNull BreakpointInfo breakpointInfo, long j) {
        return new BreakpointLocalCheck(this.task, breakpointInfo, j);
    }

    @NonNull
    public BreakpointRemoteCheck createRemoteCheck(@NonNull BreakpointInfo breakpointInfo) {
        return new BreakpointRemoteCheck(this.task, breakpointInfo);
    }

    public boolean equalsTask(@NonNull DownloadTask downloadTask) {
        return this.task.equals(downloadTask);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x015c A[EDGE_INSN: B:72:0x015c->B:45:0x015c ?: BREAK  , SYNTHETIC] */
    @Override // com.baidu.searchbox.bddownload.core.NamedRunnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() throws InterruptedException {
        EndCause endCause;
        boolean z;
        this.currentThread = Thread.currentThread();
        BdDownload with = BdDownload.with();
        ProcessFileStrategy processFileStrategy = with.processFileStrategy();
        inspectTaskStart();
        int i2 = 0;
        while (true) {
            if (this.task.getUrl().length() <= 0) {
                this.cache = new DownloadCache.PreError(new IOException("unexpected url: " + this.task.getUrl()));
                break;
            } else if (this.canceled) {
                break;
            } else {
                try {
                    BreakpointInfo breakpointInfo = this.store.get(this.task.getId());
                    if (breakpointInfo == null) {
                        breakpointInfo = this.store.createAndInsert(this.task);
                    }
                    setInfoToTask(breakpointInfo);
                    if (this.canceled) {
                        break;
                    }
                    DownloadCache createCache = createCache(breakpointInfo);
                    this.cache = createCache;
                    BreakpointRemoteCheck createRemoteCheck = createRemoteCheck(breakpointInfo);
                    try {
                        createRemoteCheck.check();
                        createCache.setRedirectLocation(this.task.getRedirectLocation());
                        processFileStrategy.getFileLock().waitForRelease(this.task.getFile().getAbsolutePath());
                        BdDownload.with().downloadStrategy().inspectAnotherSameInfo(this.task, breakpointInfo, createRemoteCheck.getInstanceLength());
                        try {
                            if (createRemoteCheck.isResumable()) {
                                BreakpointLocalCheck createLocalCheck = createLocalCheck(breakpointInfo, createRemoteCheck.getInstanceLength());
                                createLocalCheck.check();
                                if (createLocalCheck.isDirty()) {
                                    Util.d(TAG, "breakpoint invalid: download from beginning because of local check is dirty " + this.task.getId() + " " + createLocalCheck);
                                    processFileStrategy.discardProcess(this.task);
                                    assembleBlockAndCallbackFromBeginning(breakpointInfo, createRemoteCheck, createLocalCheck.getCauseOrThrow());
                                } else {
                                    with.callbackDispatcher().dispatch().downloadFromBreakpoint(this.task, breakpointInfo);
                                }
                            } else {
                                Util.d(TAG, "breakpoint invalid: download from beginning because of remote check not resumable " + this.task.getId() + " " + createRemoteCheck);
                                processFileStrategy.discardProcess(this.task);
                                assembleBlockAndCallbackFromBeginning(breakpointInfo, createRemoteCheck, createRemoteCheck.getCauseOrThrow());
                            }
                            start(createCache, breakpointInfo);
                            if (this.canceled) {
                                break;
                            }
                            if (createCache.isPreconditionFailed()) {
                                int i3 = i2 + 1;
                                if (i2 < 1) {
                                    this.store.remove(this.task.getId());
                                    i2 = i3;
                                    z = true;
                                    continue;
                                    if (!z) {
                                        break;
                                    }
                                } else {
                                    i2 = i3;
                                }
                            }
                            z = false;
                            continue;
                            if (!z) {
                            }
                        } catch (IOException e2) {
                            createCache.setUnknownError(e2);
                        }
                    } catch (IOException e3) {
                        createCache.catchException(e3);
                    }
                } catch (IOException e4) {
                    this.cache = new DownloadCache.PreError(e4);
                }
            }
        }
        this.finishing = true;
        this.blockChainList.clear();
        DownloadCache downloadCache = this.cache;
        if (this.canceled || downloadCache == null) {
            return;
        }
        IOException iOException = null;
        if (!downloadCache.isServerCanceled() && !downloadCache.isUnknownError() && !downloadCache.isPreconditionFailed()) {
            if (downloadCache.isFileBusyAfterRun()) {
                endCause = EndCause.FILE_BUSY;
            } else if (downloadCache.isPreAllocateFailed()) {
                endCause = EndCause.PRE_ALLOCATE_FAILED;
                iOException = downloadCache.getRealCause();
            } else {
                endCause = EndCause.COMPLETED;
            }
        } else {
            endCause = EndCause.ERROR;
            iOException = downloadCache.getRealCause();
        }
        inspectTaskEnd(downloadCache, endCause, iOException);
    }

    @Override // com.baidu.searchbox.bddownload.core.NamedRunnable
    public void finished() {
        BdDownload.with().downloadDispatcher().finish(this);
        Util.d(TAG, "call is finished " + this.task.getId());
    }

    @Nullable
    public File getFile() {
        return this.task.getFile();
    }

    public int getPriority() {
        return this.task.getPriority();
    }

    @Override // com.baidu.searchbox.bddownload.core.NamedRunnable
    public void interrupted(InterruptedException interruptedException) {
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isFinishing() {
        return this.finishing;
    }

    public void setInfoToTask(@NonNull BreakpointInfo breakpointInfo) {
        DownloadTask.TaskHideWrapper.setBreakpointInfo(this.task, breakpointInfo);
    }

    public void start(DownloadCache downloadCache, BreakpointInfo breakpointInfo) throws InterruptedException {
        int blockCount = breakpointInfo.getBlockCount();
        ArrayList arrayList = new ArrayList(breakpointInfo.getBlockCount());
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < blockCount; i2++) {
            BlockInfo block = breakpointInfo.getBlock(i2);
            if (!Util.isCorrectFull(block.getCurrentOffset(), block.getContentLength())) {
                Util.resetBlockIfDirty(block);
                DownloadChain createChain = DownloadChain.createChain(i2, this.task, breakpointInfo, downloadCache, this.store);
                arrayList.add(createChain);
                arrayList2.add(Integer.valueOf(createChain.getBlockIndex()));
            }
        }
        if (this.canceled) {
            return;
        }
        downloadCache.getOutputStream().setRequireStreamBlocks(arrayList2);
        startBlocks(arrayList);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void startBlocks(List<DownloadChain> list) throws InterruptedException {
        ArrayList arrayList = new ArrayList(list.size());
        try {
            for (DownloadChain downloadChain : list) {
                arrayList.add(submitChain(downloadChain));
            }
            this.blockChainList.addAll(list);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Future future = (Future) it.next();
                if (!future.isDone()) {
                    try {
                        future.get();
                    } catch (CancellationException | ExecutionException unused) {
                    }
                }
            }
        } finally {
        }
    }

    public Future<?> submitChain(DownloadChain downloadChain) {
        return EXECUTOR.submit(downloadChain);
    }

    public DownloadCall(DownloadTask downloadTask, boolean z, @NonNull ArrayList<DownloadChain> arrayList, @NonNull DownloadStore downloadStore) {
        super("download call: " + downloadTask.getId());
        this.task = downloadTask;
        this.asyncExecuted = z;
        this.blockChainList = arrayList;
        this.store = downloadStore;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull DownloadCall downloadCall) {
        return PriorityStrategy.compareTaskPriority(downloadCall.task, this.task);
    }
}
