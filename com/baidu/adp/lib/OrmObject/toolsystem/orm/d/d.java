package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class d {
    public static final boolean a(com.baidu.adp.lib.OrmObject.toolsystem.orm.object.g gVar, com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c cVar) {
        h u;
        Object obj;
        if (gVar == null || cVar == null) {
            return false;
        }
        for (Field field : com.baidu.adp.lib.OrmObject.a.a.findFields(gVar.getClass())) {
            if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                String name = field.getName();
                if (!TextUtils.isEmpty(name) && (u = f.u(com.baidu.adp.lib.OrmObject.a.a.getValueForField(gVar, name))) != null) {
                    if (cVar instanceof com.baidu.adp.lib.OrmObject.toolsystem.orm.b.e) {
                        obj = u.a(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.OrmObject.toolsystem.orm.b.a) {
                        obj = u.b(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.OrmObject.toolsystem.orm.b.d) {
                        obj = u.c(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.OrmObject.toolsystem.orm.b.f) {
                        obj = u.d(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.OrmObject.toolsystem.orm.b.b) {
                        obj = u.e(new c(field.getGenericType()));
                    } else if (!(cVar instanceof com.baidu.adp.lib.OrmObject.toolsystem.orm.b.g)) {
                        obj = null;
                    } else {
                        obj = u.f(new c(field.getGenericType()));
                    }
                    if (obj != null) {
                        cVar.f(name, obj);
                    }
                }
            }
        }
        return true;
    }
}
