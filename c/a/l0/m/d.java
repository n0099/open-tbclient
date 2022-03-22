package c.a.l0.m;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
            } catch (Throwable th) {
                c.d(th);
            }
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            a = c.a.l0.b.a.f(context).J();
            return a;
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                c.a.l0.b.d dVar = new c.a.l0.b.d(context);
                String c2 = dVar.c();
                if (!TextUtils.isEmpty(c2)) {
                    return new String(a.b("30212102dicudiab".getBytes(), Base64.decode(c2, 10), true), "UTF-8");
                }
                String a2 = dVar.a();
                if (TextUtils.isEmpty(a2)) {
                    return "";
                }
                dVar.b(new String(Base64.encode(a.a("30212102dicudiab".getBytes(), a2.getBytes("UTF-8")), 10), "UTF-8"));
                return a2;
            } catch (Throwable th) {
                c.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
