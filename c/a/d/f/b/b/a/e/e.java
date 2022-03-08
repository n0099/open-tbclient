package c.a.d.f.b.b.a.e;

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

    public static final boolean a(c.a.d.f.b.b.a.c.c cVar, c.a.d.f.b.b.a.a.b bVar) {
        InterceptResult invokeLL;
        Object b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cVar, bVar)) == null) {
            if (bVar == null || cVar == null) {
                return false;
            }
            List<Field> b3 = c.a.d.f.b.a.a.b(bVar.getClass());
            Set<String> keys = cVar.getKeys();
            for (Field field : b3) {
                if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!TextUtils.isEmpty(name)) {
                        if (keys.contains(name)) {
                            Object b4 = cVar.b(name, field.getGenericType());
                            if (b4 != null) {
                                c.a.d.f.b.a.a.h(bVar, name, b4);
                            }
                        } else if (keys.contains(name.toLowerCase(Locale.getDefault()))) {
                            Object b5 = cVar.b(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                            if (b5 != null) {
                                c.a.d.f.b.a.a.h(bVar, name, b5);
                            }
                        } else if (keys.contains(name.toUpperCase(Locale.getDefault())) && (b2 = cVar.b(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                            c.a.d.f.b.a.a.h(bVar, name, b2);
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
