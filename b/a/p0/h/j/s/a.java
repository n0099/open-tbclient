package b.a.p0.h.j.s;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import b.a.p0.h.j.b;
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
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10693a;

    /* renamed from: b  reason: collision with root package name */
    public static long f10694b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f10695c;

    /* renamed from: d  reason: collision with root package name */
    public static long f10696d;

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f10697e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f10698f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.h.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0563a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C0563a f10699e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1098900045, "Lb/a/p0/h/j/s/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1098900045, "Lb/a/p0/h/j/s/a$a;");
                    return;
                }
            }
            f10699e = new C0563a();
        }

        public C0563a() {
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
                if (msg.what == 0 && a.f10698f.g()) {
                    a aVar = a.f10698f;
                    if (a.f10694b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        a aVar2 = a.f10698f;
                        a aVar3 = a.f10698f;
                        a.f10694b = (a.f10694b + elapsedRealtime) - a.f10696d;
                        a aVar4 = a.f10698f;
                        a.f10696d = elapsedRealtime;
                        a aVar5 = a.f10698f;
                        Handler handler = a.f10695c;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 1000L);
                        }
                        a aVar6 = a.f10698f;
                        if ((a.f10694b / 1000) % 15 == 0) {
                            b bVar = b.o;
                            a aVar7 = a.f10698f;
                            bVar.U(a.f10694b);
                            return true;
                        }
                        return true;
                    }
                }
                a aVar8 = a.f10698f;
                a.f10696d = 0L;
                a.f10698f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1779912490, "Lb/a/p0/h/j/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1779912490, "Lb/a/p0/h/j/s/a;");
                return;
            }
        }
        f10698f = new a();
        f10697e = C0563a.f10699e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f10694b : invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f10693a : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j = f10694b;
            if (j < 30000) {
                return;
            }
            f10694b = j % 30000;
            b.o.M();
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            f10693a = z;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f10695c == null) {
                f10695c = new Handler(f10697e);
            }
            f10694b = b.o.A();
            f10693a = true;
            f10696d = SystemClock.elapsedRealtime();
            Handler handler = f10695c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f10693a = false;
            Handler handler = f10695c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (f10696d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                f10694b = (f10694b + elapsedRealtime) - f10696d;
                f10696d = elapsedRealtime;
            }
            b.o.U(f10694b);
        }
    }
}
