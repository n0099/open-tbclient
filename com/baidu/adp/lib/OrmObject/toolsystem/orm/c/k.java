package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k implements h {
    private JSONObject td;

    public k(JSONObject jSONObject) {
        this.td = jSONObject;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ek = cVar.ek();
        Type[] ej = cVar.ej();
        if (com.baidu.adp.lib.OrmObject.a.a.e(ek, Map.class)) {
            Map<String, Object> d = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.d(cVar, this.td.length());
            if (d != null) {
                Iterator<String> keys = this.td.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next instanceof String) {
                        String str = next;
                        Object g = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.m(this.td.opt(str)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(ej[1]));
                        if (g != null) {
                            d.put(str, g);
                        }
                    }
                }
            }
            return d;
        } else if (ek == SparseArray.class) {
            SparseArray sparseArray = new SparseArray(this.td.length());
            Iterator<String> keys2 = this.td.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (next2 instanceof String) {
                    String str2 = next2;
                    try {
                        int parseInt = Integer.parseInt(str2);
                        Object g2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.m(this.td.opt(String.valueOf(str2))).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(ej[0]));
                        if (g2 != null) {
                            sparseArray.put(parseInt, g2);
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
            return sparseArray;
        } else if (com.baidu.adp.lib.OrmObject.a.a.e(ek, com.baidu.adp.lib.OrmObject.toolsystem.orm.object.a.class)) {
            return OrmObject.objectWithJson(this.td, ek);
        } else {
            return null;
        }
    }
}
