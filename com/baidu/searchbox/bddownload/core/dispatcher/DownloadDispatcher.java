package com.baidu.searchbox.bddownload.core.dispatcher;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.StatusUtil;
import com.baidu.searchbox.bddownload.core.IdentifiedTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.download.DownloadCall;
import java.io.File;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class DownloadDispatcher {
    public static final String TAG = "DownloadDispatcher";
    public int cancleSecondsFromRunning;
    @Nullable
    public volatile ExecutorService executorService;
    public final List<DownloadCall> finishingCalls;
    public final AtomicInteger flyingCanceledAsyncCallCount;
    public int maxParallelRunningCount;
    public final List<DownloadCall> readyAsyncCalls;
    public final List<DownloadCall> runningAsyncCalls;
    public final List<DownloadCall> runningSyncCalls;
    public final AtomicInteger skipProceedCallCount;
    public DownloadStore store;

    public DownloadDispatcher() {
        this(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
    }

    private synchronized void cancelLocked(IdentifiedTask[] identifiedTaskArr) {
        long uptimeMillis = SystemClock.uptimeMillis();
        Util.d(TAG, "start cancel bunch task manually: " + identifiedTaskArr.length);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (IdentifiedTask identifiedTask : identifiedTaskArr) {
            filterCanceledCalls(identifiedTask, arrayList, arrayList2);
        }
        handleCanceledCalls(arrayList, arrayList2);
        Util.d(TAG, "finish cancel bunch task manually: " + identifiedTaskArr.length + " consume " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
    }

    private synchronized void enqueueIgnorePriority(DownloadTask downloadTask) {
        DownloadCall create = DownloadCall.create(downloadTask, true, this.store);
        if (runningAsyncSize() < this.maxParallelRunningCount) {
            this.runningAsyncCalls.add(create);
            getExecutorService().execute(create);
        } else {
            filterReadyCalls(create);
        }
    }

    private synchronized void enqueueLocked(DownloadTask[] downloadTaskArr) {
        long uptimeMillis = SystemClock.uptimeMillis();
        Util.d(TAG, "start enqueueLocked for bunch task: " + downloadTaskArr.length);
        ArrayList<DownloadTask> arrayList = new ArrayList();
        Collections.addAll(arrayList, downloadTaskArr);
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        int size = this.readyAsyncCalls.size();
        try {
            BdDownload.with().downloadStrategy().inspectNetworkAvailable();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (DownloadTask downloadTask : arrayList) {
                if (!inspectCompleted(downloadTask, arrayList2) && !inspectForConflict(downloadTask, arrayList3, arrayList4)) {
                    enqueueIgnorePriority(downloadTask);
                }
            }
            BdDownload.with().callbackDispatcher().endTasks(arrayList2, arrayList3, arrayList4);
        } catch (UnknownHostException e2) {
            BdDownload.with().callbackDispatcher().endTasksWithError(new ArrayList(arrayList), e2);
        }
        if (size != this.readyAsyncCalls.size()) {
            Collections.sort(this.readyAsyncCalls);
        }
        Util.d(TAG, "end enqueueLocked for bunch task: " + downloadTaskArr.length + " consume " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0046 A[Catch: all -> 0x0090, TryCatch #0 {, blocks: (B:3:0x0001, B:4:0x0007, B:6:0x000d, B:8:0x0017, B:10:0x0023, B:12:0x0029, B:15:0x0030, B:20:0x003a, B:21:0x0040, B:23:0x0046, B:25:0x0050, B:27:0x005c, B:30:0x0064, B:31:0x006a, B:33:0x0070, B:35:0x007a, B:37:0x0086), top: B:45:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070 A[Catch: all -> 0x0090, TryCatch #0 {, blocks: (B:3:0x0001, B:4:0x0007, B:6:0x000d, B:8:0x0017, B:10:0x0023, B:12:0x0029, B:15:0x0030, B:20:0x003a, B:21:0x0040, B:23:0x0046, B:25:0x0050, B:27:0x005c, B:30:0x0064, B:31:0x006a, B:33:0x0070, B:35:0x007a, B:37:0x0086), top: B:45:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000d A[Catch: all -> 0x0090, TryCatch #0 {, blocks: (B:3:0x0001, B:4:0x0007, B:6:0x000d, B:8:0x0017, B:10:0x0023, B:12:0x0029, B:15:0x0030, B:20:0x003a, B:21:0x0040, B:23:0x0046, B:25:0x0050, B:27:0x005c, B:30:0x0064, B:31:0x006a, B:33:0x0070, B:35:0x007a, B:37:0x0086), top: B:45:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void filterCanceledCalls(@NonNull IdentifiedTask identifiedTask, @NonNull List<DownloadCall> list, @NonNull List<DownloadCall> list2) {
        Iterator<DownloadCall> it = this.readyAsyncCalls.iterator();
        while (it.hasNext()) {
            DownloadCall next = it.next();
            if (next.task == identifiedTask || next.task.getId() == identifiedTask.getId()) {
                if (!next.isCanceled() && !next.isFinishing()) {
                    it.remove();
                    list.add(next);
                    return;
                }
                return;
            }
            while (it.hasNext()) {
            }
        }
        for (DownloadCall downloadCall : this.runningAsyncCalls) {
            if (downloadCall.task == identifiedTask || downloadCall.task.getId() == identifiedTask.getId()) {
                list.add(downloadCall);
                list2.add(downloadCall);
                return;
            }
            while (r0.hasNext()) {
            }
        }
        for (DownloadCall downloadCall2 : this.runningSyncCalls) {
            if (downloadCall2.task == identifiedTask || downloadCall2.task.getId() == identifiedTask.getId()) {
                list.add(downloadCall2);
                list2.add(downloadCall2);
                return;
            }
            while (r0.hasNext()) {
            }
        }
    }

    private synchronized void filterReadyCalls(DownloadCall downloadCall) {
        int i2 = Integer.MAX_VALUE;
        ArrayList arrayList = new ArrayList();
        for (DownloadCall downloadCall2 : this.runningAsyncCalls) {
            if (!downloadCall2.isCanceled()) {
                if (downloadCall2.task.getLastSeconds() >= this.cancleSecondsFromRunning) {
                    arrayList.add(downloadCall2);
                }
                if (downloadCall2.getPriority() <= i2) {
                    i2 = downloadCall2.getPriority();
                }
            }
        }
        if (downloadCall.getPriority() > i2) {
            Collections.sort(arrayList);
            if (arrayList.size() > 0) {
                DownloadCall downloadCall3 = (DownloadCall) arrayList.get(arrayList.size() - 1);
                if (downloadCall3.cancel()) {
                    BdDownload.with().callbackDispatcher().dispatch().taskEnd(downloadCall3.task, EndCause.ADJUSTMENT, null);
                    this.runningAsyncCalls.add(downloadCall);
                    getExecutorService().execute(downloadCall);
                    this.readyAsyncCalls.add(downloadCall3);
                    Collections.sort(this.readyAsyncCalls);
                }
            }
        } else {
            arrayList.clear();
            this.readyAsyncCalls.add(downloadCall);
            Collections.sort(this.readyAsyncCalls);
        }
    }

    private synchronized void handleCanceledCalls(@NonNull List<DownloadCall> list, @NonNull List<DownloadCall> list2) {
        Util.d(TAG, "handle cancel calls, cancel calls: " + list2.size());
        if (!list2.isEmpty()) {
            for (DownloadCall downloadCall : list2) {
                if (!downloadCall.cancel()) {
                    list.remove(downloadCall);
                }
            }
        }
        Util.d(TAG, "handle cancel calls, callback cancel event: " + list.size());
        if (!list.isEmpty()) {
            if (list.size() <= 1) {
                BdDownload.with().callbackDispatcher().dispatch().taskEnd(list.get(0).task, EndCause.CANCELED, null);
            } else {
                ArrayList arrayList = new ArrayList();
                for (DownloadCall downloadCall2 : list) {
                    arrayList.add(downloadCall2.task);
                }
                BdDownload.with().callbackDispatcher().endTasksWithCanceled(arrayList);
            }
        }
    }

    private boolean inspectForConflict(@NonNull DownloadTask downloadTask) {
        return inspectForConflict(downloadTask, null, null);
    }

    private void printTaskList(List<DownloadCall> list) {
        for (DownloadCall downloadCall : list) {
            Util.d(TAG, "printTaskList: getPriority " + downloadCall.getPriority());
            Util.d(TAG, "printTaskList: getId " + downloadCall.task.getId());
            Util.d(TAG, "printTaskList: getLastSeconds " + downloadCall.task.getLastSeconds());
        }
    }

    private synchronized void processCalls() {
        Util.d(TAG, "task: processCalls  ");
        if (this.skipProceedCallCount.get() > 0) {
            return;
        }
        if (runningAsyncSize() >= this.maxParallelRunningCount) {
            return;
        }
        if (this.readyAsyncCalls.isEmpty()) {
            return;
        }
        Util.d(TAG, "task: processCalls runningAsyncSize() " + runningAsyncSize());
        Iterator<DownloadCall> it = this.readyAsyncCalls.iterator();
        while (it.hasNext()) {
            DownloadCall next = it.next();
            it.remove();
            DownloadTask downloadTask = next.task;
            if (isFileConflictAfterRun(downloadTask)) {
                BdDownload.with().callbackDispatcher().dispatch().taskEnd(downloadTask, EndCause.FILE_BUSY, null);
            } else {
                if (next.isCanceled()) {
                    enqueue(next.task);
                } else {
                    this.runningAsyncCalls.add(next);
                    getExecutorService().execute(next);
                }
                if (runningAsyncSize() >= this.maxParallelRunningCount) {
                    return;
                }
            }
        }
    }

    private int runningAsyncSize() {
        return this.runningAsyncCalls.size() - this.flyingCanceledAsyncCallCount.get();
    }

    public static void setMaxParallelRunningCount(int i2) {
        DownloadDispatcher downloadDispatcher = BdDownload.with().downloadDispatcher();
        if (downloadDispatcher.getClass() == DownloadDispatcher.class) {
            downloadDispatcher.maxParallelRunningCount = Math.max(1, i2);
            return;
        }
        throw new IllegalStateException("The current dispatcher is " + downloadDispatcher + " not DownloadDispatcher exactly!");
    }

    public void cancel(IdentifiedTask[] identifiedTaskArr) {
        this.skipProceedCallCount.incrementAndGet();
        cancelLocked(identifiedTaskArr);
        this.skipProceedCallCount.decrementAndGet();
        processCalls();
    }

    public void cancelAll() {
        this.skipProceedCallCount.incrementAndGet();
        ArrayList arrayList = new ArrayList();
        for (DownloadCall downloadCall : this.readyAsyncCalls) {
            arrayList.add(downloadCall.task);
        }
        for (DownloadCall downloadCall2 : this.runningAsyncCalls) {
            arrayList.add(downloadCall2.task);
        }
        for (DownloadCall downloadCall3 : this.runningSyncCalls) {
            arrayList.add(downloadCall3.task);
        }
        if (!arrayList.isEmpty()) {
            cancelLocked((IdentifiedTask[]) arrayList.toArray(new DownloadTask[arrayList.size()]));
        }
        this.skipProceedCallCount.decrementAndGet();
    }

    public void enqueue(DownloadTask[] downloadTaskArr) {
        this.skipProceedCallCount.incrementAndGet();
        enqueueLocked(downloadTaskArr);
        this.skipProceedCallCount.decrementAndGet();
    }

    public void execute(DownloadTask downloadTask) {
        Util.d(TAG, "execute: " + downloadTask);
        synchronized (this) {
            if (inspectCompleted(downloadTask)) {
                return;
            }
            if (inspectForConflict(downloadTask)) {
                return;
            }
            DownloadCall create = DownloadCall.create(downloadTask, false, this.store);
            this.runningSyncCalls.add(create);
            syncRunCall(create);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000d A[Catch: all -> 0x0028, TryCatch #0 {, blocks: (B:3:0x0001, B:4:0x0007, B:6:0x000d, B:8:0x0017), top: B:18:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized DownloadCall findRunningCall(DownloadTask downloadTask) {
        for (DownloadCall downloadCall : this.runningAsyncCalls) {
            if (downloadTask == downloadCall.task || downloadTask.getId() == downloadCall.task.getId()) {
                return downloadCall;
            }
            while (r0.hasNext()) {
            }
        }
        return null;
    }

    @Nullable
    public synchronized DownloadTask findSameTask(DownloadTask downloadTask) {
        Util.d(TAG, "findSameTask: " + downloadTask.getId());
        for (DownloadCall downloadCall : this.readyAsyncCalls) {
            if (!downloadCall.isCanceled() && downloadCall.equalsTask(downloadTask)) {
                return downloadCall.task;
            }
        }
        for (DownloadCall downloadCall2 : this.runningAsyncCalls) {
            if (!downloadCall2.isCanceled() && downloadCall2.equalsTask(downloadTask)) {
                return downloadCall2.task;
            }
        }
        for (DownloadCall downloadCall3 : this.runningSyncCalls) {
            if (!downloadCall3.isCanceled() && downloadCall3.equalsTask(downloadTask)) {
                return downloadCall3.task;
            }
        }
        return null;
    }

    public synchronized void finish(DownloadCall downloadCall) {
        List<DownloadCall> list;
        Util.d(TAG, "task: finish taskId  " + downloadCall.task.getId());
        boolean z = downloadCall.asyncExecuted;
        if (this.finishingCalls.contains(downloadCall)) {
            list = this.finishingCalls;
            Util.d(TAG, "task: finish finishingCalls  " + downloadCall.task.getId());
        } else if (z) {
            list = this.runningAsyncCalls;
            Util.d(TAG, "task: finish runningAsyncCalls  " + downloadCall.task.getId());
        } else {
            list = this.runningSyncCalls;
            Util.d(TAG, "task: finish runningSyncCalls  " + downloadCall.task.getId());
        }
        if (list.remove(downloadCall)) {
            if (z && downloadCall.isCanceled()) {
                this.flyingCanceledAsyncCallCount.decrementAndGet();
            }
            if (z) {
                processCalls();
            }
        } else {
            throw new AssertionError("Call wasn't in-flight!");
        }
    }

    public synchronized void flyingCanceled(DownloadCall downloadCall) {
        Util.d(TAG, "flying canceled: " + downloadCall.task.getId());
        if (downloadCall.asyncExecuted) {
            this.flyingCanceledAsyncCallCount.incrementAndGet();
        }
    }

    public synchronized ExecutorService getExecutorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("BdDownload Download", false));
        }
        return this.executorService;
    }

    public boolean inspectCompleted(@NonNull DownloadTask downloadTask) {
        return inspectCompleted(downloadTask, null);
    }

    public synchronized boolean isFileConflictAfterRun(@NonNull DownloadTask downloadTask) {
        File file;
        File file2;
        Util.d(TAG, "is file conflict after run: " + downloadTask.getId());
        File file3 = downloadTask.getFile();
        if (file3 == null) {
            return false;
        }
        for (DownloadCall downloadCall : this.runningSyncCalls) {
            if (!downloadCall.isCanceled() && downloadCall.task != downloadTask && (file2 = downloadCall.task.getFile()) != null && file3.equals(file2)) {
                return true;
            }
        }
        for (DownloadCall downloadCall2 : this.runningAsyncCalls) {
            if (!downloadCall2.isCanceled() && downloadCall2.task != downloadTask && (file = downloadCall2.task.getFile()) != null && file3.equals(file)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean isPending(DownloadTask downloadTask) {
        Util.d(TAG, "isPending: " + downloadTask.getId());
        for (DownloadCall downloadCall : this.readyAsyncCalls) {
            if (!downloadCall.isCanceled() && downloadCall.equalsTask(downloadTask)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean isRunning(DownloadTask downloadTask) {
        Util.d(TAG, "isRunning: " + downloadTask.getId());
        for (DownloadCall downloadCall : this.runningSyncCalls) {
            if (!downloadCall.isCanceled() && downloadCall.equalsTask(downloadTask)) {
                return true;
            }
        }
        for (DownloadCall downloadCall2 : this.runningAsyncCalls) {
            if (!downloadCall2.isCanceled() && downloadCall2.equalsTask(downloadTask)) {
                return true;
            }
        }
        return false;
    }

    public void setDownloadStore(@NonNull DownloadStore downloadStore) {
        this.store = downloadStore;
    }

    public void syncRunCall(DownloadCall downloadCall) {
        downloadCall.run();
    }

    public DownloadDispatcher(List<DownloadCall> list, List<DownloadCall> list2, List<DownloadCall> list3, List<DownloadCall> list4) {
        this.maxParallelRunningCount = 4;
        this.cancleSecondsFromRunning = 2;
        this.flyingCanceledAsyncCallCount = new AtomicInteger();
        this.skipProceedCallCount = new AtomicInteger();
        this.readyAsyncCalls = list;
        this.runningAsyncCalls = list2;
        this.runningSyncCalls = list3;
        this.finishingCalls = list4;
    }

    private boolean inspectForConflict(@NonNull DownloadTask downloadTask, @Nullable Collection<DownloadTask> collection, @Nullable Collection<DownloadTask> collection2) {
        return inspectForConflict(downloadTask, this.readyAsyncCalls, collection, collection2) || inspectForConflict(downloadTask, this.runningAsyncCalls, collection, collection2) || inspectForConflict(downloadTask, this.runningSyncCalls, collection, collection2);
    }

    public boolean inspectCompleted(@NonNull DownloadTask downloadTask, @Nullable Collection<DownloadTask> collection) {
        if (downloadTask.isPassIfAlreadyCompleted() && StatusUtil.isCompleted(downloadTask)) {
            if (downloadTask.getFilename() != null || BdDownload.with().downloadStrategy().validFilenameFromStore(downloadTask)) {
                BdDownload.with().downloadStrategy().validInfoOnCompleted(downloadTask, this.store);
                if (collection != null) {
                    collection.add(downloadTask);
                    return true;
                }
                BdDownload.with().callbackDispatcher().dispatch().taskEnd(downloadTask, EndCause.COMPLETED, null);
                return true;
            }
            return false;
        }
        return false;
    }

    public void enqueue(DownloadTask downloadTask) {
        this.skipProceedCallCount.incrementAndGet();
        enqueueLocked(downloadTask);
        this.skipProceedCallCount.decrementAndGet();
    }

    public boolean cancel(IdentifiedTask identifiedTask) {
        this.skipProceedCallCount.incrementAndGet();
        boolean cancelLocked = cancelLocked(identifiedTask);
        this.skipProceedCallCount.decrementAndGet();
        processCalls();
        return cancelLocked;
    }

    public boolean inspectForConflict(@NonNull DownloadTask downloadTask, @NonNull Collection<DownloadCall> collection, @Nullable Collection<DownloadTask> collection2, @Nullable Collection<DownloadTask> collection3) {
        CallbackDispatcher callbackDispatcher = BdDownload.with().callbackDispatcher();
        Iterator<DownloadCall> it = collection.iterator();
        while (it.hasNext()) {
            DownloadCall next = it.next();
            if (!next.isCanceled()) {
                if (next.equalsTask(downloadTask)) {
                    if (!next.isFinishing()) {
                        if (collection2 != null) {
                            collection2.add(downloadTask);
                        } else {
                            callbackDispatcher.dispatch().taskEnd(downloadTask, EndCause.SAME_TASK_BUSY, null);
                        }
                        return true;
                    }
                    Util.d(TAG, "task: " + downloadTask.getId() + " is finishing, move it to finishing list");
                    this.finishingCalls.add(next);
                    it.remove();
                    return false;
                }
                File file = next.getFile();
                File file2 = downloadTask.getFile();
                if (file != null && file2 != null && file.equals(file2)) {
                    if (collection3 != null) {
                        collection3.add(downloadTask);
                    } else {
                        callbackDispatcher.dispatch().taskEnd(downloadTask, EndCause.FILE_BUSY, null);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cancel(int i2) {
        this.skipProceedCallCount.incrementAndGet();
        boolean cancelLocked = cancelLocked(DownloadTask.mockTaskForCompare(i2));
        this.skipProceedCallCount.decrementAndGet();
        processCalls();
        return cancelLocked;
    }

    public synchronized boolean cancelLocked(IdentifiedTask identifiedTask) {
        boolean z;
        Util.d(TAG, "cancel manually: " + identifiedTask.getId());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        filterCanceledCalls(identifiedTask, arrayList, arrayList2);
        handleCanceledCalls(arrayList, arrayList2);
        if (arrayList.size() <= 0) {
            z = arrayList2.size() > 0;
        }
        return z;
    }

    private synchronized void enqueueLocked(DownloadTask downloadTask) {
        Util.d(TAG, "enqueueLocked for single task: " + downloadTask);
        if (inspectCompleted(downloadTask)) {
            return;
        }
        if (inspectForConflict(downloadTask)) {
            return;
        }
        int size = this.readyAsyncCalls.size();
        enqueueIgnorePriority(downloadTask);
        if (size != this.readyAsyncCalls.size()) {
            Collections.sort(this.readyAsyncCalls);
        }
    }
}
