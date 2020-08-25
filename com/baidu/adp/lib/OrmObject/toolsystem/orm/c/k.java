package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k implements h {
    private JSONObject JS;

    public k(JSONObject jSONObject) {
        this.JS = jSONObject;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fieldClass = cVar.getFieldClass();
        Type[] lL = cVar.lL();
        if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fieldClass, Map.class)) {
            Map<String, Object> d = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.d(cVar, this.JS.length());
            if (d != null) {
                Iterator<String> keys = this.JS.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next instanceof String) {
                        String str = next;
                        Object g = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.v(this.JS.opt(str)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(lL[1]));
                        if (g != null) {
                            d.put(str, g);
                        }
                    }
                }
            }
            return d;
        } else if (fieldClass == SparseArray.class) {
            SparseArray sparseArray = new SparseArray(this.JS.length());
            Iterator<String> keys2 = this.JS.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (next2 instanceof String) {
                    String str2 = next2;
                    try {
                        int parseInt = Integer.parseInt(str2);
                        Object g2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.v(this.JS.opt(String.valueOf(str2))).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(lL[0]));
                        if (g2 != null) {
                            sparseArray.put(parseInt, g2);
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
            return sparseArray;
        } else if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fieldClass, com.baidu.adp.lib.OrmObject.toolsystem.orm.object.a.class)) {
            return OrmObject.objectWithJson(this.JS, fieldClass);
        } else {
            return null;
        }
    }
}
