package com.baidu.adp.lib.a.b.a.c;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Message eB;
    private Set<String> ey;

    public g(Message message) {
        this.eB = message;
        List<Field> b = com.baidu.adp.lib.a.a.a.b(message.getClass());
        this.ey = new HashSet();
        if (b != null && b.size() > 0) {
            for (Field field : b) {
                if (field != null) {
                    this.ey.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> bQ() {
        return this.ey;
    }

    public Object getObject(String str) {
        return com.baidu.adp.lib.a.a.a.a(this.eB, str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void a(String str, Object obj) {
        com.baidu.adp.lib.a.a.a.a(this.eB, str, obj);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.a.b.a.e.c cVar = new com.baidu.adp.lib.a.b.a.e.c(type);
            com.baidu.adp.lib.a.b.a.d.h d = com.baidu.adp.lib.a.b.a.e.g.d(object);
            if (d != null) {
                return d.g(cVar);
            }
            return object;
        }
        return object;
    }
}
