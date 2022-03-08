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
    public static b f3505b;

    /* renamed from: c  reason: collision with root package name */
    public static String f3506c;

    /* renamed from: d  reason: collision with root package name */
    public static g f3507d;

    /* renamed from: e  reason: collision with root package name */
    public static long f3508e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f3509f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.h.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0151a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0151a() {
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
                if (i2 != 100) {
                    switch (i2) {
                        case 0:
                            if (a.f3507d != null) {
                                a.f3507d.c(a.f3506c, message.arg1);
                                g unused = a.f3507d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (a.f3507d != null) {
                                if (h.d()) {
                                    a.f3507d.error(message.what, c.a.d.f.q.h.a(R.string.voice_err_create_file_fail));
                                } else {
                                    a.f3507d.error(message.what, c.a.d.f.q.h.a(R.string.voice_err_sdcard_nospace));
                                }
                                g unused2 = a.f3507d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (a.f3507d != null) {
                                a.f3507d.error(message.what, c.a.d.f.q.h.a(R.string.voice_err_file_fail));
                                g unused3 = a.f3507d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (a.f3507d != null) {
                                a.f3507d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (a.f3507d != null) {
                                a.f3507d.error(message.what, c.a.d.f.q.h.a(R.string.voice_err_load_lib_fail));
                                g unused4 = a.f3507d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (a.f3507d != null) {
                                a.f3507d.error(message.what, c.a.d.f.q.h.a(R.string.voice_err_init_fail));
                                g unused5 = a.f3507d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (a.f3507d != null) {
                                a.f3507d.error(message.what, c.a.d.f.q.h.a(R.string.voice_record_timeout_tip));
                                g unused6 = a.f3507d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (a.f3507d != null) {
                                a.f3507d.error(message.what, c.a.d.f.q.h.a(R.string.voice_record_short_tip));
                                g unused7 = a.f3507d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (a.f3507d != null) {
                                a.f3507d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (a.f3507d != null) {
                                a.f3507d.error(message.what, c.a.d.f.q.h.a(R.string.voice_err_other));
                                g unused8 = a.f3507d = null;
                                break;
                            }
                            break;
                    }
                } else if (a.f3507d != null) {
                    a.f3507d.e();
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
        f3509f = new Handler(new C0151a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            b bVar = f3505b;
            if (bVar != null) {
                bVar.cancel();
            }
            a = 0;
        }
    }

    public static boolean f(String str, int i2, g gVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65542, null, str, i2, gVar)) == null) {
            if (System.currentTimeMillis() - f3508e < 1000) {
                return false;
            }
            f3508e = System.currentTimeMillis();
            if (a == 0) {
                if (f3505b == null) {
                    f3505b = new b(f3509f);
                }
                f3506c = str;
                f3507d = gVar;
                if (f3505b.i(str, i2)) {
                    a = 3;
                    new Thread(f3505b).start();
                    return true;
                }
                f3505b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            b bVar = f3505b;
            if (bVar != null) {
                bVar.j();
            }
            a = 0;
        }
    }
}
