package com.baidu.adp.lib.a.b.a.e;

import android.text.TextUtils;
import com.baidu.adp.lib.a.b.a.b.h;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class d {
    public static final boolean a(com.baidu.adp.lib.a.b.a.a.g gVar, com.baidu.adp.lib.a.b.a.c.c cVar) {
        h l;
        Object obj;
        if (gVar == null || cVar == null) {
            return false;
        }
        for (Field field : com.baidu.adp.lib.a.a.a.m(gVar.getClass())) {
            if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                String name = field.getName();
                if (!TextUtils.isEmpty(name) && (l = f.l(com.baidu.adp.lib.a.a.a.d(gVar, name))) != null) {
                    if (cVar instanceof com.baidu.adp.lib.a.b.a.c.e) {
                        obj = l.a(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.a.b.a.c.a) {
                        obj = l.b(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.a.b.a.c.d) {
                        obj = l.c(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.a.b.a.c.f) {
                        obj = l.d(new c(field.getGenericType()));
                    } else if (cVar instanceof com.baidu.adp.lib.a.b.a.c.b) {
                        obj = l.e(new c(field.getGenericType()));
                    } else if (!(cVar instanceof com.baidu.adp.lib.a.b.a.c.g)) {
                        obj = null;
                    } else {
                        obj = l.f(new c(field.getGenericType()));
                    }
                    if (obj != null) {
                        cVar.j(name, obj);
                    }
                }
            }
        }
        return true;
    }
}
