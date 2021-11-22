package b.a.r0.n1;

import b.a.e.f.p.k;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            String urlDecode = k.getUrlDecode(str);
            if (urlDecode == null) {
                return urlDecode;
            }
            int lastIndexOf = urlDecode.lastIndexOf("/");
            if (lastIndexOf == -1 || (indexOf = urlDecode.indexOf(".", lastIndexOf)) == -1) {
                return null;
            }
            return urlDecode.substring(lastIndexOf + 1, indexOf);
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            String urlDecode = k.getUrlDecode(str);
            return !StringUtils.isNull(urlDecode) && urlDecode.contains("?t=");
        }
        return invokeL.booleanValue;
    }
}
