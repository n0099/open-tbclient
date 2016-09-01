package com.baidu.adp.lib.a.b.a.c;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Set<String> ld;
    private Message lg;

    public g(Message message) {
        this.lg = message;
        List<Field> m = com.baidu.adp.lib.a.a.a.m(message.getClass());
        this.ld = new HashSet();
        if (m != null && m.size() > 0) {
            for (Field field : m) {
                if (field != null) {
                    this.ld.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> db() {
        return this.ld;
    }

    public Object getObject(String str) {
        return com.baidu.adp.lib.a.a.a.d(this.lg, str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void j(String str, Object obj) {
        com.baidu.adp.lib.a.a.a.a(this.lg, str, obj);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object b(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.a.b.a.e.c cVar = new com.baidu.adp.lib.a.b.a.e.c(type);
            com.baidu.adp.lib.a.b.a.d.h m = com.baidu.adp.lib.a.b.a.e.g.m(object);
            if (m != null) {
                return m.g(cVar);
            }
            return object;
        }
        return object;
    }
}
