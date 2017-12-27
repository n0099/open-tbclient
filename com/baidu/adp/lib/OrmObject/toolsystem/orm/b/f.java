package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class f implements c {
    private Map<String, Object> map;

    public f(Map<String, Object> map) {
        this.map = map;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> lI() {
        return this.map.keySet();
    }

    public Object getObject(String str) {
        return this.map.get(str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void d(String str, Object obj) {
        this.map.put(str, obj);
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
