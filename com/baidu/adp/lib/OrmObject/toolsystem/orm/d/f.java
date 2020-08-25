package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import android.os.Bundle;
import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.a.i;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.a.j;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.a.k;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.a.l;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.a.m;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.a.n;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.a.o;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.a.p;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.a.q;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.a.r;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes.dex */
public class f {
    public static final h u(Object obj) {
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return new com.baidu.adp.lib.OrmObject.toolsystem.orm.a.b(((Boolean) obj).booleanValue());
        }
        if (cls == Bundle.class) {
            return new com.baidu.adp.lib.OrmObject.toolsystem.orm.a.c((Bundle) obj);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return new com.baidu.adp.lib.OrmObject.toolsystem.orm.a.d(((Byte) obj).byteValue());
        }
        if (cls == Character.TYPE || cls == Character.class) {
            return new com.baidu.adp.lib.OrmObject.toolsystem.orm.a.e(((Character) obj).charValue());
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return new com.baidu.adp.lib.OrmObject.toolsystem.orm.a.f(((Double) obj).doubleValue());
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return new com.baidu.adp.lib.OrmObject.toolsystem.orm.a.g(((Float) obj).floatValue());
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return new i(((Integer) obj).intValue());
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return new k(((Long) obj).longValue());
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return new p(((Short) obj).shortValue());
        }
        if (cls == String.class) {
            return new r((String) obj);
        }
        if (cls.isArray()) {
            return new com.baidu.adp.lib.OrmObject.toolsystem.orm.a.a(obj);
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
        if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(cls, OrmObject.class)) {
            return new m((OrmObject) obj);
        }
        return null;
    }
}
