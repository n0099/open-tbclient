package com.baidu.searchbox.bddownload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.listener.DownloadListener;
import com.baidu.searchbox.bddownload.core.listener.DownloadListenerBunch;
import com.baidu.searchbox.bddownload.core.listener.DownloadTaskStartEndListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class DownloadSerialQueueTaskStartEndListener extends DownloadTaskStartEndListener implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ID_INVALID = 0;
    public static final Executor SERIAL_EXECUTOR;
    public static final String TAG = "DownloadSerialQueueTaskStartEndListener";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public DownloadListenerBunch listenerBunch;
    public volatile boolean looping;
    public volatile boolean paused;
    public volatile DownloadTask runningTask;
    public volatile boolean shutedDown;
    public final ArrayList<DownloadTask> taskList;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(707661727, "Lcom/baidu/searchbox/bddownload/DownloadSerialQueueTaskStartEndListener;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(707661727, "Lcom/baidu/searchbox/bddownload/DownloadSerialQueueTaskStartEndListener;");
                return;
            }
        }
        SERIAL_EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("BdDownload DynamicSerial", false));
    }

    @Override // java.lang.Runnable
    public void run() {
        DownloadTask remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            while (!this.shutedDown) {
                synchronized (this) {
                    if (!this.taskList.isEmpty() && !this.paused) {
                        remove = this.taskList.remove(0);
                    }
                    this.runningTask = null;
                    this.looping = false;
                    return;
                }
                remove.execute(this.listenerBunch);
            }
        }
    }

    public synchronized DownloadTask[] shutdown() {
        InterceptResult invokeV;
        DownloadTask[] downloadTaskArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                this.shutedDown = true;
                if (this.runningTask != null) {
                    this.runningTask.cancel();
                }
                downloadTaskArr = new DownloadTask[this.taskList.size()];
                this.taskList.toArray(downloadTaskArr);
                this.taskList.clear();
            }
            return downloadTaskArr;
        }
        return (DownloadTask[]) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadSerialQueueTaskStartEndListener() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((DownloadListener) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public int getWaitingTaskCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.taskList.size();
        }
        return invokeV.intValue;
    }

    public int getWorkingTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.runningTask != null) {
                return this.runningTask.getId();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void startNewLooper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SERIAL_EXECUTOR.execute(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadSerialQueueTaskStartEndListener(DownloadListener downloadListener) {
        this(downloadListener, new ArrayList());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((DownloadListener) objArr2[0], (ArrayList) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public DownloadSerialQueueTaskStartEndListener(DownloadListener downloadListener, ArrayList<DownloadTask> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadListener, arrayList};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.shutedDown = false;
        this.looping = false;
        this.paused = false;
        this.listenerBunch = new DownloadListenerBunch.Builder().append(this).append(downloadListener).build();
        this.taskList = arrayList;
    }

    public synchronized void enqueue(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadTask) == null) {
            synchronized (this) {
                this.taskList.add(downloadTask);
                Collections.sort(this.taskList);
                if (!this.paused && !this.looping) {
                    this.looping = true;
                    startNewLooper();
                }
            }
        }
    }

    public void setListener(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadListener) == null) {
            this.listenerBunch = new DownloadListenerBunch.Builder().append(this).append(downloadListener).build();
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void taskStart(@NonNull DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, downloadTask) == null) {
            this.runningTask = downloadTask;
        }
    }

    public synchronized void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.paused) {
                    Util.w(TAG, "require pause this queue(remain " + this.taskList.size() + "), butit has already been paused");
                    return;
                }
                this.paused = true;
                if (this.runningTask != null) {
                    this.runningTask.cancel();
                    this.taskList.add(0, this.runningTask);
                    this.runningTask = null;
                }
            }
        }
    }

    public synchronized void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (!this.paused) {
                    Util.w(TAG, "require resume this queue(remain " + this.taskList.size() + "), but it is still running");
                    return;
                }
                this.paused = false;
                if (!this.taskList.isEmpty() && !this.looping) {
                    this.looping = true;
                    startNewLooper();
                }
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public synchronized void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, downloadTask, endCause, exc) == null) {
            synchronized (this) {
                if (endCause != EndCause.CANCELED && downloadTask == this.runningTask) {
                    this.runningTask = null;
                }
            }
        }
    }
}
