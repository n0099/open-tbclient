package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Set<String> pg;
    private Message pj;

    public g(Message message) {
        this.pj = message;
        List<Field> findFields = com.baidu.adp.lib.OrmObject.a.a.findFields(message.getClass());
        this.pg = new HashSet();
        if (findFields != null && findFields.size() > 0) {
            for (Field field : findFields) {
                if (field != null) {
                    this.pg.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> getKeys() {
        return this.pg;
    }

    public Object Z(String str) {
        return com.baidu.adp.lib.OrmObject.a.a.getValueForField(this.pj, str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void e(String str, Object obj) {
        com.baidu.adp.lib.OrmObject.a.a.setValueForField(this.pj, str, obj);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object Z = Z(str);
        if (Z != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h r = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.r(Z);
            if (r != null) {
                return r.g(cVar);
            }
            return Z;
        }
        return Z;
    }
}
