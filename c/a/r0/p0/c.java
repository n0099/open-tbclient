package c.a.r0.p0;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.getCount(list) <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (String str : list) {
                if (!StringUtils.isNull(str)) {
                    if (!z && !StringUtils.isNull(sb.toString())) {
                        z = true;
                    }
                    if (z) {
                        sb.append("_");
                    }
                    sb.append(str);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static List<String> b(List<String> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, list, i2)) == null) {
            int count = ListUtils.getCount(list);
            return (count <= 0 || i2 < 0 || count <= i2) ? list : new ArrayList(ListUtils.subList(list, count - i2, count));
        }
        return (List) invokeLI.objValue;
    }
}
