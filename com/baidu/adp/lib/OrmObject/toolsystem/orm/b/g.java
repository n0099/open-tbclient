package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Set<String> rM;
    private Message rP;

    public g(Message message) {
        this.rP = message;
        List<Field> e = com.baidu.adp.lib.OrmObject.a.a.e(message.getClass());
        this.rM = new HashSet();
        if (e != null && e.size() > 0) {
            for (Field field : e) {
                if (field != null) {
                    this.rM.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> ee() {
        return this.rM;
    }

    public Object getObject(String str) {
        return com.baidu.adp.lib.OrmObject.a.a.d(this.rP, str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void d(String str, Object obj) {
        com.baidu.adp.lib.OrmObject.a.a.a(this.rP, str, obj);
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
