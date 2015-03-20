package com.baidu.adp.lib.a.b.a.b;

import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements h {
    private Object rG;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.rG = obj;
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object a(com.baidu.adp.lib.a.b.a.e.c cVar) {
        if (this.rG != null) {
            Class<?> componentType = this.rG.getClass().getComponentType();
            if (componentType == Character.TYPE) {
                return String.valueOf((char[]) this.rG);
            }
            if (componentType == Byte.TYPE) {
                try {
                    com.baidu.adp.lib.util.c.d((byte[]) this.rG, 0);
                } catch (Exception e) {
                    return null;
                }
            } else {
                int length = Array.getLength(this.rG);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    Object a = com.baidu.adp.lib.a.b.a.e.f.h(Array.get(this.rG, i)).a(new com.baidu.adp.lib.a.b.a.e.c(componentType));
                    if (a != null) {
                        jSONArray.put(a);
                    }
                }
                return jSONArray;
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object b(com.baidu.adp.lib.a.b.a.e.c cVar) {
        if (this.rG != null) {
            Class<?> componentType = this.rG.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                return this.rG;
            }
            if (componentType == Byte.TYPE) {
                return this.rG;
            }
            if (componentType == Character.TYPE) {
                return this.rG;
            }
            if (componentType == Double.TYPE) {
                return this.rG;
            }
            if (componentType == Float.TYPE) {
                return this.rG;
            }
            if (componentType == Integer.TYPE) {
                return this.rG;
            }
            if (componentType == Long.TYPE) {
                return this.rG;
            }
            if (componentType == Short.TYPE) {
                return this.rG;
            }
            if (componentType == String.class) {
                return this.rG;
            }
            int length = Array.getLength(this.rG);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                Object a = com.baidu.adp.lib.a.b.a.e.f.h(Array.get(this.rG, i)).a(new com.baidu.adp.lib.a.b.a.e.c(componentType));
                if (a != null) {
                    jSONArray.put(a);
                }
            }
            return jSONArray.toString();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object c(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return b(cVar);
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object d(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return this.rG;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object e(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Object a = a(cVar);
        if (a != null) {
            if (a instanceof JSONObject) {
                return a.toString();
            }
            if (a instanceof JSONArray) {
                return a.toString();
            }
            return a;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object f(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return this.rG;
    }
}
