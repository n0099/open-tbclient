package c.a.s0.a.h0.i.h.g;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e a(@NonNull String str) {
        InterceptResult invokeL;
        e jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            synchronized (f.class) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case 48:
                        if (str.equals("0")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 49:
                        if (str.equals("1")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 50:
                        if (str.equals("2")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 51:
                        if (str.equals("3")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 52:
                        if (str.equals("4")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    jVar = new j();
                } else if (c2 == 1) {
                    jVar = new c();
                } else if (c2 == 2) {
                    jVar = new i();
                } else if (c2 == 3) {
                    jVar = new g();
                } else if (c2 != 4) {
                    jVar = new d();
                } else {
                    jVar = new h();
                }
            }
            return jVar;
        }
        return (e) invokeL.objValue;
    }
}
