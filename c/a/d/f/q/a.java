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
    public static b f2624b;

    /* renamed from: c  reason: collision with root package name */
    public static String f2625c;

    /* renamed from: d  reason: collision with root package name */
    public static c f2626d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f2627e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.d.f.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0086a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0086a() {
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
                            if (a.f2626d != null) {
                                a.f2626d.error(message.what, h.a(R.string.voice_err_play));
                            }
                        } else {
                            if (a.f2626d != null) {
                                a.f2626d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (a.f2626d != null) {
                        a.f2626d.error(message.what, h.a(R.string.voice_err_no_file));
                    }
                } else if (a.f2626d != null) {
                    a.f2626d.c(a.f2625c, message.arg1);
                }
                int unused = a.a = 0;
                c unused2 = a.f2626d = null;
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
        f2627e = new Handler(new C0086a());
    }

    public static boolean e(String str, c cVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, cVar, i2)) == null) {
            if (a == 0) {
                b bVar = f2624b;
                if (bVar == null) {
                    f2624b = new b(f2627e, i2);
                } else {
                    bVar.k(i2);
                }
                f2625c = str;
                f2626d = cVar;
                f2624b.j(str);
                a = 2;
                new Thread(f2624b).start();
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            b bVar = f2624b;
            if (bVar != null) {
                bVar.l();
            } else {
                a = 0;
            }
        }
    }
}
