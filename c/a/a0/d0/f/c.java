package c.a.a0.d0.f;

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
    public static volatile c f1126g;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f1127b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.a0.d0.f.a f1128c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.a0.d0.f.b f1129d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.a0.d0.e.b f1130e;

    /* renamed from: f  reason: collision with root package name */
    public d f1131f;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                            this.a.f1130e.d(bVar.a, bVar.f1132b, bVar.f1133c);
                        }
                        this.a.r();
                        return;
                    case 2:
                        this.a.r();
                        return;
                    case 3:
                        if (this.a.f1129d.a() > 0) {
                            this.a.r();
                            return;
                        }
                        return;
                    case 4:
                        Object obj2 = message.obj;
                        if (obj2 instanceof b) {
                            b bVar2 = (b) obj2;
                            this.a.f1131f.b(bVar2.a, bVar2.f1132b, bVar2.f1133c);
                            this.a.t();
                            return;
                        }
                        return;
                    case 5:
                        this.a.t();
                        return;
                    case 6:
                        this.a.f1131f.a();
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
        public String f1132b;

        /* renamed from: c  reason: collision with root package name */
        public int f1133c;

        public b(Runnable runnable, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = runnable;
            this.f1132b = str;
            this.f1133c = i;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2111850538, "Lc/a/a0/d0/f/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2111850538, "Lc/a/a0/d0/f/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        synchronized (c.a.a0.d0.a.b()) {
            h();
        }
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f1126g == null) {
                synchronized (c.class) {
                    if (f1126g == null) {
                        f1126g = new c();
                    }
                }
            }
            return f1126g;
        }
        return (c) invokeV.objValue;
    }

    public c.a.a0.d0.e.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1130e : (c.a.a0.d0.e.b) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f1128c = new c.a.a0.d0.f.a();
            this.f1129d = new c.a.a0.d0.f.b();
            this.f1130e = new c.a.a0.d0.e.b();
            this.f1131f = new d();
            HandlerThread handlerThread = new HandlerThread("ElasticSchedulerThread");
            this.a = handlerThread;
            handlerThread.start();
            this.a.setPriority(10);
            this.f1127b = new a(this, this.a.getLooper());
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j(0L);
        }
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            this.f1127b.sendMessageDelayed(obtain, j);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l(0L);
        }
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            this.f1127b.sendMessageDelayed(obtain, j);
        }
    }

    public void m(Runnable runnable, String str, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{runnable, str, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = new b(runnable, str, i);
            this.f1127b.sendMessageDelayed(obtain, j);
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            Message obtain = Message.obtain();
            obtain.what = 6;
            this.f1127b.sendMessageDelayed(obtain, j);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            p(0L);
        }
    }

    public void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            this.f1127b.sendMessageDelayed(obtain, j);
        }
    }

    public void q(Runnable runnable, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{runnable, str, Long.valueOf(j)}) == null) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = new b(runnable, str, 4);
            this.f1127b.sendMessageDelayed(obtain, j);
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
            ElasticTask b2 = this.f1130e.b();
            if (b2 == null) {
                return false;
            }
            if (this.f1128c.a(b2)) {
                this.f1130e.e(b2);
                return true;
            } else if (this.f1129d.c(b2)) {
                this.f1130e.e(b2);
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
            this.f1131f.c();
        }
    }
}
