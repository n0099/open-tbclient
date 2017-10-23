package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements c {
    private JSONObject rR;

    public e(JSONObject jSONObject) {
        this.rR = jSONObject;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> ee() {
        Iterator<String> keys = this.rR.keys();
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
        return this.rR.opt(str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void d(String str, Object obj) {
        try {
            this.rR.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
