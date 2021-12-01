package c.a.p0.h.j.s;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import c.a.p0.h.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static long f9861b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f9862c;

    /* renamed from: d  reason: collision with root package name */
    public static long f9863d;

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f9864e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f9865f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.h.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0619a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C0619a f9866e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1842757554, "Lc/a/p0/h/j/s/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1842757554, "Lc/a/p0/h/j/s/a$a;");
                    return;
                }
            }
            f9866e = new C0619a();
        }

        public C0619a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message msg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, msg)) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.what == 0 && a.f9865f.g()) {
                    a aVar = a.f9865f;
                    if (a.f9861b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        a aVar2 = a.f9865f;
                        a aVar3 = a.f9865f;
                        a.f9861b = (a.f9861b + elapsedRealtime) - a.f9863d;
                        a aVar4 = a.f9865f;
                        a.f9863d = elapsedRealtime;
                        a aVar5 = a.f9865f;
                        Handler handler = a.f9862c;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 1000L);
                        }
                        a aVar6 = a.f9865f;
                        if ((a.f9861b / 1000) % 15 == 0) {
                            b bVar = b.o;
                            a aVar7 = a.f9865f;
                            bVar.U(a.f9861b);
                            return true;
                        }
                        return true;
                    }
                }
                a aVar8 = a.f9865f;
                a.f9863d = 0L;
                a.f9865f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1007502997, "Lc/a/p0/h/j/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1007502997, "Lc/a/p0/h/j/s/a;");
                return;
            }
        }
        f9865f = new a();
        f9864e = C0619a.f9866e;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f9861b : invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j2 = f9861b;
            if (j2 < 30000) {
                return;
            }
            f9861b = j2 % 30000;
            b.o.M();
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            a = z;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f9862c == null) {
                f9862c = new Handler(f9864e);
            }
            f9861b = b.o.A();
            a = true;
            f9863d = SystemClock.elapsedRealtime();
            Handler handler = f9862c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a = false;
            Handler handler = f9862c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (f9863d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                f9861b = (f9861b + elapsedRealtime) - f9863d;
                f9863d = elapsedRealtime;
            }
            b.o.U(f9861b);
        }
    }
}
