package c.a.e.j;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, str) == null) {
            try {
                a.d(context.getApplicationContext().getClassLoader(), str);
            } catch (Throwable th) {
                String str2 = "loadSoFile error " + th.getMessage();
            }
        }
    }
}
