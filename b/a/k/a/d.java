package b.a.k.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, c> f3209a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, context)) == null) {
            synchronized (d.class) {
                if (TextUtils.isEmpty(str)) {
                    str = context.getPackageName() + "_preferences";
                }
                if (f3209a == null) {
                    f3209a = new HashMap<>();
                }
                if (f3209a.get(str) != null) {
                    return f3209a.get(str);
                }
                c cVar = new c(str);
                f3209a.put(str, cVar);
                return cVar;
            }
        }
        return (c) invokeLL.objValue;
    }
}
