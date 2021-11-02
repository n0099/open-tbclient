package b.a.p0.f.j.s;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import b.a.p0.f.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10022a;

    /* renamed from: b  reason: collision with root package name */
    public static long f10023b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f10024c;

    /* renamed from: d  reason: collision with root package name */
    public static long f10025d;

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f10026e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f10027f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.f.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0535a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C0535a f10028e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1491927055, "Lb/a/p0/f/j/s/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1491927055, "Lb/a/p0/f/j/s/a$a;");
                    return;
                }
            }
            f10028e = new C0535a();
        }

        public C0535a() {
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
        public final boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 0 && a.f10027f.g()) {
                    a aVar = a.f10027f;
                    if (a.f10023b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        a aVar2 = a.f10027f;
                        a aVar3 = a.f10027f;
                        a.f10023b = (a.f10023b + elapsedRealtime) - a.f10025d;
                        a aVar4 = a.f10027f;
                        a.f10025d = elapsedRealtime;
                        a aVar5 = a.f10027f;
                        Handler handler = a.f10024c;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 1000L);
                        }
                        a aVar6 = a.f10027f;
                        if ((a.f10023b / 1000) % 15 == 0) {
                            b bVar = b.o;
                            a aVar7 = a.f10027f;
                            bVar.U(a.f10023b);
                            return true;
                        }
                        return true;
                    }
                }
                a aVar8 = a.f10027f;
                a.f10025d = 0L;
                a.f10027f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1705708180, "Lb/a/p0/f/j/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1705708180, "Lb/a/p0/f/j/s/a;");
                return;
            }
        }
        f10027f = new a();
        f10026e = C0535a.f10028e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f10023b : invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f10022a : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j = f10023b;
            if (j < 30000) {
                return;
            }
            f10023b = j % 30000;
            b.o.M();
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            f10022a = z;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f10024c == null) {
                f10024c = new Handler(f10026e);
            }
            f10023b = b.o.A();
            f10022a = true;
            f10025d = SystemClock.elapsedRealtime();
            Handler handler = f10024c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f10022a = false;
            Handler handler = f10024c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (f10025d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                f10023b = (f10023b + elapsedRealtime) - f10025d;
                f10025d = elapsedRealtime;
            }
            b.o.U(f10023b);
        }
    }
}
