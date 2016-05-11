package com.baidu.adp.lib.a.b.a.c;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Set<String> ij;
    private Message im;

    public g(Message message) {
        this.im = message;
        List<Field> e = com.baidu.adp.lib.a.a.a.e(message.getClass());
        this.ij = new HashSet();
        if (e != null && e.size() > 0) {
            for (Field field : e) {
                if (field != null) {
                    this.ij.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> cg() {
        return this.ij;
    }

    public Object getObject(String str) {
        return com.baidu.adp.lib.a.a.a.c(this.im, str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void d(String str, Object obj) {
        com.baidu.adp.lib.a.a.a.a(this.im, str, obj);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.a.b.a.e.c cVar = new com.baidu.adp.lib.a.b.a.e.c(type);
            com.baidu.adp.lib.a.b.a.d.h j = com.baidu.adp.lib.a.b.a.e.g.j(object);
            if (j != null) {
                return j.g(cVar);
            }
            return object;
        }
        return object;
    }
}
