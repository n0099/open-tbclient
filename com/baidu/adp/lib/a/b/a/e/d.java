package com.baidu.adp.lib.a.b.a.e;

import android.text.TextUtils;
import com.baidu.adp.lib.a.b.a.b.h;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class d {
    public static final boolean a(com.baidu.adp.lib.a.b.a.a.g gVar, com.baidu.adp.lib.a.b.a.c.c cVar) {
        h i;
        Object obj;
        if (gVar == null || cVar == null) {
            return false;
        }
        for (Field field : com.baidu.adp.lib.a.a.a.e(gVar.getClass())) {
            if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                String name = field.getName();
                if (!TextUtils.isEmpty(name) && (i = f.i(com.baidu.adp.lib.a.a.a.c(gVar, name))) != null) {
                    if (cVar instanceof com.baidu.adp.lib.a.b.a.c.e) {
                        obj = i.a(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.a.b.a.c.a) {
                        obj = i.b(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.a.b.a.c.d) {
                        obj = i.c(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.a.b.a.c.f) {
                        obj = i.d(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.a.b.a.c.b) {
                        obj = i.e(new c(field.getGenericType()));
                    } else if (!(cVar instanceof com.baidu.adp.lib.a.b.a.c.g)) {
                        obj = null;
                    } else {
                        obj = i.f(new c(field.getGenericType()));
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
