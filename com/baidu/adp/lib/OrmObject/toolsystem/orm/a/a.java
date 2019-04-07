package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements h {
    private Object zC;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.zC = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.zC != null) {
            Class<?> componentType = this.zC.getClass().getComponentType();
            if (componentType == Character.TYPE) {
                return String.valueOf((char[]) this.zC);
            }
            if (componentType == Byte.TYPE) {
                try {
                    com.baidu.adp.lib.util.c.encodeBytes((byte[]) this.zC, 0);
                } catch (Exception e) {
                    return null;
                }
            } else {
                int length = Array.getLength(this.zC);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.r(Array.get(this.zC, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
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
        if (this.zC != null) {
            Class<?> componentType = this.zC.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                return this.zC;
            }
            if (componentType == Byte.TYPE) {
                return this.zC;
            }
            if (componentType == Character.TYPE) {
                return this.zC;
            }
            if (componentType == Double.TYPE) {
                return this.zC;
            }
            if (componentType == Float.TYPE) {
                return this.zC;
            }
            if (componentType == Integer.TYPE) {
                return this.zC;
            }
            if (componentType == Long.TYPE) {
                return this.zC;
            }
            if (componentType == Short.TYPE) {
                return this.zC;
            }
            if (componentType == String.class) {
                return this.zC;
            }
            int length = Array.getLength(this.zC);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.r(Array.get(this.zC, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
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
        return this.zC;
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
        return this.zC;
    }
}
