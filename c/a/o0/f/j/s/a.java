package c.a.o0.f.j.s;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import c.a.o0.f.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10780a;

    /* renamed from: b  reason: collision with root package name */
    public static long f10781b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f10782c;

    /* renamed from: d  reason: collision with root package name */
    public static long f10783d;

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f10784e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f10785f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.f.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0538a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C0538a f10786e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1156327537, "Lc/a/o0/f/j/s/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1156327537, "Lc/a/o0/f/j/s/a$a;");
                    return;
                }
            }
            f10786e = new C0538a();
        }

        public C0538a() {
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
                if (message.what == 0 && a.f10785f.g()) {
                    a aVar = a.f10785f;
                    if (a.f10781b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        a aVar2 = a.f10785f;
                        a aVar3 = a.f10785f;
                        a.f10781b = (a.f10781b + elapsedRealtime) - a.f10783d;
                        a aVar4 = a.f10785f;
                        a.f10783d = elapsedRealtime;
                        a aVar5 = a.f10785f;
                        Handler handler = a.f10782c;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 1000L);
                        }
                        a aVar6 = a.f10785f;
                        if ((a.f10781b / 1000) % 15 == 0) {
                            b bVar = b.o;
                            a aVar7 = a.f10785f;
                            bVar.U(a.f10781b);
                            return true;
                        }
                        return true;
                    }
                }
                a aVar8 = a.f10785f;
                a.f10783d = 0L;
                a.f10785f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1598794988, "Lc/a/o0/f/j/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1598794988, "Lc/a/o0/f/j/s/a;");
                return;
            }
        }
        f10785f = new a();
        f10784e = C0538a.f10786e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f10781b : invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f10780a : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j2 = f10781b;
            if (j2 < 30000) {
                return;
            }
            f10781b = j2 % 30000;
            b.o.M();
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            f10780a = z;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f10782c == null) {
                f10782c = new Handler(f10784e);
            }
            f10781b = b.o.A();
            f10780a = true;
            f10783d = SystemClock.elapsedRealtime();
            Handler handler = f10782c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f10780a = false;
            Handler handler = f10782c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (f10783d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                f10781b = (f10781b + elapsedRealtime) - f10783d;
                f10783d = elapsedRealtime;
            }
            b.o.U(f10781b);
        }
    }
}
