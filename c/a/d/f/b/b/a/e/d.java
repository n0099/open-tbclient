package c.a.d.f.b.b.a.e;

import android.text.TextUtils;
import c.a.d.f.b.b.a.b.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(c.a.d.f.b.b.a.a.b bVar, c.a.d.f.b.b.a.c.c cVar) {
        InterceptResult invokeLL;
        h a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bVar, cVar)) == null) {
            if (bVar == null || cVar == null) {
                return false;
            }
            for (Field field : c.a.d.f.b.a.a.b(bVar.getClass())) {
                if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!TextUtils.isEmpty(name) && (a = f.a(c.a.d.f.b.a.a.d(bVar, name))) != null) {
                        Object obj = null;
                        if (cVar instanceof c.a.d.f.b.b.a.c.e) {
                            obj = a.f(new c(field.getGenericType()));
                        } else if (cVar instanceof c.a.d.f.b.b.a.c.a) {
                            obj = a.d(new c(field.getGenericType()));
                        } else if (cVar instanceof c.a.d.f.b.b.a.c.d) {
                            obj = a.e(new c(field.getGenericType()));
                        } else if (cVar instanceof c.a.d.f.b.b.a.c.f) {
                            obj = a.b(new c(field.getGenericType()));
                        } else if (cVar instanceof c.a.d.f.b.b.a.c.b) {
                            obj = a.a(new c(field.getGenericType()));
                        } else if (cVar instanceof c.a.d.f.b.b.a.c.g) {
                            obj = a.c(new c(field.getGenericType()));
                        }
                        if (obj != null) {
                            cVar.a(name, obj);
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
