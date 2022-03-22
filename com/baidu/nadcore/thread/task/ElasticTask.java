package com.baidu.nadcore.thread.task;

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
/* loaded from: classes4.dex */
public class ElasticTask implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable a;

    /* renamed from: b  reason: collision with root package name */
    public a f27646b;

    /* renamed from: c  reason: collision with root package name */
    public String f27647c;

    /* renamed from: d  reason: collision with root package name */
    public int f27648d;

    /* renamed from: e  reason: collision with root package name */
    public long f27649e;

    /* renamed from: f  reason: collision with root package name */
    public long f27650f;

    /* renamed from: g  reason: collision with root package name */
    public long f27651g;

    /* renamed from: h  reason: collision with root package name */
    public Status f27652h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1232467507, "Lcom/baidu/nadcore/thread/task/ElasticTask$Status;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1232467507, "Lcom/baidu/nadcore/thread/task/ElasticTask$Status;");
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Status) Enum.valueOf(Status.class, str) : (Status) invokeL.objValue;
        }

        public static Status[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Status[]) $VALUES.clone() : (Status[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface a {
        void afterExecuteTask();

        void beforeExecuteTask();
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
        this.f27652h = Status.WAITING;
        this.a = runnable;
        this.f27647c = str;
        this.f27648d = i;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27647c : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27648d : invokeV.intValue;
    }

    public synchronized long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.f27652h == Status.WAITING) {
                    return 0L;
                }
                return Math.max(0L, (this.f27652h == Status.RUNNING ? SystemClock.elapsedRealtime() : this.f27651g) - this.f27650f);
            }
        }
        return invokeV.longValue;
    }

    public synchronized long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.f27649e == 0) {
                    return 0L;
                }
                return Math.max(0L, (this.f27652h == Status.WAITING ? SystemClock.elapsedRealtime() : this.f27650f) - this.f27649e);
            }
        }
        return invokeV.longValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.f27652h = Status.COMPLETE;
                this.f27651g = SystemClock.elapsedRealtime();
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.f27652h = Status.WAITING;
                this.f27649e = SystemClock.elapsedRealtime();
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                this.f27652h = Status.RUNNING;
                this.f27650f = SystemClock.elapsedRealtime();
            }
        }
    }

    public void h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f27646b = aVar;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                if (this.f27646b != null) {
                    this.f27646b.beforeExecuteTask();
                }
            } catch (Exception unused) {
            }
            this.a.run();
            try {
                if (this.f27646b != null) {
                    this.f27646b.afterExecuteTask();
                }
            } catch (Exception unused2) {
            }
        }
    }
}
