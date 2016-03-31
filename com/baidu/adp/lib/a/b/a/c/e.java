package com.baidu.adp.lib.a.b.a.c;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements c {
    private JSONObject sz;

    public e(JSONObject jSONObject) {
        this.sz = jSONObject;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> fR() {
        Iterator<String> keys = this.sz.keys();
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
        return this.sz.opt(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void d(String str, Object obj) {
        try {
            this.sz.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.a.b.a.e.c cVar = new com.baidu.adp.lib.a.b.a.e.c(type);
            com.baidu.adp.lib.a.b.a.d.h j = com.baidu.adp.lib.a.b.a.e.g.j(object);
            if (j != null) {
                return j.g(cVar);
            }
            return object;
        }
        return object;
    }
}
