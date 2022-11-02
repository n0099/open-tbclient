package com.baidu.searchbox.elasticthread.task;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
/* loaded from: classes2.dex */
public class ElasticTask implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public transient /* synthetic */ FieldHolder $fh;
    public long id;
    public ElasticTaskCallback mCallback;
    public Runnable mTaskEntity;
    public String name;
    public int priority;
    public Status status;
    public long timeOnComplete;
    public long timeOnExecute;
    public long timeOnQueue;

    /* loaded from: classes2.dex */
    public interface ElasticTaskCallback {
        void afterExecuteTask();

        void beforeExecuteTask();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class Status {
        public static final /* synthetic */ Status[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Status COMPLETE;
        public static final Status RUNNING;
        public static final Status WAITING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-971268993, "Lcom/baidu/searchbox/elasticthread/task/ElasticTask$Status;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-971268993, "Lcom/baidu/searchbox/elasticthread/task/ElasticTask$Status;");
                    return;
                }
            }
            WAITING = new Status("WAITING", 0);
            RUNNING = new Status(TornadoLiteRuntime.STATE_RUNNING, 1);
            Status status = new Status("COMPLETE", 2);
            COMPLETE = status;
            $VALUES = new Status[]{WAITING, RUNNING, status};
        }

        public Status(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Status valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Status) Enum.valueOf(Status.class, str);
            }
            return (Status) invokeL.objValue;
        }

        public static Status[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Status[]) $VALUES.clone();
            }
            return (Status[]) invokeV.objValue;
        }
    }

    public ElasticTask(Runnable runnable, String str, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {runnable, str, Long.valueOf(j), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.status = Status.WAITING;
        this.mTaskEntity = runnable;
        this.id = j;
        this.name = str;
        this.priority = i;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.priority;
        }
        return invokeV.intValue;
    }

    public synchronized void recordCompleteTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.status = Status.COMPLETE;
                this.timeOnComplete = SystemClock.elapsedRealtime();
            }
        }
    }

    public synchronized void recordEnqueueTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                this.status = Status.WAITING;
                this.timeOnQueue = SystemClock.elapsedRealtime();
            }
        }
    }

    public synchronized void recordExecuteTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.status = Status.RUNNING;
                this.timeOnExecute = SystemClock.elapsedRealtime();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                if (this.mCallback != null) {
                    this.mCallback.beforeExecuteTask();
                }
            } catch (Exception unused) {
            }
            this.mTaskEntity.run();
            try {
                if (this.mCallback != null) {
                    this.mCallback.afterExecuteTask();
                }
            } catch (Exception unused2) {
            }
        }
    }

    public synchronized long getRawWorkTime() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.status == Status.WAITING) {
                    return 0L;
                }
                if (this.status == Status.RUNNING) {
                    j = SystemClock.elapsedRealtime();
                } else {
                    j = this.timeOnComplete;
                }
                return Math.max(0L, j - this.timeOnExecute);
            }
        }
        return invokeV.longValue;
    }

    public synchronized long getWaitingTime() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.timeOnQueue == 0) {
                    return 0L;
                }
                if (this.status == Status.WAITING) {
                    j = SystemClock.elapsedRealtime();
                } else {
                    j = this.timeOnExecute;
                }
                return Math.max(0L, j - this.timeOnQueue);
            }
        }
        return invokeV.longValue;
    }

    public synchronized long getWorkTimeInRecordLifeCycle(long j, long j2) {
        InterceptResult invokeCommon;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (this) {
                if (this.status == Status.WAITING) {
                    return 0L;
                }
                long max = Math.max(this.timeOnExecute, j);
                if (this.status == Status.RUNNING) {
                    j3 = SystemClock.elapsedRealtime();
                } else {
                    j3 = this.timeOnComplete;
                }
                return Math.max(0L, Math.min(j3, j2) - max);
            }
        }
        return invokeCommon.longValue;
    }

    public void setElasticTaskCallback(ElasticTaskCallback elasticTaskCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, elasticTaskCallback) == null) {
            this.mCallback = elasticTaskCallback;
        }
    }
}
