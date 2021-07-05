package com.baidu.searchbox.bddownload.core.dispatcher;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.StatusUtil;
import com.baidu.searchbox.bddownload.core.IdentifiedTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.download.DownloadCall;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes3.dex */
public class DownloadDispatcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DownloadDispatcher";
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadDispatcher() {
        this(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((List) objArr[0], (List) objArr[1], (List) objArr[2], (List) objArr[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private synchronized void cancelLocked(IdentifiedTask[] identifiedTaskArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, identifiedTaskArr) == null) {
            synchronized (this) {
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
        }
    }

    private synchronized void enqueueIgnorePriority(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, downloadTask) == null) {
            synchronized (this) {
                DownloadCall create = DownloadCall.create(downloadTask, true, this.store);
                if (runningAsyncSize() < this.maxParallelRunningCount) {
                    this.runningAsyncCalls.add(create);
                    getExecutorService().execute(create);
                } else {
                    filterReadyCalls(create);
                }
            }
        }
    }

    private synchronized void enqueueLocked(DownloadTask[] downloadTaskArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, downloadTaskArr) == null) {
            synchronized (this) {
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
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004a A[Catch: all -> 0x0094, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000b, B:8:0x0011, B:10:0x001b, B:12:0x0027, B:14:0x002d, B:17:0x0034, B:22:0x003e, B:23:0x0044, B:25:0x004a, B:27:0x0054, B:29:0x0060, B:32:0x0068, B:33:0x006e, B:35:0x0074, B:37:0x007e, B:39:0x008a), top: B:50:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0074 A[Catch: all -> 0x0094, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000b, B:8:0x0011, B:10:0x001b, B:12:0x0027, B:14:0x002d, B:17:0x0034, B:22:0x003e, B:23:0x0044, B:25:0x004a, B:27:0x0054, B:29:0x0060, B:32:0x0068, B:33:0x006e, B:35:0x0074, B:37:0x007e, B:39:0x008a), top: B:50:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011 A[Catch: all -> 0x0094, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000b, B:8:0x0011, B:10:0x001b, B:12:0x0027, B:14:0x002d, B:17:0x0034, B:22:0x003e, B:23:0x0044, B:25:0x004a, B:27:0x0054, B:29:0x0060, B:32:0x0068, B:33:0x006e, B:35:0x0074, B:37:0x007e, B:39:0x008a), top: B:50:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void filterCanceledCalls(@NonNull IdentifiedTask identifiedTask, @NonNull List<DownloadCall> list, @NonNull List<DownloadCall> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, identifiedTask, list, list2) == null) {
            synchronized (this) {
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
        }
    }

    private synchronized void filterReadyCalls(DownloadCall downloadCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, downloadCall) == null) {
            synchronized (this) {
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
        }
    }

    private synchronized void handleCanceledCalls(@NonNull List<DownloadCall> list, @NonNull List<DownloadCall> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, list, list2) == null) {
            synchronized (this) {
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
        }
    }

    private boolean inspectForConflict(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, this, downloadTask)) == null) ? inspectForConflict(downloadTask, null, null) : invokeL.booleanValue;
    }

    private void printTaskList(List<DownloadCall> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, list) == null) {
            for (DownloadCall downloadCall : list) {
                Util.d(TAG, "printTaskList: getPriority " + downloadCall.getPriority());
                Util.d(TAG, "printTaskList: getId " + downloadCall.task.getId());
                Util.d(TAG, "printTaskList: getLastSeconds " + downloadCall.task.getLastSeconds());
            }
        }
    }

    private synchronized void processCalls() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            synchronized (this) {
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
        }
    }

    private int runningAsyncSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? this.runningAsyncCalls.size() - this.flyingCanceledAsyncCallCount.get() : invokeV.intValue;
    }

    public static void setMaxParallelRunningCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i2) == null) {
            DownloadDispatcher downloadDispatcher = BdDownload.with().downloadDispatcher();
            if (downloadDispatcher.getClass() == DownloadDispatcher.class) {
                downloadDispatcher.maxParallelRunningCount = Math.max(1, i2);
                return;
            }
            throw new IllegalStateException("The current dispatcher is " + downloadDispatcher + " not DownloadDispatcher exactly!");
        }
    }

    public void cancel(IdentifiedTask[] identifiedTaskArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, identifiedTaskArr) == null) {
            this.skipProceedCallCount.incrementAndGet();
            cancelLocked(identifiedTaskArr);
            this.skipProceedCallCount.decrementAndGet();
            processCalls();
        }
    }

    public void cancelAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
    }

    public void enqueue(DownloadTask[] downloadTaskArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadTaskArr) == null) {
            this.skipProceedCallCount.incrementAndGet();
            enqueueLocked(downloadTaskArr);
            this.skipProceedCallCount.decrementAndGet();
        }
    }

    public void execute(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, downloadTask) == null) {
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
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0011 A[Catch: all -> 0x002c, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000b, B:8:0x0011, B:10:0x001b), top: B:24:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized DownloadCall findRunningCall(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadTask)) == null) {
            synchronized (this) {
                for (DownloadCall downloadCall : this.runningAsyncCalls) {
                    if (downloadTask == downloadCall.task || downloadTask.getId() == downloadCall.task.getId()) {
                        return downloadCall;
                    }
                    while (r0.hasNext()) {
                    }
                }
                return null;
            }
        }
        return (DownloadCall) invokeL.objValue;
    }

    @Nullable
    public synchronized DownloadTask findSameTask(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, downloadTask)) == null) {
            synchronized (this) {
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
        }
        return (DownloadTask) invokeL.objValue;
    }

    public synchronized void finish(DownloadCall downloadCall) {
        List<DownloadCall> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, downloadCall) == null) {
            synchronized (this) {
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
        }
    }

    public synchronized void flyingCanceled(DownloadCall downloadCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, downloadCall) == null) {
            synchronized (this) {
                Util.d(TAG, "flying canceled: " + downloadCall.task.getId());
                if (downloadCall.asyncExecuted) {
                    this.flyingCanceledAsyncCallCount.incrementAndGet();
                }
            }
        }
    }

    public synchronized ExecutorService getExecutorService() {
        InterceptResult invokeV;
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                if (this.executorService == null) {
                    this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("BdDownload Download", false));
                }
                executorService = this.executorService;
            }
            return executorService;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public boolean inspectCompleted(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, downloadTask)) == null) ? inspectCompleted(downloadTask, null) : invokeL.booleanValue;
    }

    public synchronized boolean isFileConflictAfterRun(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        File file;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, downloadTask)) == null) {
            synchronized (this) {
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
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean isPending(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, downloadTask)) == null) {
            synchronized (this) {
                Util.d(TAG, "isPending: " + downloadTask.getId());
                for (DownloadCall downloadCall : this.readyAsyncCalls) {
                    if (!downloadCall.isCanceled() && downloadCall.equalsTask(downloadTask)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean isRunning(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, downloadTask)) == null) {
            synchronized (this) {
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
        }
        return invokeL.booleanValue;
    }

    public void setDownloadStore(@NonNull DownloadStore downloadStore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, downloadStore) == null) {
            this.store = downloadStore;
        }
    }

    public void syncRunCall(DownloadCall downloadCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, downloadCall) == null) {
            downloadCall.run();
        }
    }

    public DownloadDispatcher(List<DownloadCall> list, List<DownloadCall> list2, List<DownloadCall> list3, List<DownloadCall> list4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, list2, list3, list4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, this, downloadTask, collection, collection2)) == null) ? inspectForConflict(downloadTask, this.readyAsyncCalls, collection, collection2) || inspectForConflict(downloadTask, this.runningAsyncCalls, collection, collection2) || inspectForConflict(downloadTask, this.runningSyncCalls, collection, collection2) : invokeLLL.booleanValue;
    }

    public boolean inspectCompleted(@NonNull DownloadTask downloadTask, @Nullable Collection<DownloadTask> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, downloadTask, collection)) == null) {
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
        return invokeLL.booleanValue;
    }

    public void enqueue(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, downloadTask) == null) {
            this.skipProceedCallCount.incrementAndGet();
            enqueueLocked(downloadTask);
            this.skipProceedCallCount.decrementAndGet();
        }
    }

    public boolean cancel(IdentifiedTask identifiedTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, identifiedTask)) == null) {
            this.skipProceedCallCount.incrementAndGet();
            boolean cancelLocked = cancelLocked(identifiedTask);
            this.skipProceedCallCount.decrementAndGet();
            processCalls();
            return cancelLocked;
        }
        return invokeL.booleanValue;
    }

    public boolean inspectForConflict(@NonNull DownloadTask downloadTask, @NonNull Collection<DownloadCall> collection, @Nullable Collection<DownloadTask> collection2, @Nullable Collection<DownloadTask> collection3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048591, this, downloadTask, collection, collection2, collection3)) == null) {
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
        return invokeLLLL.booleanValue;
    }

    public boolean cancel(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.skipProceedCallCount.incrementAndGet();
            boolean cancelLocked = cancelLocked(DownloadTask.mockTaskForCompare(i2));
            this.skipProceedCallCount.decrementAndGet();
            processCalls();
            return cancelLocked;
        }
        return invokeI.booleanValue;
    }

    public synchronized boolean cancelLocked(IdentifiedTask identifiedTask) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, identifiedTask)) == null) {
            synchronized (this) {
                Util.d(TAG, "cancel manually: " + identifiedTask.getId());
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                filterCanceledCalls(identifiedTask, arrayList, arrayList2);
                handleCanceledCalls(arrayList, arrayList2);
                if (arrayList.size() <= 0) {
                    z = arrayList2.size() > 0;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    private synchronized void enqueueLocked(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, downloadTask) == null) {
            synchronized (this) {
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
    }
}
