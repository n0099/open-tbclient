package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k implements h {
    private JSONObject xF;

    public k(JSONObject jSONObject) {
        this.xF = jSONObject;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gS = cVar.gS();
        Type[] gR = cVar.gR();
        if (com.baidu.adp.lib.OrmObject.a.a.d(gS, Map.class)) {
            Map<String, Object> d = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.d(cVar, this.xF.length());
            if (d != null) {
                Iterator<String> keys = this.xF.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next instanceof String) {
                        String str = next;
                        Object g = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.s(this.xF.opt(str)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gR[1]));
                        if (g != null) {
                            d.put(str, g);
                        }
                    }
                }
            }
            return d;
        } else if (gS == SparseArray.class) {
            SparseArray sparseArray = new SparseArray(this.xF.length());
            Iterator<String> keys2 = this.xF.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (next2 instanceof String) {
                    String str2 = next2;
                    try {
                        int parseInt = Integer.parseInt(str2);
                        Object g2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.s(this.xF.opt(String.valueOf(str2))).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gR[0]));
                        if (g2 != null) {
                            sparseArray.put(parseInt, g2);
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
            return sparseArray;
        } else if (com.baidu.adp.lib.OrmObject.a.a.d(gS, com.baidu.adp.lib.OrmObject.toolsystem.orm.object.a.class)) {
            return OrmObject.objectWithJson(this.xF, gS);
        } else {
            return null;
        }
    }
}
