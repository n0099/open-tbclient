package com.baidu.searchbox.bddownload;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.listener.DownloadListener;
import com.baidu.searchbox.bddownload.core.listener.DownloadListenerBunch;
import com.baidu.searchbox.bddownload.core.listener.DownloadTaskStartEndListener;
import com.baidu.searchbox.bddownload.core.priority.PriorityStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class DownloadContext {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Executor SERIAL_EXECUTOR;
    public static final String TAG = "DownloadContext";
    public transient /* synthetic */ FieldHolder $fh;
    public final DownloadContextListener contextListener;
    public final QueueSet set;
    public volatile boolean started;
    public final DownloadTask[] tasks;
    public Handler uiHandler;

    /* loaded from: classes2.dex */
    public class AlterContext {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DownloadContext context;

        public AlterContext(DownloadContext downloadContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = downloadContext;
        }

        public AlterContext replaceTask(DownloadTask downloadTask, DownloadTask downloadTask2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, downloadTask, downloadTask2)) != null) {
                return (AlterContext) invokeLL.objValue;
            }
            DownloadTask[] downloadTaskArr = this.context.tasks;
            for (int i = 0; i < downloadTaskArr.length; i++) {
                if (downloadTaskArr[i] == downloadTask) {
                    downloadTaskArr[i] = downloadTask2;
                }
            }
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ArrayList boundTaskList;
        public DownloadContextListener listener;
        public final QueueSet set;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder() {
            this(new QueueSet());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    this((QueueSet) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public DownloadContext build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new DownloadContext((DownloadTask[]) this.boundTaskList.toArray(new DownloadTask[this.boundTaskList.size()]), this.listener, this.set);
            }
            return (DownloadContext) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(QueueSet queueSet) {
            this(queueSet, new ArrayList());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {queueSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((QueueSet) objArr2[0], (ArrayList) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public void unbind(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                for (DownloadTask downloadTask : (List) this.boundTaskList.clone()) {
                    if (downloadTask.getId() == i) {
                        this.boundTaskList.remove(downloadTask);
                    }
                }
            }
        }

        public Builder(QueueSet queueSet, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {queueSet, arrayList};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.set = queueSet;
            this.boundTaskList = arrayList;
        }

        public DownloadTask bind(String str, PriorityStrategy.Priority priority) throws IllegalArgumentException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, priority)) == null) {
                if (this.set.uri != null) {
                    return bind(new DownloadTask.Builder(str, this.set.uri).setFilenameFromResponse(Boolean.TRUE), priority);
                }
                throw new IllegalArgumentException("If you want to bind only with url, you have to provide parentPath on QueueSet!");
            }
            return (DownloadTask) invokeLL.objValue;
        }

        public DownloadTask bind(DownloadTask.Builder builder, PriorityStrategy.Priority priority) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, builder, priority)) == null) {
                if (this.set.headerMapFields != null) {
                    builder.setHeaderMapFields(this.set.headerMapFields);
                }
                if (this.set.readBufferSize != null) {
                    builder.setReadBufferSize(this.set.readBufferSize.intValue());
                }
                if (this.set.flushBufferSize != null) {
                    builder.setFlushBufferSize(this.set.flushBufferSize.intValue());
                }
                if (this.set.syncBufferSize != null) {
                    builder.setSyncBufferSize(this.set.syncBufferSize.intValue());
                }
                if (this.set.wifiRequired != null) {
                    builder.setWifiRequired(this.set.wifiRequired.booleanValue());
                }
                if (this.set.syncBufferIntervalMillis != null) {
                    builder.setSyncBufferIntervalMillis(this.set.syncBufferIntervalMillis.intValue());
                }
                if (this.set.autoCallbackToUIThread != null) {
                    builder.setAutoCallbackToUIThread(this.set.autoCallbackToUIThread.booleanValue());
                }
                if (this.set.minIntervalMillisCallbackProcess != null) {
                    builder.setMinIntervalMillisCallbackProcess(this.set.minIntervalMillisCallbackProcess.intValue());
                }
                if (this.set.passIfAlreadyCompleted != null) {
                    builder.setPassIfAlreadyCompleted(this.set.passIfAlreadyCompleted.booleanValue());
                }
                if (priority != null) {
                    builder.setPriority(priority);
                }
                DownloadTask build = builder.build();
                if (this.set.tag != null) {
                    build.setTag(this.set.tag);
                }
                this.boundTaskList.add(build);
                return build;
            }
            return (DownloadTask) invokeLL.objValue;
        }

        public Builder bindSetTask(DownloadTask downloadTask) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadTask)) == null) {
                int indexOf = this.boundTaskList.indexOf(downloadTask);
                if (indexOf >= 0) {
                    this.boundTaskList.set(indexOf, downloadTask);
                } else {
                    this.boundTaskList.add(downloadTask);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setListener(DownloadContextListener downloadContextListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadContextListener)) == null) {
                this.listener = downloadContextListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public void unbind(DownloadTask downloadTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, downloadTask) == null) {
                this.boundTaskList.remove(downloadTask);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class QueueAttachTaskStartEndListener extends DownloadTaskStartEndListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DownloadContextListener contextListener;
        public final DownloadContext hostContext;
        public final AtomicInteger remainCount;

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void taskStart(DownloadTask downloadTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask) == null) {
            }
        }

        public QueueAttachTaskStartEndListener(DownloadContext downloadContext, DownloadContextListener downloadContextListener, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadContext, downloadContextListener, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.remainCount = new AtomicInteger(i);
            this.contextListener = downloadContextListener;
            this.hostContext = downloadContext;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, downloadTask, endCause, exc) == null) {
                int decrementAndGet = this.remainCount.decrementAndGet();
                this.contextListener.taskEnd(this.hostContext, downloadTask, endCause, exc, decrementAndGet);
                if (decrementAndGet <= 0) {
                    this.contextListener.queueEnd(this.hostContext);
                    Util.d(DownloadContext.TAG, "taskEnd and remainCount " + decrementAndGet);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class QueueSet {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean autoCallbackToUIThread;
        public Integer flushBufferSize;
        public Map headerMapFields;
        public Integer minIntervalMillisCallbackProcess;
        public Boolean passIfAlreadyCompleted;
        public Integer readBufferSize;
        public Integer syncBufferIntervalMillis;
        public Integer syncBufferSize;
        public Object tag;
        public Uri uri;
        public Boolean wifiRequired;

        public QueueSet() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public Builder commit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new Builder(this);
            }
            return (Builder) invokeV.objValue;
        }

        public Uri getDirUri() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.uri;
            }
            return (Uri) invokeV.objValue;
        }

        public int getFlushBufferSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Integer num = this.flushBufferSize;
                if (num == null) {
                    return 16384;
                }
                return num.intValue();
            }
            return invokeV.intValue;
        }

        public Map getHeaderMapFields() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.headerMapFields;
            }
            return (Map) invokeV.objValue;
        }

        public int getMinIntervalMillisCallbackProcess() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Integer num = this.minIntervalMillisCallbackProcess;
                if (num == null) {
                    return 3000;
                }
                return num.intValue();
            }
            return invokeV.intValue;
        }

        public int getReadBufferSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Integer num = this.readBufferSize;
                if (num == null) {
                    return 4096;
                }
                return num.intValue();
            }
            return invokeV.intValue;
        }

        public int getSyncBufferIntervalMillis() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Integer num = this.syncBufferIntervalMillis;
                if (num == null) {
                    return 2000;
                }
                return num.intValue();
            }
            return invokeV.intValue;
        }

        public int getSyncBufferSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Integer num = this.syncBufferSize;
                if (num == null) {
                    return 65536;
                }
                return num.intValue();
            }
            return invokeV.intValue;
        }

        public Object getTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.tag;
            }
            return invokeV.objValue;
        }

        public boolean isAutoCallbackToUIThread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Boolean bool = this.autoCallbackToUIThread;
                if (bool == null) {
                    return true;
                }
                return bool.booleanValue();
            }
            return invokeV.booleanValue;
        }

        public boolean isPassIfAlreadyCompleted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Boolean bool = this.passIfAlreadyCompleted;
                if (bool == null) {
                    return true;
                }
                return bool.booleanValue();
            }
            return invokeV.booleanValue;
        }

        public boolean isWifiRequired() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                Boolean bool = this.wifiRequired;
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            }
            return invokeV.booleanValue;
        }

        public QueueSet setAutoCallbackToUIThread(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bool)) == null) {
                this.autoCallbackToUIThread = bool;
                return this;
            }
            return (QueueSet) invokeL.objValue;
        }

        public QueueSet setFlushBufferSize(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                this.flushBufferSize = Integer.valueOf(i);
                return this;
            }
            return (QueueSet) invokeI.objValue;
        }

        public void setHeaderMapFields(Map map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
                this.headerMapFields = map;
            }
        }

        public QueueSet setMinIntervalMillisCallbackProcess(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, num)) == null) {
                this.minIntervalMillisCallbackProcess = num;
                return this;
            }
            return (QueueSet) invokeL.objValue;
        }

        public QueueSet setParentPath(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
                return setParentPathFile(new File(str));
            }
            return (QueueSet) invokeL.objValue;
        }

        public QueueSet setParentPathFile(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, file)) == null) {
                if (!file.isFile()) {
                    this.uri = Uri.fromFile(file);
                    return this;
                }
                throw new IllegalArgumentException("parent path only accept directory path");
            }
            return (QueueSet) invokeL.objValue;
        }

        public QueueSet setParentPathUri(Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, uri)) == null) {
                this.uri = uri;
                return this;
            }
            return (QueueSet) invokeL.objValue;
        }

        public QueueSet setPassIfAlreadyCompleted(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
                this.passIfAlreadyCompleted = Boolean.valueOf(z);
                return this;
            }
            return (QueueSet) invokeZ.objValue;
        }

        public QueueSet setReadBufferSize(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
                this.readBufferSize = Integer.valueOf(i);
                return this;
            }
            return (QueueSet) invokeI.objValue;
        }

        public QueueSet setSyncBufferIntervalMillis(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
                this.syncBufferIntervalMillis = Integer.valueOf(i);
                return this;
            }
            return (QueueSet) invokeI.objValue;
        }

        public QueueSet setSyncBufferSize(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
                this.syncBufferSize = Integer.valueOf(i);
                return this;
            }
            return (QueueSet) invokeI.objValue;
        }

        public QueueSet setTag(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, obj)) == null) {
                this.tag = obj;
                return this;
            }
            return (QueueSet) invokeL.objValue;
        }

        public QueueSet setWifiRequired(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, bool)) == null) {
                this.wifiRequired = bool;
                return this;
            }
            return (QueueSet) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(156418719, "Lcom/baidu/searchbox/bddownload/DownloadContext;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(156418719, "Lcom/baidu/searchbox/bddownload/DownloadContext;");
                return;
            }
        }
        SERIAL_EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("BdDownload Serial", false));
    }

    public DownloadContext(DownloadTask[] downloadTaskArr, DownloadContextListener downloadContextListener, QueueSet queueSet) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadTaskArr, downloadContextListener, queueSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.started = false;
        this.tasks = downloadTaskArr;
        this.contextListener = downloadContextListener;
        this.set = queueSet;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadContext(DownloadTask[] downloadTaskArr, DownloadContextListener downloadContextListener, QueueSet queueSet, Handler handler) {
        this(downloadTaskArr, downloadContextListener, queueSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadTaskArr, downloadContextListener, queueSet, handler};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((DownloadTask[]) objArr2[0], (DownloadContextListener) objArr2[1], (QueueSet) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.uiHandler = handler;
    }

    public void addOneTask(int i, DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, downloadListener) == null) {
            this.started = true;
            this.tasks[i].enqueue(downloadListener);
        }
    }

    public void executeOnSerialExecutor(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            SERIAL_EXECUTOR.execute(runnable);
        }
    }

    public void startOnParallel(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadListener) == null) {
            start(downloadListener, false);
        }
    }

    public void startOnSerial(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, downloadListener) == null) {
            start(downloadListener, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackQueueEndOnSerialLoop(boolean z) {
        DownloadContextListener downloadContextListener;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65541, this, z) != null) || (downloadContextListener = this.contextListener) == null) {
            return;
        }
        if (z) {
            if (this.uiHandler == null) {
                this.uiHandler = new Handler(Looper.getMainLooper());
            }
            this.uiHandler.post(new Runnable(this) { // from class: com.baidu.searchbox.bddownload.DownloadContext.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadContext this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        DownloadContext downloadContext = this.this$0;
                        downloadContext.contextListener.queueEnd(downloadContext);
                    }
                }
            });
            return;
        }
        downloadContextListener.queueEnd(this);
    }

    public AlterContext alter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new AlterContext(this);
        }
        return (AlterContext) invokeV.objValue;
    }

    public DownloadTask[] getTasks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.tasks;
        }
        return (DownloadTask[]) invokeV.objValue;
    }

    public boolean isStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.started;
        }
        return invokeV.booleanValue;
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.started) {
                BdDownload.with().downloadDispatcher().cancel(this.tasks);
            }
            this.started = false;
        }
    }

    public Builder toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return new Builder(this.set, new ArrayList(Arrays.asList(this.tasks))).setListener(this.contextListener);
        }
        return (Builder) invokeV.objValue;
    }

    public void start(DownloadListener downloadListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, downloadListener, z) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            Util.d(TAG, "start " + z);
            this.started = true;
            if (this.contextListener != null) {
                downloadListener = new DownloadListenerBunch.Builder().append(downloadListener).append(new QueueAttachTaskStartEndListener(this, this.contextListener, this.tasks.length)).build();
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                Collections.addAll(arrayList, this.tasks);
                Collections.sort(arrayList);
                executeOnSerialExecutor(new Runnable(this, arrayList, downloadListener) { // from class: com.baidu.searchbox.bddownload.DownloadContext.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DownloadContext this$0;
                    public final /* synthetic */ List val$scheduleTaskList;
                    public final /* synthetic */ DownloadListener val$targetListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, arrayList, downloadListener};
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
                        this.val$scheduleTaskList = arrayList;
                        this.val$targetListener = downloadListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            for (DownloadTask downloadTask : this.val$scheduleTaskList) {
                                if (this.this$0.isStarted()) {
                                    downloadTask.execute(this.val$targetListener);
                                } else {
                                    this.this$0.callbackQueueEndOnSerialLoop(downloadTask.isAutoCallbackToUIThread());
                                    return;
                                }
                            }
                        }
                    }
                });
            } else {
                DownloadTask.enqueue(this.tasks, downloadListener);
            }
            Util.d(TAG, "start finish " + z + " " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
        }
    }
}
