package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Set<String> np;
    private Message ns;

    public g(Message message) {
        this.ns = message;
        List<Field> findFields = com.baidu.adp.lib.OrmObject.a.a.findFields(message.getClass());
        this.np = new HashSet();
        if (findFields != null && findFields.size() > 0) {
            for (Field field : findFields) {
                if (field != null) {
                    this.np.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> getKeys() {
        return this.np;
    }

    public Object U(String str) {
        return com.baidu.adp.lib.OrmObject.a.a.getValueForField(this.ns, str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void e(String str, Object obj) {
        com.baidu.adp.lib.OrmObject.a.a.setValueForField(this.ns, str, obj);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object U = U(str);
        if (U != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h q = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.q(U);
            if (q != null) {
                return q.g(cVar);
            }
            return U;
        }
        return U;
    }
}
