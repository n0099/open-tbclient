package c.a.h.a.a;

import android.os.Handler;
import android.os.Message;
import c.a.d.f.p.h;
import c.a.d.f.q.g;
import com.baidu.tieba.R;
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
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static b f2956b;

    /* renamed from: c  reason: collision with root package name */
    public static String f2957c;

    /* renamed from: d  reason: collision with root package name */
    public static g f2958d;

    /* renamed from: e  reason: collision with root package name */
    public static long f2959e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f2960f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.h.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0142a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0142a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = message.what;
                if (i != 100) {
                    switch (i) {
                        case 0:
                            if (a.f2958d != null) {
                                a.f2958d.c(a.f2957c, message.arg1);
                                g unused = a.f2958d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (a.f2958d != null) {
                                if (h.d()) {
                                    a.f2958d.error(message.what, c.a.d.f.q.h.a(R.string.obfuscated_res_0x7f0f1513));
                                } else {
                                    a.f2958d.error(message.what, c.a.d.f.q.h.a(R.string.obfuscated_res_0x7f0f151c));
                                }
                                g unused2 = a.f2958d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (a.f2958d != null) {
                                a.f2958d.error(message.what, c.a.d.f.q.h.a(R.string.obfuscated_res_0x7f0f1514));
                                g unused3 = a.f2958d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (a.f2958d != null) {
                                a.f2958d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (a.f2958d != null) {
                                a.f2958d.error(message.what, c.a.d.f.q.h.a(R.string.obfuscated_res_0x7f0f1518));
                                g unused4 = a.f2958d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (a.f2958d != null) {
                                a.f2958d.error(message.what, c.a.d.f.q.h.a(R.string.obfuscated_res_0x7f0f1515));
                                g unused5 = a.f2958d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (a.f2958d != null) {
                                a.f2958d.error(message.what, c.a.d.f.q.h.a(R.string.obfuscated_res_0x7f0f1523));
                                g unused6 = a.f2958d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (a.f2958d != null) {
                                a.f2958d.error(message.what, c.a.d.f.q.h.a(R.string.obfuscated_res_0x7f0f1522));
                                g unused7 = a.f2958d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (a.f2958d != null) {
                                a.f2958d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (a.f2958d != null) {
                                a.f2958d.error(message.what, c.a.d.f.q.h.a(R.string.obfuscated_res_0x7f0f151a));
                                g unused8 = a.f2958d = null;
                                break;
                            }
                            break;
                    }
                } else if (a.f2958d != null) {
                    a.f2958d.e();
                }
                int unused9 = a.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2030192195, "Lc/a/h/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2030192195, "Lc/a/h/a/a/a;");
                return;
            }
        }
        f2960f = new Handler(new C0142a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            b bVar = f2956b;
            if (bVar != null) {
                bVar.cancel();
            }
            a = 0;
        }
    }

    public static boolean f(String str, int i, g gVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65542, null, str, i, gVar)) == null) {
            if (System.currentTimeMillis() - f2959e < 1000) {
                return false;
            }
            f2959e = System.currentTimeMillis();
            if (a == 0) {
                if (f2956b == null) {
                    f2956b = new b(f2960f);
                }
                f2957c = str;
                f2958d = gVar;
                if (f2956b.i(str, i)) {
                    a = 3;
                    new Thread(f2956b).start();
                    return true;
                }
                f2956b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            b bVar = f2956b;
            if (bVar != null) {
                bVar.j();
            }
            a = 0;
        }
    }
}
