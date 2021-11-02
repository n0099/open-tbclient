package b.a.e.e.b.b.a.e;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(b.a.e.e.b.b.a.c.c cVar, b.a.e.e.b.b.a.a.b bVar) {
        InterceptResult invokeLL;
        Object c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cVar, bVar)) == null) {
            if (bVar == null || cVar == null) {
                return false;
            }
            List<Field> b2 = b.a.e.e.b.a.a.b(bVar.getClass());
            Set<String> a2 = cVar.a();
            for (Field field : b2) {
                if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!TextUtils.isEmpty(name)) {
                        if (a2.contains(name)) {
                            Object c3 = cVar.c(name, field.getGenericType());
                            if (c3 != null) {
                                b.a.e.e.b.a.a.h(bVar, name, c3);
                            }
                        } else if (a2.contains(name.toLowerCase(Locale.getDefault()))) {
                            Object c4 = cVar.c(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                            if (c4 != null) {
                                b.a.e.e.b.a.a.h(bVar, name, c4);
                            }
                        } else if (a2.contains(name.toUpperCase(Locale.getDefault())) && (c2 = cVar.c(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                            b.a.e.e.b.a.a.h(bVar, name, c2);
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
