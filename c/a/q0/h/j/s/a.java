package c.a.q0.h.j.s;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import c.a.q0.h.j.b;
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
    public static long f10170b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f10171c;

    /* renamed from: d  reason: collision with root package name */
    public static long f10172d;

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f10173e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f10174f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.q0.h.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0653a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C0653a f10175e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2136160561, "Lc/a/q0/h/j/s/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2136160561, "Lc/a/q0/h/j/s/a$a;");
                    return;
                }
            }
            f10175e = new C0653a();
        }

        public C0653a() {
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
                if (msg.what == 0 && a.f10174f.g()) {
                    a aVar = a.f10174f;
                    if (a.f10170b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        a aVar2 = a.f10174f;
                        a aVar3 = a.f10174f;
                        a.f10170b = (a.f10170b + elapsedRealtime) - a.f10172d;
                        a aVar4 = a.f10174f;
                        a.f10172d = elapsedRealtime;
                        a aVar5 = a.f10174f;
                        Handler handler = a.f10171c;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 1000L);
                        }
                        a aVar6 = a.f10174f;
                        if ((a.f10170b / 1000) % 15 == 0) {
                            b bVar = b.o;
                            a aVar7 = a.f10174f;
                            bVar.U(a.f10170b);
                            return true;
                        }
                        return true;
                    }
                }
                a aVar8 = a.f10174f;
                a.f10172d = 0L;
                a.f10174f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1490512940, "Lc/a/q0/h/j/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1490512940, "Lc/a/q0/h/j/s/a;");
                return;
            }
        }
        f10174f = new a();
        f10173e = C0653a.f10175e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f10170b : invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j2 = f10170b;
            if (j2 < 30000) {
                return;
            }
            f10170b = j2 % 30000;
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
            if (f10171c == null) {
                f10171c = new Handler(f10173e);
            }
            f10170b = b.o.A();
            a = true;
            f10172d = SystemClock.elapsedRealtime();
            Handler handler = f10171c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a = false;
            Handler handler = f10171c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (f10172d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                f10170b = (f10170b + elapsedRealtime) - f10172d;
                f10172d = elapsedRealtime;
            }
            b.o.U(f10170b);
        }
    }
}
