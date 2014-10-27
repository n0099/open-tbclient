package com.baidu.adp.lib.a.b.a.c;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements c {
    public JSONObject eA;

    public e(JSONObject jSONObject) {
        this.eA = jSONObject;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> bQ() {
        Iterator<String> keys = this.eA.keys();
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
        return this.eA.opt(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void a(String str, Object obj) {
        try {
            this.eA.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.a.b.a.e.c cVar = new com.baidu.adp.lib.a.b.a.e.c(type);
            com.baidu.adp.lib.a.b.a.d.h d = com.baidu.adp.lib.a.b.a.e.g.d(object);
            if (d != null) {
                return d.g(cVar);
            }
            return object;
        }
        return object;
    }
}
