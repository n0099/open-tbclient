package com.baidu.searchbox.dns.transmit.task;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class Dispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService executorService;
    public int maxRequests;
    public int maxRequestsPerType;
    public final Queue<AsyncTask> readyAsyncTasks;
    public final Queue<AsyncTask> runningAsyncTasks;

    public abstract Queue<AsyncTask> getReadyDeque();

    public abstract Queue<AsyncTask> getRunningDeque();

    public String getTaskThreadName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "Searchbox Dispatcher #" : (String) invokeV.objValue;
    }

    public Dispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.maxRequests = 15;
        this.maxRequestsPerType = 1;
        this.readyAsyncTasks = getReadyDeque();
        this.runningAsyncTasks = getRunningDeque();
    }

    public synchronized ExecutorService executorService() {
        InterceptResult invokeV;
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (this.executorService == null) {
                    this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory(getTaskThreadName(), false));
                }
                executorService = this.executorService;
            }
            return executorService;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public synchronized List<AsyncTask> readyTasks() {
        InterceptResult invokeV;
        List<AsyncTask> unmodifiableList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                for (AsyncTask asyncTask : this.readyAsyncTasks) {
                    arrayList.add(asyncTask);
                }
                unmodifiableList = Collections.unmodifiableList(arrayList);
            }
            return unmodifiableList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized List<AsyncTask> runningTasks() {
        InterceptResult invokeV;
        List<AsyncTask> unmodifiableList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                for (AsyncTask asyncTask : this.runningAsyncTasks) {
                    arrayList.add(asyncTask);
                }
                unmodifiableList = Collections.unmodifiableList(arrayList);
            }
            return unmodifiableList;
        }
        return (List) invokeV.objValue;
    }

    private synchronized boolean cancelTask(AsyncTask asyncTask, Queue<AsyncTask> queue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, asyncTask, queue)) == null) {
            synchronized (this) {
                if (asyncTask != null && queue != null) {
                    if (queue.size() > 0) {
                        Iterator<AsyncTask> it = queue.iterator();
                        while (it.hasNext()) {
                            if (asyncTask.tag().equals(it.next().tag())) {
                                asyncTask.onCancel();
                                it.remove();
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private synchronized void cancelTasks(Queue<AsyncTask> queue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, queue) == null) {
            synchronized (this) {
                if (queue != null) {
                    if (queue.size() > 0) {
                        Iterator<AsyncTask> it = queue.iterator();
                        while (it.hasNext()) {
                            it.next().onCancel();
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    private int runningTasksForType(AsyncTask asyncTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, asyncTask)) == null) {
            int i = 0;
            for (AsyncTask asyncTask2 : this.runningAsyncTasks) {
                if (asyncTask2.getTaskType().equals(asyncTask.getTaskType())) {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public synchronized void enqueue(AsyncTask asyncTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, asyncTask) == null) {
            synchronized (this) {
                if (this.runningAsyncTasks.size() < this.maxRequests && runningTasksForType(asyncTask) < this.maxRequestsPerType) {
                    this.runningAsyncTasks.add(asyncTask);
                    executorService().execute(asyncTask);
                } else {
                    this.readyAsyncTasks.add(asyncTask);
                }
            }
        }
    }

    public synchronized void setMaxRequests(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            synchronized (this) {
                if (i >= 1) {
                    this.maxRequests = i;
                    promoteTasks();
                } else {
                    throw new IllegalArgumentException("max < 1: " + i);
                }
            }
        }
    }

    public synchronized void setMaxRequestsPerType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            synchronized (this) {
                if (i >= 1) {
                    this.maxRequestsPerType = i;
                    promoteTasks();
                } else {
                    throw new IllegalArgumentException("max < 1: " + i);
                }
            }
        }
    }

    private synchronized void promoteTasks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            synchronized (this) {
                if (this.runningAsyncTasks.size() >= this.maxRequests) {
                    return;
                }
                if (this.readyAsyncTasks.isEmpty()) {
                    return;
                }
                Iterator<AsyncTask> it = this.readyAsyncTasks.iterator();
                while (it.hasNext()) {
                    AsyncTask next = it.next();
                    if (runningTasksForType(next) < this.maxRequestsPerType) {
                        it.remove();
                        this.runningAsyncTasks.add(next);
                        executorService().execute(next);
                    }
                    if (this.runningAsyncTasks.size() >= this.maxRequests) {
                        return;
                    }
                }
            }
        }
    }

    private ThreadFactory threadFactory(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, this, str, z)) == null) {
            return new ThreadFactory(this, str, z) { // from class: com.baidu.searchbox.dns.transmit.task.Dispatcher.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final AtomicInteger mCount;
                public final /* synthetic */ Dispatcher this$0;
                public final /* synthetic */ boolean val$daemon;
                public final /* synthetic */ String val$name;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$name = str;
                    this.val$daemon = z;
                    this.mCount = new AtomicInteger(1);
                }

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                        Thread thread = new Thread(runnable, this.val$name + this.mCount.getAndIncrement());
                        thread.setDaemon(this.val$daemon);
                        return thread;
                    }
                    return (Thread) invokeL.objValue;
                }
            };
        }
        return (ThreadFactory) invokeLZ.objValue;
    }

    public void cancelAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            cancelAllReadyTasks();
            cancelAllRunningTasks();
        }
    }

    public void cancelAllReadyTasks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            cancelTasks(this.readyAsyncTasks);
        }
    }

    public void cancelAllRunningTasks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            cancelTasks(this.runningAsyncTasks);
            promoteTasks();
        }
    }

    public synchronized int getMaxRequests() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i = this.maxRequests;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int getMaxRequestsPerType() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                i = this.maxRequestsPerType;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int readyTasksCount() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                size = this.readyAsyncTasks.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized int runningTasksCount() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            synchronized (this) {
                size = this.runningAsyncTasks.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public boolean cancelTask(AsyncTask asyncTask) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, asyncTask)) == null) {
            if (!cancelTask(asyncTask, this.readyAsyncTasks) && !cancelTask(asyncTask, this.runningAsyncTasks)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                promoteTasks();
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public synchronized void finished(AsyncTask asyncTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, asyncTask) == null) {
            synchronized (this) {
                this.runningAsyncTasks.remove(asyncTask);
                promoteTasks();
            }
        }
    }
}
