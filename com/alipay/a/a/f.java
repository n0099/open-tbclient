package com.alipay.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static List<j> f1626a;

    static {
        ArrayList arrayList = new ArrayList();
        f1626a = arrayList;
        arrayList.add(new l());
        f1626a.add(new d());
        f1626a.add(new c());
        f1626a.add(new h());
        f1626a.add(new b());
        f1626a.add(new a());
        f1626a.add(new g());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object b2 = b(obj);
        if (com.alipay.a.b.a.a(b2.getClass())) {
            return org.json.alipay.b.c(b2.toString());
        }
        if (Collection.class.isAssignableFrom(b2.getClass())) {
            return new org.json.alipay.a((Collection) ((List) b2)).toString();
        }
        if (Map.class.isAssignableFrom(b2.getClass())) {
            return new org.json.alipay.b((Map) b2).toString();
        }
        throw new IllegalArgumentException("Unsupported Class : " + b2.getClass());
    }

    public static Object b(Object obj) {
        Object a2;
        if (obj == null) {
            return null;
        }
        for (j jVar : f1626a) {
            if (jVar.a(obj.getClass()) && (a2 = jVar.a(obj)) != null) {
                return a2;
            }
        }
        throw new IllegalArgumentException("Unsupported Class : " + obj.getClass());
    }
}
