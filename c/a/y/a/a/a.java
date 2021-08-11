package c.a.y.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Method a(Class cls, String str, Class... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, cls, str, clsArr)) == null) {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            boolean isAccessible = declaredMethod.isAccessible();
            declaredMethod.setAccessible(true);
            declaredMethod.setAccessible(isAccessible);
            return declaredMethod;
        }
        return (Method) invokeLLL.objValue;
    }
}
