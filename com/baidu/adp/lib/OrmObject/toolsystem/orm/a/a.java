package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements h {
    private Object zD;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.zD = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.zD != null) {
            Class<?> componentType = this.zD.getClass().getComponentType();
            if (componentType == Character.TYPE) {
                return String.valueOf((char[]) this.zD);
            }
            if (componentType == Byte.TYPE) {
                try {
                    com.baidu.adp.lib.util.c.encodeBytes((byte[]) this.zD, 0);
                } catch (Exception e) {
                    return null;
                }
            } else {
                int length = Array.getLength(this.zD);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.r(Array.get(this.zD, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
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
        if (this.zD != null) {
            Class<?> componentType = this.zD.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                return this.zD;
            }
            if (componentType == Byte.TYPE) {
                return this.zD;
            }
            if (componentType == Character.TYPE) {
                return this.zD;
            }
            if (componentType == Double.TYPE) {
                return this.zD;
            }
            if (componentType == Float.TYPE) {
                return this.zD;
            }
            if (componentType == Integer.TYPE) {
                return this.zD;
            }
            if (componentType == Long.TYPE) {
                return this.zD;
            }
            if (componentType == Short.TYPE) {
                return this.zD;
            }
            if (componentType == String.class) {
                return this.zD;
            }
            int length = Array.getLength(this.zD);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.r(Array.get(this.zD, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
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
        return this.zD;
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
        return this.zD;
    }
}
