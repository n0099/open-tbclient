package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements h {
    private Object agb;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.agb = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.agb != null) {
            Class<?> componentType = this.agb.getClass().getComponentType();
            if (componentType == Character.TYPE) {
                return String.valueOf((char[]) this.agb);
            }
            if (componentType == Byte.TYPE) {
                try {
                    com.baidu.adp.lib.util.c.encodeBytes((byte[]) this.agb, 0);
                } catch (Exception e) {
                    return null;
                }
            } else {
                int length = Array.getLength(this.agb);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.ap(Array.get(this.agb, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
                    if (a != null) {
                        jSONArray.put(a);
                    }
                }
                return jSONArray;
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object b(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.agb != null) {
            Class<?> componentType = this.agb.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                return this.agb;
            }
            if (componentType == Byte.TYPE) {
                return this.agb;
            }
            if (componentType == Character.TYPE) {
                return this.agb;
            }
            if (componentType == Double.TYPE) {
                return this.agb;
            }
            if (componentType == Float.TYPE) {
                return this.agb;
            }
            if (componentType == Integer.TYPE) {
                return this.agb;
            }
            if (componentType == Long.TYPE) {
                return this.agb;
            }
            if (componentType == Short.TYPE) {
                return this.agb;
            }
            if (componentType == String.class) {
                return this.agb;
            }
            int length = Array.getLength(this.agb);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.ap(Array.get(this.agb, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
                if (a != null) {
                    jSONArray.put(a);
                }
            }
            return jSONArray.toString();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object c(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return b(cVar);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object d(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return this.agb;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object e(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
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

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object f(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return this.agb;
    }
}
