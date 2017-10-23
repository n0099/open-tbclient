package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Set<String> rP;
    private Message rS;

    public g(Message message) {
        this.rS = message;
        List<Field> e = com.baidu.adp.lib.OrmObject.a.a.e(message.getClass());
        this.rP = new HashSet();
        if (e != null && e.size() > 0) {
            for (Field field : e) {
                if (field != null) {
                    this.rP.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> ee() {
        return this.rP;
    }

    public Object getObject(String str) {
        return com.baidu.adp.lib.OrmObject.a.a.d(this.rS, str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void d(String str, Object obj) {
        com.baidu.adp.lib.OrmObject.a.a.a(this.rS, str, obj);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h l = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.l(object);
            if (l != null) {
                return l.g(cVar);
            }
            return object;
        }
        return object;
    }
}
