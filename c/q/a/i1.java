package c.q.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public final class i1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            String D = m2.D(context);
            if (TextUtils.isEmpty(D)) {
                try {
                    w0 a = z0.a(context);
                    String str = a == null ? null : a.a;
                    if (TextUtils.isEmpty(str)) {
                        m2.x(context, str);
                    }
                    return str;
                } catch (Exception unused) {
                    return null;
                }
            }
            return D;
        }
        return (String) invokeL.objValue;
    }
}
