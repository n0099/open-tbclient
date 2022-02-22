package c.a.d0.d0.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile c f2673g;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f2674b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d0.d0.f.a f2675c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.d0.d0.f.b f2676d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d0.d0.e.b f2677e;

    /* renamed from: f  reason: collision with root package name */
    public d f2678f;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        Object obj = message.obj;
                        if (obj instanceof b) {
                            b bVar = (b) obj;
                            this.a.f2677e.d(bVar.a, bVar.f2679b, bVar.f2680c);
                        }
                        this.a.r();
                        return;
                    case 2:
                        this.a.r();
                        return;
                    case 3:
                        if (this.a.f2676d.a() > 0) {
                            this.a.r();
                            return;
                        }
                        return;
                    case 4:
                        Object obj2 = message.obj;
                        if (obj2 instanceof b) {
                            b bVar2 = (b) obj2;
                            this.a.f2678f.b(bVar2.a, bVar2.f2679b, bVar2.f2680c);
                            this.a.t();
                            return;
                        }
                        return;
                    case 5:
                        this.a.t();
                        return;
                    case 6:
                        this.a.f2678f.a();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Runnable a;

        /* renamed from: b  reason: collision with root package name */
        public String f2679b;

        /* renamed from: c  reason: collision with root package name */
        public int f2680c;

        public b(Runnable runnable, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = runnable;
            this.f2679b = str;
            this.f2680c = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1522310023, "Lc/a/d0/d0/f/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1522310023, "Lc/a/d0/d0/f/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        synchronized (c.a.d0.d0.a.b()) {
            h();
        }
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f2673g == null) {
                synchronized (c.class) {
                    if (f2673g == null) {
                        f2673g = new c();
                    }
                }
            }
            return f2673g;
        }
        return (c) invokeV.objValue;
    }

    public c.a.d0.d0.e.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2677e : (c.a.d0.d0.e.b) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f2675c = new c.a.d0.d0.f.a();
            this.f2676d = new c.a.d0.d0.f.b();
            this.f2677e = new c.a.d0.d0.e.b();
            this.f2678f = new d();
            HandlerThread handlerThread = new HandlerThread("ElasticSchedulerThread");
            this.a = handlerThread;
            handlerThread.start();
            this.a.setPriority(10);
            this.f2674b = new a(this, this.a.getLooper());
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j(0L);
        }
    }

    public void j(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            this.f2674b.sendMessageDelayed(obtain, j2);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l(0L);
        }
    }

    public void l(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            this.f2674b.sendMessageDelayed(obtain, j2);
        }
    }

    public void m(Runnable runnable, String str, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{runnable, str, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = new b(runnable, str, i2);
            this.f2674b.sendMessageDelayed(obtain, j2);
        }
    }

    public void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            Message obtain = Message.obtain();
            obtain.what = 6;
            this.f2674b.sendMessageDelayed(obtain, j2);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            p(0L);
        }
    }

    public void p(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            this.f2674b.sendMessageDelayed(obtain, j2);
        }
    }

    public void q(Runnable runnable, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{runnable, str, Long.valueOf(j2)}) == null) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = new b(runnable, str, 4);
            this.f2674b.sendMessageDelayed(obtain, j2);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            do {
            } while (s());
            i();
        }
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ElasticTask b2 = this.f2677e.b();
            if (b2 == null) {
                return false;
            }
            if (this.f2675c.a(b2)) {
                this.f2677e.e(b2);
                return true;
            } else if (this.f2676d.c(b2)) {
                this.f2677e.e(b2);
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f2678f.c();
        }
    }
}
