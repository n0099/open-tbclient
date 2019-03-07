package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Set<String> zL;
    private Message zO;

    public g(Message message) {
        this.zO = message;
        List<Field> h = com.baidu.adp.lib.OrmObject.a.a.h(message.getClass());
        this.zL = new HashSet();
        if (h != null && h.size() > 0) {
            for (Field field : h) {
                if (field != null) {
                    this.zL.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> getKeys() {
        return this.zL;
    }

    public Object getObject(String str) {
        return com.baidu.adp.lib.OrmObject.a.a.c(this.zO, str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void d(String str, Object obj) {
        com.baidu.adp.lib.OrmObject.a.a.a(this.zO, str, obj);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h s = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.s(object);
            if (s != null) {
                return s.g(cVar);
            }
            return object;
        }
        return object;
    }
}
