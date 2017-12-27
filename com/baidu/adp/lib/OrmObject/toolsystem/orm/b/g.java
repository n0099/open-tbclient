package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Set<String> agk;
    private Message agn;

    public g(Message message) {
        this.agn = message;
        List<Field> e = com.baidu.adp.lib.OrmObject.a.a.e(message.getClass());
        this.agk = new HashSet();
        if (e != null && e.size() > 0) {
            for (Field field : e) {
                if (field != null) {
                    this.agk.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> lI() {
        return this.agk;
    }

    public Object getObject(String str) {
        return com.baidu.adp.lib.OrmObject.a.a.g(this.agn, str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void d(String str, Object obj) {
        com.baidu.adp.lib.OrmObject.a.a.d(this.agn, str, obj);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h aq = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.aq(object);
            if (aq != null) {
                return aq.g(cVar);
            }
            return object;
        }
        return object;
    }
}
