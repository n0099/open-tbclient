package com.baidu.adp.lib.a.b.a.d;

import android.util.SparseArray;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k implements h {
    private JSONObject so;

    public k(JSONObject jSONObject) {
        this.so = jSONObject;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fL = cVar.fL();
        Type[] fK = cVar.fK();
        if (com.baidu.adp.lib.a.a.a.a(fL, Map.class)) {
            Map<String, Object> d = com.baidu.adp.lib.a.b.a.e.a.d(cVar, this.so.length());
            if (d != null) {
                Iterator<String> keys = this.so.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next instanceof String) {
                        String str = next;
                        Object g = com.baidu.adp.lib.a.b.a.e.g.j(this.so.opt(str)).g(new com.baidu.adp.lib.a.b.a.e.c(fK[1]));
                        if (g != null) {
                            d.put(str, g);
                        }
                    }
                }
            }
            return d;
        } else if (fL == SparseArray.class) {
            SparseArray sparseArray = new SparseArray(this.so.length());
            Iterator<String> keys2 = this.so.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (next2 instanceof String) {
                    String str2 = next2;
                    try {
                        int parseInt = Integer.parseInt(str2);
                        Object g2 = com.baidu.adp.lib.a.b.a.e.g.j(this.so.opt(String.valueOf(str2))).g(new com.baidu.adp.lib.a.b.a.e.c(fK[0]));
                        if (g2 != null) {
                            sparseArray.put(parseInt, g2);
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
            return sparseArray;
        } else if (com.baidu.adp.lib.a.a.a.a(fL, com.baidu.adp.lib.a.b.a.a.a.class)) {
            return com.baidu.adp.lib.a.b.a.a.i.objectWithJson(this.so, fL);
        } else {
            return null;
        }
    }
}
