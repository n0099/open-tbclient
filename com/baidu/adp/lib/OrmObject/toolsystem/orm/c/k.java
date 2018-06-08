package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k implements h {
    private JSONObject wZ;

    public k(JSONObject jSONObject) {
        this.wZ = jSONObject;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gG = cVar.gG();
        Type[] gF = cVar.gF();
        if (com.baidu.adp.lib.OrmObject.a.a.d(gG, Map.class)) {
            Map<String, Object> d = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.d(cVar, this.wZ.length());
            if (d != null) {
                Iterator<String> keys = this.wZ.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next instanceof String) {
                        String str = next;
                        Object g = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.o(this.wZ.opt(str)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gF[1]));
                        if (g != null) {
                            d.put(str, g);
                        }
                    }
                }
            }
            return d;
        } else if (gG == SparseArray.class) {
            SparseArray sparseArray = new SparseArray(this.wZ.length());
            Iterator<String> keys2 = this.wZ.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (next2 instanceof String) {
                    String str2 = next2;
                    try {
                        int parseInt = Integer.parseInt(str2);
                        Object g2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.o(this.wZ.opt(String.valueOf(str2))).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gF[0]));
                        if (g2 != null) {
                            sparseArray.put(parseInt, g2);
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
            return sparseArray;
        } else if (com.baidu.adp.lib.OrmObject.a.a.d(gG, com.baidu.adp.lib.OrmObject.toolsystem.orm.object.a.class)) {
            return OrmObject.objectWithJson(this.wZ, gG);
        } else {
            return null;
        }
    }
}
