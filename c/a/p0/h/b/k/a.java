package c.a.p0.h.b.k;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import c.a.p0.h.b.b;
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
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static long f10129b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f10130c;

    /* renamed from: d  reason: collision with root package name */
    public static long f10131d;

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f10132e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f10133f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.h.b.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0677a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C0677a f10134e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1165595742, "Lc/a/p0/h/b/k/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1165595742, "Lc/a/p0/h/b/k/a$a;");
                    return;
                }
            }
            f10134e = new C0677a();
        }

        public C0677a() {
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
                if (msg.what == 0 && a.f10133f.g()) {
                    a aVar = a.f10133f;
                    if (a.f10129b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        a aVar2 = a.f10133f;
                        a aVar3 = a.f10133f;
                        a.f10129b = (a.f10129b + elapsedRealtime) - a.f10131d;
                        a aVar4 = a.f10133f;
                        a.f10131d = elapsedRealtime;
                        a aVar5 = a.f10133f;
                        Handler handler = a.f10130c;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 1000L);
                        }
                        a aVar6 = a.f10133f;
                        if ((a.f10129b / 1000) % 15 == 0) {
                            b bVar = b.o;
                            a aVar7 = a.f10133f;
                            bVar.U(a.f10129b);
                            return true;
                        }
                        return true;
                    }
                }
                a aVar8 = a.f10133f;
                a.f10131d = 0L;
                a.f10133f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1236774533, "Lc/a/p0/h/b/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1236774533, "Lc/a/p0/h/b/k/a;");
                return;
            }
        }
        f10133f = new a();
        f10132e = C0677a.f10134e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f10129b : invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j2 = f10129b;
            if (j2 < 30000) {
                return;
            }
            f10129b = j2 % 30000;
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
            if (f10130c == null) {
                f10130c = new Handler(f10132e);
            }
            f10129b = b.o.A();
            a = true;
            f10131d = SystemClock.elapsedRealtime();
            Handler handler = f10130c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a = false;
            Handler handler = f10130c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (f10131d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                f10129b = (f10129b + elapsedRealtime) - f10131d;
                f10131d = elapsedRealtime;
            }
            b.o.U(f10129b);
        }
    }
}
