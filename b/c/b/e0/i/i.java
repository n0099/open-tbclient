package b.c.b.e0.i;

import b.c.b.s;
import b.c.b.z;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.Proxy;
/* loaded from: classes6.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(z zVar, Proxy.Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, zVar, type)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(zVar.f());
            sb.append(' ');
            if (b(zVar, type)) {
                sb.append(zVar.h());
            } else {
                sb.append(c(zVar.h()));
            }
            sb.append(" HTTP/1.1");
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b(z zVar, Proxy.Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, zVar, type)) == null) ? !zVar.e() && type == Proxy.Type.HTTP : invokeLL.booleanValue;
    }

    public static String c(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sVar)) == null) {
            String g2 = sVar.g();
            String i2 = sVar.i();
            if (i2 != null) {
                return g2 + '?' + i2;
            }
            return g2;
        }
        return (String) invokeL.objValue;
    }
}
