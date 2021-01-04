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
        Object b2;
        if (gVar == null || cVar == null) {
            return false;
        }
        List<Field> findFields = com.baidu.adp.lib.OrmObject.a.a.findFields(gVar.getClass());
        Set<String> keys = cVar.getKeys();
        for (Field field : findFields) {
            if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                String name = field.getName();
                if (!TextUtils.isEmpty(name)) {
                    if (keys.contains(name)) {
                        Object b3 = cVar.b(name, field.getGenericType());
                        if (b3 != null) {
                            com.baidu.adp.lib.OrmObject.a.a.setValueForField(gVar, name, b3);
                        }
                    } else if (keys.contains(name.toLowerCase(Locale.getDefault()))) {
                        Object b4 = cVar.b(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                        if (b4 != null) {
                            com.baidu.adp.lib.OrmObject.a.a.setValueForField(gVar, name, b4);
                        }
                    } else if (keys.contains(name.toUpperCase(Locale.getDefault())) && (b2 = cVar.b(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                        com.baidu.adp.lib.OrmObject.a.a.setValueForField(gVar, name, b2);
                    }
                }
            }
        }
        return true;
    }
}
