package c.a.t0.u1;

import c.a.d.f.p.m;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            String urlDecode = m.getUrlDecode(str);
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
            String urlDecode = m.getUrlDecode(str);
            return !StringUtils.isNull(urlDecode) && urlDecode.contains("?t=");
        }
        return invokeL.booleanValue;
    }
}
