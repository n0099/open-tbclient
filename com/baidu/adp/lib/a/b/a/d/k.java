package com.baidu.adp.lib.a.b.a.d;

import android.util.SparseArray;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k implements h {
    private JSONObject sH;

    public k(JSONObject jSONObject) {
        this.sH = jSONObject;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fT = cVar.fT();
        Type[] fS = cVar.fS();
        if (com.baidu.adp.lib.a.a.a.a(fT, Map.class)) {
            Map<String, Object> d = com.baidu.adp.lib.a.b.a.e.a.d(cVar, this.sH.length());
            if (d != null) {
                Iterator<String> keys = this.sH.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next instanceof String) {
                        String str = next;
                        Object g = com.baidu.adp.lib.a.b.a.e.g.j(this.sH.opt(str)).g(new com.baidu.adp.lib.a.b.a.e.c(fS[1]));
                        if (g != null) {
                            d.put(str, g);
                        }
                    }
                }
            }
            return d;
        } else if (fT == SparseArray.class) {
            SparseArray sparseArray = new SparseArray(this.sH.length());
            Iterator<String> keys2 = this.sH.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (next2 instanceof String) {
                    String str2 = next2;
                    try {
                        int parseInt = Integer.parseInt(str2);
                        Object g2 = com.baidu.adp.lib.a.b.a.e.g.j(this.sH.opt(String.valueOf(str2))).g(new com.baidu.adp.lib.a.b.a.e.c(fS[0]));
                        if (g2 != null) {
                            sparseArray.put(parseInt, g2);
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
            return sparseArray;
        } else if (com.baidu.adp.lib.a.a.a.a(fT, com.baidu.adp.lib.a.b.a.a.a.class)) {
            return com.baidu.adp.lib.a.b.a.a.i.objectWithJson(this.sH, fT);
        } else {
            return null;
        }
    }
}
