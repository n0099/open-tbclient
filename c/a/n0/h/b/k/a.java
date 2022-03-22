package c.a.n0.h.b.k;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import c.a.n0.h.b.b;
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
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static long f8473b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f8474c;

    /* renamed from: d  reason: collision with root package name */
    public static long f8475d;

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f8476e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f8477f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.h.b.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0671a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public static final C0671a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1752401756, "Lc/a/n0/h/b/k/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1752401756, "Lc/a/n0/h/b/k/a$a;");
                    return;
                }
            }
            a = new C0671a();
        }

        public C0671a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (msg.what == 0 && a.f8477f.g()) {
                    a aVar = a.f8477f;
                    if (a.f8473b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        a aVar2 = a.f8477f;
                        a aVar3 = a.f8477f;
                        a.f8473b = (a.f8473b + elapsedRealtime) - a.f8475d;
                        a aVar4 = a.f8477f;
                        a.f8475d = elapsedRealtime;
                        a aVar5 = a.f8477f;
                        Handler handler = a.f8474c;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 1000L);
                        }
                        a aVar6 = a.f8477f;
                        if ((a.f8473b / 1000) % 15 == 0) {
                            b bVar = b.o;
                            a aVar7 = a.f8477f;
                            bVar.U(a.f8473b);
                            return true;
                        }
                        return true;
                    }
                }
                a aVar8 = a.f8477f;
                a.f8475d = 0L;
                a.f8477f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1937839111, "Lc/a/n0/h/b/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1937839111, "Lc/a/n0/h/b/k/a;");
                return;
            }
        }
        f8477f = new a();
        f8476e = C0671a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f8473b : invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j = f8473b;
            if (j < 30000) {
                return;
            }
            f8473b = j % 30000;
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
            if (f8474c == null) {
                f8474c = new Handler(f8476e);
            }
            f8473b = b.o.A();
            a = true;
            f8475d = SystemClock.elapsedRealtime();
            Handler handler = f8474c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a = false;
            Handler handler = f8474c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (f8475d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                f8473b = (f8473b + elapsedRealtime) - f8475d;
                f8475d = elapsedRealtime;
            }
            b.o.U(f8473b);
        }
    }
}
