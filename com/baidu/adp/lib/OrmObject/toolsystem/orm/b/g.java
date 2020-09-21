package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    private Message JT;
    private Set<String> keySet;

    public g(Message message) {
        this.JT = message;
        List<Field> findFields = com.baidu.adp.lib.OrmObject.a.a.findFields(message.getClass());
        this.keySet = new HashSet();
        if (findFields != null && findFields.size() > 0) {
            for (Field field : findFields) {
                if (field != null) {
                    this.keySet.add(field.getName());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> getKeys() {
        return this.keySet;
    }

    public Object getObject(String str) {
        return com.baidu.adp.lib.OrmObject.a.a.getValueForField(this.JT, str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void f(String str, Object obj) {
        com.baidu.adp.lib.OrmObject.a.a.setValueForField(this.JT, str, obj);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h w = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.w(object);
            if (w != null) {
                return w.g(cVar);
            }
            return object;
        }
        return object;
    }
}
