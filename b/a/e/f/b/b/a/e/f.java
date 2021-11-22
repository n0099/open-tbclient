package b.a.e.f.b.b.a.e;

import android.os.Bundle;
import android.util.SparseArray;
import b.a.e.f.b.b.a.b.h;
import b.a.e.f.b.b.a.b.i;
import b.a.e.f.b.b.a.b.j;
import b.a.e.f.b.b.a.b.k;
import b.a.e.f.b.b.a.b.l;
import b.a.e.f.b.b.a.b.m;
import b.a.e.f.b.b.a.b.n;
import b.a.e.f.b.b.a.b.o;
import b.a.e.f.b.b.a.b.p;
import b.a.e.f.b.b.a.b.q;
import b.a.e.f.b.b.a.b.r;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final h a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new b.a.e.f.b.b.a.b.c((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new r((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new b.a.e.f.b.b.a.b.a(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new q((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new j((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new n((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new l((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new o((Set) obj);
                                            }
                                            if (b.a.e.f.b.a.a.e(cls, OrmObject.class)) {
                                                return new m((OrmObject) obj);
                                            }
                                            return null;
                                        }
                                        return new p(((Short) obj).shortValue());
                                    }
                                    return new k(((Long) obj).longValue());
                                }
                                return new i(((Integer) obj).intValue());
                            }
                            return new b.a.e.f.b.b.a.b.g(((Float) obj).floatValue());
                        }
                        return new b.a.e.f.b.b.a.b.f(((Double) obj).doubleValue());
                    }
                    return new b.a.e.f.b.b.a.b.e(((Character) obj).charValue());
                }
                return new b.a.e.f.b.b.a.b.d(((Byte) obj).byteValue());
            }
            return new b.a.e.f.b.b.a.b.b(((Boolean) obj).booleanValue());
        }
        return (h) invokeL.objValue;
    }
}
