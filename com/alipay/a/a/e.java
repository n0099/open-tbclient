package com.alipay.a.a;

import com.baidu.android.common.others.lang.StringUtil;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static List<i> f1590a;

    static {
        ArrayList arrayList = new ArrayList();
        f1590a = arrayList;
        arrayList.add(new l());
        f1590a.add(new d());
        f1590a.add(new c());
        f1590a.add(new h());
        f1590a.add(new k());
        f1590a.add(new b());
        f1590a.add(new a());
        f1590a.add(new g());
    }

    public static final <T> T a(Object obj, Type type) {
        T t;
        for (i iVar : f1590a) {
            if (iVar.a(com.alipay.a.b.a.a(type)) && (t = (T) iVar.a(obj, type)) != null) {
                return t;
            }
        }
        return null;
    }

    public static final Object a(String str, Type type) {
        Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("[") && trim.endsWith("]")) {
            bVar = new org.json.alipay.a(trim);
        } else if (!trim.startsWith(StringUtil.ARRAY_START) || !trim.endsWith("}")) {
            return a((Object) trim, type);
        } else {
            bVar = new org.json.alipay.b(trim);
        }
        return a(bVar, type);
    }
}
