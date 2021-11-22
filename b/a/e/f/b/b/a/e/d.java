package b.a.e.f.b.b.a.e;

import android.text.TextUtils;
import b.a.e.f.b.b.a.b.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(b.a.e.f.b.b.a.a.b bVar, b.a.e.f.b.b.a.c.c cVar) {
        InterceptResult invokeLL;
        h a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bVar, cVar)) == null) {
            if (bVar == null || cVar == null) {
                return false;
            }
            for (Field field : b.a.e.f.b.a.a.b(bVar.getClass())) {
                if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!TextUtils.isEmpty(name) && (a2 = f.a(b.a.e.f.b.a.a.d(bVar, name))) != null) {
                        Object obj = null;
                        if (cVar instanceof b.a.e.f.b.b.a.c.e) {
                            obj = a2.f(new c(field.getGenericType()));
                        } else if (cVar instanceof b.a.e.f.b.b.a.c.a) {
                            obj = a2.d(new c(field.getGenericType()));
                        } else if (cVar instanceof b.a.e.f.b.b.a.c.d) {
                            obj = a2.e(new c(field.getGenericType()));
                        } else if (cVar instanceof b.a.e.f.b.b.a.c.f) {
                            obj = a2.b(new c(field.getGenericType()));
                        } else if (cVar instanceof b.a.e.f.b.b.a.c.b) {
                            obj = a2.a(new c(field.getGenericType()));
                        } else if (cVar instanceof b.a.e.f.b.b.a.c.g) {
                            obj = a2.c(new c(field.getGenericType()));
                        }
                        if (obj != null) {
                            cVar.b(name, obj);
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
