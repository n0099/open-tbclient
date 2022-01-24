package c.a.d.f.q;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
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
    public static b f3122b;

    /* renamed from: c  reason: collision with root package name */
    public static String f3123c;

    /* renamed from: d  reason: collision with root package name */
    public static c f3124d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f3125e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.d.f.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0122a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0122a() {
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
                            if (a.f3124d != null) {
                                a.f3124d.error(message.what, h.a(R.string.voice_err_play));
                            }
                        } else {
                            if (a.f3124d != null) {
                                a.f3124d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (a.f3124d != null) {
                        a.f3124d.error(message.what, h.a(R.string.voice_err_no_file));
                    }
                } else if (a.f3124d != null) {
                    a.f3124d.c(a.f3123c, message.arg1);
                }
                int unused = a.a = 0;
                c unused2 = a.f3124d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-502459438, "Lc/a/d/f/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-502459438, "Lc/a/d/f/q/a;");
                return;
            }
        }
        f3125e = new Handler(new C0122a());
    }

    public static boolean e(String str, c cVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, cVar, i2)) == null) {
            if (a == 0) {
                b bVar = f3122b;
                if (bVar == null) {
                    f3122b = new b(f3125e, i2);
                } else {
                    bVar.k(i2);
                }
                f3123c = str;
                f3124d = cVar;
                f3122b.j(str);
                a = 2;
                new Thread(f3122b).start();
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            b bVar = f3122b;
            if (bVar != null) {
                bVar.l();
            } else {
                a = 0;
            }
        }
    }
}
