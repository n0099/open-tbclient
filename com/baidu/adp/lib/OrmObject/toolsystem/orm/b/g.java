package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Set<String> xB;
    private Message xE;

    public g(Message message) {
        this.xE = message;
        List<Field> g = com.baidu.adp.lib.OrmObject.a.a.g(message.getClass());
        this.xB = new HashSet();
        if (g != null && g.size() > 0) {
            for (Field field : g) {
                if (field != null) {
                    this.xB.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> getKeys() {
        return this.xB;
    }

    public Object ab(String str) {
        return com.baidu.adp.lib.OrmObject.a.a.c(this.xE, str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void e(String str, Object obj) {
        com.baidu.adp.lib.OrmObject.a.a.a(this.xE, str, obj);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object ab = ab(str);
        if (ab != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h s = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.s(ab);
            if (s != null) {
                return s.g(cVar);
            }
            return ab;
        }
        return ab;
    }
}
