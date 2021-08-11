package c.a.e.e.q;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f2534a;

    /* renamed from: b  reason: collision with root package name */
    public static b f2535b;

    /* renamed from: c  reason: collision with root package name */
    public static String f2536c;

    /* renamed from: d  reason: collision with root package name */
    public static c f2537d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f2538e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.e.e.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0049a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0049a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 6) {
                            if (a.f2537d != null) {
                                a.f2537d.error(message.what, h.a(R.string.voice_err_play));
                            }
                        } else {
                            if (a.f2537d != null) {
                                a.f2537d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (a.f2537d != null) {
                        a.f2537d.error(message.what, h.a(R.string.voice_err_no_file));
                    }
                } else if (a.f2537d != null) {
                    a.f2537d.c(a.f2536c, message.arg1);
                }
                int unused = a.f2534a = 0;
                c unused2 = a.f2537d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1211721746, "Lc/a/e/e/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1211721746, "Lc/a/e/e/q/a;");
                return;
            }
        }
        f2538e = new Handler(new C0049a());
    }

    public static boolean e(String str, c cVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.AD_TEXT_ID, null, str, cVar, i2)) == null) {
            if (f2534a == 0) {
                b bVar = f2535b;
                if (bVar == null) {
                    f2535b = new b(f2538e, i2);
                } else {
                    bVar.k(i2);
                }
                f2536c = str;
                f2537d = cVar;
                f2535b.j(str);
                f2534a = 2;
                new Thread(f2535b).start();
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            b bVar = f2535b;
            if (bVar != null) {
                bVar.l();
            } else {
                f2534a = 0;
            }
        }
    }
}
