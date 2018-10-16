package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class d {
    public static final boolean a(com.baidu.adp.lib.OrmObject.toolsystem.orm.object.g gVar, com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c cVar) {
        h r;
        Object obj;
        if (gVar == null || cVar == null) {
            return false;
        }
        for (Field field : com.baidu.adp.lib.OrmObject.a.a.h(gVar.getClass())) {
            if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                String name = field.getName();
                if (!TextUtils.isEmpty(name) && (r = f.r(com.baidu.adp.lib.OrmObject.a.a.c(gVar, name))) != null) {
                    if (cVar instanceof com.baidu.adp.lib.OrmObject.toolsystem.orm.b.e) {
                        obj = r.a(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.OrmObject.toolsystem.orm.b.a) {
                        obj = r.b(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.OrmObject.toolsystem.orm.b.d) {
                        obj = r.c(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.OrmObject.toolsystem.orm.b.f) {
                        obj = r.d(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.OrmObject.toolsystem.orm.b.b) {
                        obj = r.e(new c(field.getGenericType()));
                    } else if (!(cVar instanceof com.baidu.adp.lib.OrmObject.toolsystem.orm.b.g)) {
                        obj = null;
                    } else {
                        obj = r.f(new c(field.getGenericType()));
                    }
                    if (obj != null) {
                        cVar.d(name, obj);
                    }
                }
            }
        }
        return true;
    }
}
