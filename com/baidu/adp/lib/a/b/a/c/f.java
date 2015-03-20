package com.baidu.adp.lib.a.b.a.c;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class f implements c {
    private Map<String, Object> map;

    public f(Map<String, Object> map) {
        this.map = map;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> fM() {
        return this.map.keySet();
    }

    public Object getObject(String str) {
        return this.map.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void e(String str, Object obj) {
        this.map.put(str, obj);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.a.b.a.e.c cVar = new com.baidu.adp.lib.a.b.a.e.c(type);
            com.baidu.adp.lib.a.b.a.d.h i = com.baidu.adp.lib.a.b.a.e.g.i(object);
            if (i != null) {
                return i.g(cVar);
            }
            return object;
        }
        return object;
    }
}
