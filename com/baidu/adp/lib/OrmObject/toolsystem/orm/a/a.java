package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements h {
    private Object oW;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.oW = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.oW != null) {
            Class<?> componentType = this.oW.getClass().getComponentType();
            if (componentType == Character.TYPE) {
                return String.valueOf((char[]) this.oW);
            }
            if (componentType == Byte.TYPE) {
                try {
                    com.baidu.adp.lib.util.c.encodeBytes((byte[]) this.oW, 0);
                } catch (Exception e) {
                    return null;
                }
            } else {
                int length = Array.getLength(this.oW);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.q(Array.get(this.oW, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
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
        if (this.oW != null) {
            Class<?> componentType = this.oW.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                return this.oW;
            }
            if (componentType == Byte.TYPE) {
                return this.oW;
            }
            if (componentType == Character.TYPE) {
                return this.oW;
            }
            if (componentType == Double.TYPE) {
                return this.oW;
            }
            if (componentType == Float.TYPE) {
                return this.oW;
            }
            if (componentType == Integer.TYPE) {
                return this.oW;
            }
            if (componentType == Long.TYPE) {
                return this.oW;
            }
            if (componentType == Short.TYPE) {
                return this.oW;
            }
            if (componentType == String.class) {
                return this.oW;
            }
            int length = Array.getLength(this.oW);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.q(Array.get(this.oW, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
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
        return this.oW;
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
        return this.oW;
    }
}
