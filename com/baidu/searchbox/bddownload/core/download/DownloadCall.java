package com.baidu.searchbox.bddownload.core.download;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public class DownloadCall extends NamedRunnable implements Comparable<DownloadCall> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ExecutorService EXECUTOR;
    public static final int MAX_COUNT_RETRY_FOR_PRECONDITION_FAILED = 1;
    public static final String TAG = "DownloadCall";
    public transient /* synthetic */ FieldHolder $fh;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(117346995, "Lcom/baidu/searchbox/bddownload/core/download/DownloadCall;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(117346995, "Lcom/baidu/searchbox/bddownload/core/download/DownloadCall;");
                return;
            }
        }
        EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("BdDownload Block", false));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadCall(DownloadTask downloadTask, boolean z, @NonNull DownloadStore downloadStore) {
        this(downloadTask, z, new ArrayList(), downloadStore);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadTask, Boolean.valueOf(z), downloadStore};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((DownloadTask) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (ArrayList) objArr2[2], (DownloadStore) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static DownloadCall create(DownloadTask downloadTask, boolean z, @NonNull DownloadStore downloadStore) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{downloadTask, Boolean.valueOf(z), downloadStore})) == null) ? new DownloadCall(downloadTask, z, downloadStore) : (DownloadCall) invokeCommon.objValue;
    }

    private void inspectTaskEnd(DownloadCache downloadCache, @NonNull EndCause endCause, @Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, downloadCache, endCause, exc) == null) {
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
    }

    private void inspectTaskStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.store.onTaskStart(this.task.getId());
            BdDownload.with().callbackDispatcher().dispatch().taskStart(this.task);
        }
    }

    public void assembleBlockAndCallbackFromBeginning(@NonNull BreakpointInfo breakpointInfo, @NonNull BreakpointRemoteCheck breakpointRemoteCheck, @NonNull ResumeFailedCause resumeFailedCause) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, breakpointInfo, breakpointRemoteCheck, resumeFailedCause) == null) {
            Util.assembleBlock(this.task, breakpointInfo, breakpointRemoteCheck.getInstanceLength(), breakpointRemoteCheck.isAcceptRange());
            BdDownload.with().callbackDispatcher().dispatch().downloadFromBeginning(this.task, breakpointInfo, resumeFailedCause);
        }
    }

    public boolean cancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public DownloadCache createCache(@NonNull BreakpointInfo breakpointInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, breakpointInfo)) == null) ? new DownloadCache(BdDownload.with().processFileStrategy().createProcessStream(this.task, breakpointInfo, this.store)) : (DownloadCache) invokeL.objValue;
    }

    @NonNull
    public BreakpointLocalCheck createLocalCheck(@NonNull BreakpointInfo breakpointInfo, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, breakpointInfo, j)) == null) ? new BreakpointLocalCheck(this.task, breakpointInfo, j) : (BreakpointLocalCheck) invokeLJ.objValue;
    }

    @NonNull
    public BreakpointRemoteCheck createRemoteCheck(@NonNull BreakpointInfo breakpointInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, breakpointInfo)) == null) ? new BreakpointRemoteCheck(this.task, breakpointInfo) : (BreakpointRemoteCheck) invokeL.objValue;
    }

    public boolean equalsTask(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, downloadTask)) == null) ? this.task.equals(downloadTask) : invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0160 A[EDGE_INSN: B:77:0x0160->B:47:0x0160 ?: BREAK  , SYNTHETIC] */
    @Override // com.baidu.searchbox.bddownload.core.NamedRunnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() throws InterruptedException {
        EndCause endCause;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.currentThread = Thread.currentThread();
            BdDownload with = BdDownload.with();
            ProcessFileStrategy processFileStrategy = with.processFileStrategy();
            inspectTaskStart();
            int i = 0;
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
                                    int i2 = i + 1;
                                    if (i < 1) {
                                        this.store.remove(this.task.getId());
                                        i = i2;
                                        z = true;
                                        continue;
                                        if (!z) {
                                            break;
                                        }
                                    } else {
                                        i = i2;
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
    }

    @Override // com.baidu.searchbox.bddownload.core.NamedRunnable
    public void finished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            BdDownload.with().downloadDispatcher().finish(this);
            Util.d(TAG, "call is finished " + this.task.getId());
        }
    }

    @Nullable
    public File getFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.task.getFile() : (File) invokeV.objValue;
    }

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.task.getPriority() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.NamedRunnable
    public void interrupted(InterruptedException interruptedException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interruptedException) == null) {
        }
    }

    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.canceled : invokeV.booleanValue;
    }

    public boolean isFinishing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.finishing : invokeV.booleanValue;
    }

    public void setInfoToTask(@NonNull BreakpointInfo breakpointInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, breakpointInfo) == null) {
            DownloadTask.TaskHideWrapper.setBreakpointInfo(this.task, breakpointInfo);
        }
    }

    public void start(DownloadCache downloadCache, BreakpointInfo breakpointInfo) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, downloadCache, breakpointInfo) == null) {
            int blockCount = breakpointInfo.getBlockCount();
            ArrayList arrayList = new ArrayList(breakpointInfo.getBlockCount());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < blockCount; i++) {
                BlockInfo block = breakpointInfo.getBlock(i);
                if (!Util.isCorrectFull(block.getCurrentOffset(), block.getContentLength())) {
                    Util.resetBlockIfDirty(block);
                    DownloadChain createChain = DownloadChain.createChain(i, this.task, breakpointInfo, downloadCache, this.store);
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
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void startBlocks(List<DownloadChain> list) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, list) != null) {
            return;
        }
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, downloadChain)) == null) ? EXECUTOR.submit(downloadChain) : (Future) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadCall(DownloadTask downloadTask, boolean z, @NonNull ArrayList<DownloadChain> arrayList, @NonNull DownloadStore downloadStore) {
        super("download call: " + downloadTask.getId());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadTask, Boolean.valueOf(z), arrayList, downloadStore};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.task = downloadTask;
        this.asyncExecuted = z;
        this.blockChainList = arrayList;
        this.store = downloadStore;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull DownloadCall downloadCall) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadCall)) == null) ? PriorityStrategy.compareTaskPriority(downloadCall.task, this.task) : invokeL.intValue;
    }
}
