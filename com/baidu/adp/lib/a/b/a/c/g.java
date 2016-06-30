package com.baidu.adp.lib.a.b.a.c;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Set<String> ih;
    private Message ik;

    public g(Message message) {
        this.ik = message;
        List<Field> m = com.baidu.adp.lib.a.a.a.m(message.getClass());
        this.ih = new HashSet();
        if (m != null && m.size() > 0) {
            for (Field field : m) {
                if (field != null) {
                    this.ih.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> ch() {
        return this.ih;
    }

    public Object getObject(String str) {
        return com.baidu.adp.lib.a.a.a.c(this.ik, str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void d(String str, Object obj) {
        com.baidu.adp.lib.a.a.a.a(this.ik, str, obj);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object b(String str, Type type) {
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
