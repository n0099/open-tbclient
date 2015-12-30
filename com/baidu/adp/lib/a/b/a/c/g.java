package com.baidu.adp.lib.a.b.a.c;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Set<String> sd;
    private Message sg;

    public g(Message message) {
        this.sg = message;
        List<Field> d = com.baidu.adp.lib.a.a.a.d(message.getClass());
        this.sd = new HashSet();
        if (d != null && d.size() > 0) {
            for (Field field : d) {
                if (field != null) {
                    this.sd.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> fJ() {
        return this.sd;
    }

    public Object getObject(String str) {
        return com.baidu.adp.lib.a.a.a.c(this.sg, str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void e(String str, Object obj) {
        com.baidu.adp.lib.a.a.a.a(this.sg, str, obj);
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
