package b.a.i.a.a;

import android.os.Handler;
import android.os.Message;
import b.a.e.e.q.g;
import b.a.e.e.q.h;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static int f2921a;

    /* renamed from: b  reason: collision with root package name */
    public static b f2922b;

    /* renamed from: c  reason: collision with root package name */
    public static String f2923c;

    /* renamed from: d  reason: collision with root package name */
    public static g f2924d;

    /* renamed from: e  reason: collision with root package name */
    public static long f2925e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f2926f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.i.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0069a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0069a() {
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
                            if (a.f2924d != null) {
                                a.f2924d.c(a.f2923c, message.arg1);
                                g unused = a.f2924d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (a.f2924d != null) {
                                if (b.a.e.e.p.f.d()) {
                                    a.f2924d.error(message.what, h.a(R.string.voice_err_create_file_fail));
                                } else {
                                    a.f2924d.error(message.what, h.a(R.string.voice_err_sdcard_nospace));
                                }
                                g unused2 = a.f2924d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (a.f2924d != null) {
                                a.f2924d.error(message.what, h.a(R.string.voice_err_file_fail));
                                g unused3 = a.f2924d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (a.f2924d != null) {
                                a.f2924d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (a.f2924d != null) {
                                a.f2924d.error(message.what, h.a(R.string.voice_err_load_lib_fail));
                                g unused4 = a.f2924d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (a.f2924d != null) {
                                a.f2924d.error(message.what, h.a(R.string.voice_err_init_fail));
                                g unused5 = a.f2924d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (a.f2924d != null) {
                                a.f2924d.error(message.what, h.a(R.string.voice_record_timeout_tip));
                                g unused6 = a.f2924d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (a.f2924d != null) {
                                a.f2924d.error(message.what, h.a(R.string.voice_record_short_tip));
                                g unused7 = a.f2924d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (a.f2924d != null) {
                                a.f2924d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (a.f2924d != null) {
                                a.f2924d.error(message.what, h.a(R.string.voice_err_other));
                                g unused8 = a.f2924d = null;
                                break;
                            }
                            break;
                    }
                } else if (a.f2924d != null) {
                    a.f2924d.e();
                }
                int unused9 = a.f2921a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-651047485, "Lb/a/i/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-651047485, "Lb/a/i/a/a/a;");
                return;
            }
        }
        f2926f = new Handler(new C0069a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            b bVar = f2922b;
            if (bVar != null) {
                bVar.cancel();
            }
            f2921a = 0;
        }
    }

    public static boolean f(String str, int i2, g gVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(AdIconUtil.BAIDU_LOGO_ID, null, str, i2, gVar)) == null) {
            if (System.currentTimeMillis() - f2925e < 1000) {
                return false;
            }
            f2925e = System.currentTimeMillis();
            if (f2921a == 0) {
                if (f2922b == null) {
                    f2922b = new b(f2926f);
                }
                f2923c = str;
                f2924d = gVar;
                if (f2922b.i(str, i2)) {
                    f2921a = 3;
                    new Thread(f2922b).start();
                    return true;
                }
                f2922b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            b bVar = f2922b;
            if (bVar != null) {
                bVar.j();
            }
            f2921a = 0;
        }
    }
}
