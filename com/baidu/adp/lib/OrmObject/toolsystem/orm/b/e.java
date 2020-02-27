package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements c {

    /* renamed from: pl  reason: collision with root package name */
    private JSONObject f974pl;

    public e(JSONObject jSONObject) {
        this.f974pl = jSONObject;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> getKeys() {
        Iterator<String> keys = this.f974pl.keys();
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
        return this.f974pl.opt(str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void e(String str, Object obj) {
        try {
            this.f974pl.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h r = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.r(object);
            if (r != null) {
                return r.g(cVar);
            }
            return object;
        }
        return object;
    }
}
