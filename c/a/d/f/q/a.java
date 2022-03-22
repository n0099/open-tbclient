package c.a.d.f.q;

import android.os.Handler;
import android.os.Message;
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
    public static b f2355b;

    /* renamed from: c  reason: collision with root package name */
    public static String f2356c;

    /* renamed from: d  reason: collision with root package name */
    public static c f2357d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f2358e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.d.f.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0100a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0100a() {
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
                if (i != 0) {
                    if (i != 1) {
                        if (i != 6) {
                            if (a.f2357d != null) {
                                a.f2357d.error(message.what, h.a(R.string.obfuscated_res_0x7f0f151b));
                            }
                        } else {
                            if (a.f2357d != null) {
                                a.f2357d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (a.f2357d != null) {
                        a.f2357d.error(message.what, h.a(R.string.obfuscated_res_0x7f0f1519));
                    }
                } else if (a.f2357d != null) {
                    a.f2357d.c(a.f2356c, message.arg1);
                }
                int unused = a.a = 0;
                c unused2 = a.f2357d = null;
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
        f2358e = new Handler(new C0100a());
    }

    public static boolean e(String str, c cVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, cVar, i)) == null) {
            if (a == 0) {
                b bVar = f2355b;
                if (bVar == null) {
                    f2355b = new b(f2358e, i);
                } else {
                    bVar.k(i);
                }
                f2356c = str;
                f2357d = cVar;
                f2355b.j(str);
                a = 2;
                new Thread(f2355b).start();
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            b bVar = f2355b;
            if (bVar != null) {
                bVar.l();
            } else {
                a = 0;
            }
        }
    }
}
