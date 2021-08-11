package c.a.n0.f.j.s;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import c.a.n0.f.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10534a;

    /* renamed from: b  reason: collision with root package name */
    public static long f10535b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f10536c;

    /* renamed from: d  reason: collision with root package name */
    public static long f10537d;

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f10538e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f10539f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.f.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0530a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C0530a f10540e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-862924530, "Lc/a/n0/f/j/s/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-862924530, "Lc/a/n0/f/j/s/a$a;");
                    return;
                }
            }
            f10540e = new C0530a();
        }

        public C0530a() {
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
                if (message.what == 0 && a.f10539f.g()) {
                    a aVar = a.f10539f;
                    if (a.f10535b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        a aVar2 = a.f10539f;
                        a aVar3 = a.f10539f;
                        a.f10535b = (a.f10535b + elapsedRealtime) - a.f10537d;
                        a aVar4 = a.f10539f;
                        a.f10537d = elapsedRealtime;
                        a aVar5 = a.f10539f;
                        Handler handler = a.f10536c;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 1000L);
                        }
                        a aVar6 = a.f10539f;
                        if ((a.f10535b / 1000) % 15 == 0) {
                            b bVar = b.o;
                            a aVar7 = a.f10539f;
                            bVar.U(a.f10535b);
                            return true;
                        }
                        return true;
                    }
                }
                a aVar8 = a.f10539f;
                a.f10537d = 0L;
                a.f10539f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-899220949, "Lc/a/n0/f/j/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-899220949, "Lc/a/n0/f/j/s/a;");
                return;
            }
        }
        f10539f = new a();
        f10538e = C0530a.f10540e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f10535b : invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f10534a : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j2 = f10535b;
            if (j2 < 30000) {
                return;
            }
            f10535b = j2 % 30000;
            b.o.M();
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            f10534a = z;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f10536c == null) {
                f10536c = new Handler(f10538e);
            }
            f10535b = b.o.A();
            f10534a = true;
            f10537d = SystemClock.elapsedRealtime();
            Handler handler = f10536c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f10534a = false;
            Handler handler = f10536c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (f10537d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                f10535b = (f10535b + elapsedRealtime) - f10537d;
                f10537d = elapsedRealtime;
            }
            b.o.U(f10535b);
        }
    }
}
