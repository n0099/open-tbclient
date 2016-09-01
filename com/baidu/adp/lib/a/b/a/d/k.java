package com.baidu.adp.lib.a.b.a.d;

import android.util.SparseArray;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k implements h {
    private JSONObject ln;

    public k(JSONObject jSONObject) {
        this.ln = jSONObject;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> dd = cVar.dd();
        Type[] dc = cVar.dc();
        if (com.baidu.adp.lib.a.a.a.e(dd, Map.class)) {
            Map<String, Object> d = com.baidu.adp.lib.a.b.a.e.a.d(cVar, this.ln.length());
            if (d != null) {
                Iterator<String> keys = this.ln.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next instanceof String) {
                        String str = next;
                        Object g = com.baidu.adp.lib.a.b.a.e.g.m(this.ln.opt(str)).g(new com.baidu.adp.lib.a.b.a.e.c(dc[1]));
                        if (g != null) {
                            d.put(str, g);
                        }
                    }
                }
            }
            return d;
        } else if (dd == SparseArray.class) {
            SparseArray sparseArray = new SparseArray(this.ln.length());
            Iterator<String> keys2 = this.ln.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (next2 instanceof String) {
                    String str2 = next2;
                    try {
                        int parseInt = Integer.parseInt(str2);
                        Object g2 = com.baidu.adp.lib.a.b.a.e.g.m(this.ln.opt(String.valueOf(str2))).g(new com.baidu.adp.lib.a.b.a.e.c(dc[0]));
                        if (g2 != null) {
                            sparseArray.put(parseInt, g2);
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
            return sparseArray;
        } else if (com.baidu.adp.lib.a.a.a.e(dd, com.baidu.adp.lib.a.b.a.a.a.class)) {
            return com.baidu.adp.lib.a.b.a.a.i.objectWithJson(this.ln, dd);
        } else {
            return null;
        }
    }
}
