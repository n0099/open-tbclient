package c.a.d.f.j.b.m;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            if (str.contains("/excellent/personalized")) {
                return 2;
            }
            if (str.contains("/frs/generalTabList") || str.contains("/frs/page") || str.contains("/frs/threadlist")) {
                return 3;
            }
            if (str.contains("/pb/page")) {
                return 4;
            }
            if (str.contains("/thread/add")) {
                return 5;
            }
            return str.contains("/post/add") ? 6 : 1;
        }
        return invokeL.intValue;
    }
}
