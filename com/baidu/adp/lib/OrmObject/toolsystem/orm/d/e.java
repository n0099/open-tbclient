package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    public static final boolean a(com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c cVar, com.baidu.adp.lib.OrmObject.toolsystem.orm.object.g gVar) {
        Object b;
        if (gVar == null || cVar == null) {
            return false;
        }
        List<Field> e = com.baidu.adp.lib.OrmObject.a.a.e(gVar.getClass());
        Set<String> lJ = cVar.lJ();
        for (Field field : e) {
            if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                String name = field.getName();
                if (!TextUtils.isEmpty(name)) {
                    if (lJ.contains(name)) {
                        Object b2 = cVar.b(name, field.getGenericType());
                        if (b2 != null) {
                            com.baidu.adp.lib.OrmObject.a.a.d(gVar, name, b2);
                        }
                    } else if (lJ.contains(name.toLowerCase(Locale.getDefault()))) {
                        Object b3 = cVar.b(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                        if (b3 != null) {
                            com.baidu.adp.lib.OrmObject.a.a.d(gVar, name, b3);
                        }
                    } else if (lJ.contains(name.toUpperCase(Locale.getDefault())) && (b = cVar.b(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                        com.baidu.adp.lib.OrmObject.a.a.d(gVar, name, b);
                    }
                }
            }
        }
        return true;
    }
}
