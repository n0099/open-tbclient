package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k implements h {
    private JSONObject agu;

    public k(JSONObject jSONObject) {
        this.agu = jSONObject;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> lK = cVar.lK();
        Type[] lJ = cVar.lJ();
        if (com.baidu.adp.lib.OrmObject.a.a.d(lK, Map.class)) {
            Map<String, Object> d = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.d(cVar, this.agu.length());
            if (d != null) {
                Iterator<String> keys = this.agu.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next instanceof String) {
                        String str = next;
                        Object g = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.aq(this.agu.opt(str)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(lJ[1]));
                        if (g != null) {
                            d.put(str, g);
                        }
                    }
                }
            }
            return d;
        } else if (lK == SparseArray.class) {
            SparseArray sparseArray = new SparseArray(this.agu.length());
            Iterator<String> keys2 = this.agu.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (next2 instanceof String) {
                    String str2 = next2;
                    try {
                        int parseInt = Integer.parseInt(str2);
                        Object g2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.aq(this.agu.opt(String.valueOf(str2))).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(lJ[0]));
                        if (g2 != null) {
                            sparseArray.put(parseInt, g2);
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
            return sparseArray;
        } else if (com.baidu.adp.lib.OrmObject.a.a.d(lK, com.baidu.adp.lib.OrmObject.toolsystem.orm.object.a.class)) {
            return OrmObject.objectWithJson(this.agu, lK);
        } else {
            return null;
        }
    }
}
