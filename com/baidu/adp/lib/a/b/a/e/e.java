package com.baidu.adp.lib.a.b.a.e;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    public static final boolean a(com.baidu.adp.lib.a.b.a.c.c cVar, com.baidu.adp.lib.a.b.a.a.g gVar) {
        Object a;
        if (gVar == null || cVar == null) {
            return false;
        }
        List<Field> k = com.baidu.adp.lib.a.a.a.k(gVar.getClass());
        Set<String> fR = cVar.fR();
        for (Field field : k) {
            if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                String name = field.getName();
                if (!TextUtils.isEmpty(name)) {
                    if (fR.contains(name)) {
                        Object a2 = cVar.a(name, field.getGenericType());
                        if (a2 != null) {
                            com.baidu.adp.lib.a.a.a.a(gVar, name, a2);
                        }
                    } else if (fR.contains(name.toLowerCase(Locale.getDefault()))) {
                        Object a3 = cVar.a(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                        if (a3 != null) {
                            com.baidu.adp.lib.a.a.a.a(gVar, name, a3);
                        }
                    } else if (fR.contains(name.toUpperCase(Locale.getDefault())) && (a = cVar.a(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                        com.baidu.adp.lib.a.a.a.a(gVar, name, a);
                    }
                }
            }
        }
        return true;
    }
}
