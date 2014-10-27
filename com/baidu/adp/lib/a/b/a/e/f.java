package com.baidu.adp.lib.a.b.a.e;

import android.os.Bundle;
import android.util.SparseArray;
import com.baidu.adp.lib.a.b.a.b.h;
import com.baidu.adp.lib.a.b.a.b.i;
import com.baidu.adp.lib.a.b.a.b.j;
import com.baidu.adp.lib.a.b.a.b.k;
import com.baidu.adp.lib.a.b.a.b.l;
import com.baidu.adp.lib.a.b.a.b.m;
import com.baidu.adp.lib.a.b.a.b.n;
import com.baidu.adp.lib.a.b.a.b.o;
import com.baidu.adp.lib.a.b.a.b.p;
import com.baidu.adp.lib.a.b.a.b.q;
import com.baidu.adp.lib.a.b.a.b.r;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes.dex */
public class f {
    public static final h c(Object obj) {
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return new com.baidu.adp.lib.a.b.a.b.b(((Boolean) obj).booleanValue());
        }
        if (cls == Bundle.class) {
            return new com.baidu.adp.lib.a.b.a.b.c((Bundle) obj);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return new com.baidu.adp.lib.a.b.a.b.d(((Byte) obj).byteValue());
        }
        if (cls == Character.TYPE || cls == Character.class) {
            return new com.baidu.adp.lib.a.b.a.b.e(((Character) obj).charValue());
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return new com.baidu.adp.lib.a.b.a.b.f(((Double) obj).doubleValue());
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return new com.baidu.adp.lib.a.b.a.b.g(((Float) obj).floatValue());
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
            return new com.baidu.adp.lib.a.b.a.b.a(obj);
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
        if (com.baidu.adp.lib.a.a.a.a(cls, com.baidu.adp.lib.a.b.a.a.i.class)) {
            return new m((com.baidu.adp.lib.a.b.a.a.i) obj);
        }
        return null;
    }
}
