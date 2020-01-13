package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements c {
    private JSONObject pi;

    public e(JSONObject jSONObject) {
        this.pi = jSONObject;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> getKeys() {
        Iterator<String> keys = this.pi.keys();
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

    public Object Z(String str) {
        return this.pi.opt(str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void e(String str, Object obj) {
        try {
            this.pi.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
