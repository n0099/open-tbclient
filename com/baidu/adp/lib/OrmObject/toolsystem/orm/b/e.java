package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements c {
    private JSONObject sx;

    public e(JSONObject jSONObject) {
        this.sx = jSONObject;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> ei() {
        Iterator<String> keys = this.sx.keys();
        if (keys != null) {
            HashSet hashSet = new HashSet();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null) {
                    hashSet.add(next.toString());
                }
            }
            return hashSet;
        }
        return null;
    }

    public Object getObject(String str) {
        return this.sx.opt(str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void j(String str, Object obj) {
        try {
            this.sx.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h m = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.m(object);
            if (m != null) {
                return m.g(cVar);
            }
            return object;
        }
        return object;
    }
}
