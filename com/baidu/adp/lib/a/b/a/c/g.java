package com.baidu.adp.lib.a.b.a.c;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Set<String> gA;
    private Message gD;

    public g(Message message) {
        this.gD = message;
        List<Field> k = com.baidu.adp.lib.a.a.a.k(message.getClass());
        this.gA = new HashSet();
        if (k != null && k.size() > 0) {
            for (Field field : k) {
                if (field != null) {
                    this.gA.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> co() {
        return this.gA;
    }

    public Object getObject(String str) {
        return com.baidu.adp.lib.a.a.a.b(this.gD, str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void e(String str, Object obj) {
        com.baidu.adp.lib.a.a.a.a(this.gD, str, obj);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.a.b.a.e.c cVar = new com.baidu.adp.lib.a.b.a.e.c(type);
            com.baidu.adp.lib.a.b.a.d.h i = com.baidu.adp.lib.a.b.a.e.g.i(object);
            if (i != null) {
                return i.g(cVar);
            }
            return object;
        }
        return object;
    }
}
