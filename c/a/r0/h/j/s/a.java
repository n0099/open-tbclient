package c.a.r0.h.j.s;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import c.a.r0.h.j.b;
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
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static long f10662b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f10663c;

    /* renamed from: d  reason: collision with root package name */
    public static long f10664d;

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f10665e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f10666f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.h.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0712a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C0712a f10667e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1865403728, "Lc/a/r0/h/j/s/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1865403728, "Lc/a/r0/h/j/s/a$a;");
                    return;
                }
            }
            f10667e = new C0712a();
        }

        public C0712a() {
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
                if (msg.what == 0 && a.f10666f.g()) {
                    a aVar = a.f10666f;
                    if (a.f10662b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        a aVar2 = a.f10666f;
                        a aVar3 = a.f10666f;
                        a.f10662b = (a.f10662b + elapsedRealtime) - a.f10664d;
                        a aVar4 = a.f10666f;
                        a.f10664d = elapsedRealtime;
                        a aVar5 = a.f10666f;
                        Handler handler = a.f10663c;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 1000L);
                        }
                        a aVar6 = a.f10666f;
                        if ((a.f10662b / 1000) % 15 == 0) {
                            b bVar = b.o;
                            a aVar7 = a.f10666f;
                            bVar.U(a.f10662b);
                            return true;
                        }
                        return true;
                    }
                }
                a aVar8 = a.f10666f;
                a.f10664d = 0L;
                a.f10666f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-306438419, "Lc/a/r0/h/j/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-306438419, "Lc/a/r0/h/j/s/a;");
                return;
            }
        }
        f10666f = new a();
        f10665e = C0712a.f10667e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f10662b : invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j2 = f10662b;
            if (j2 < 30000) {
                return;
            }
            f10662b = j2 % 30000;
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
            if (f10663c == null) {
                f10663c = new Handler(f10665e);
            }
            f10662b = b.o.A();
            a = true;
            f10664d = SystemClock.elapsedRealtime();
            Handler handler = f10663c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a = false;
            Handler handler = f10663c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (f10664d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                f10662b = (f10662b + elapsedRealtime) - f10664d;
                f10664d = elapsedRealtime;
            }
            b.o.U(f10662b);
        }
    }
}
