package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements h {
    private Object JX;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.JX = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.JX != null) {
            Class<?> componentType = this.JX.getClass().getComponentType();
            if (componentType == Character.TYPE) {
                return String.valueOf((char[]) this.JX);
            }
            if (componentType == Byte.TYPE) {
                try {
                    com.baidu.adp.lib.util.c.encodeBytes((byte[]) this.JX, 0);
                } catch (Exception e) {
                    return null;
                }
            } else {
                int length = Array.getLength(this.JX);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    Object a2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.v(Array.get(this.JX, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
                    if (a2 != null) {
                        jSONArray.put(a2);
                    }
                }
                return jSONArray;
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object b(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.JX != null) {
            Class<?> componentType = this.JX.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                return this.JX;
            }
            if (componentType == Byte.TYPE) {
                return this.JX;
            }
            if (componentType == Character.TYPE) {
                return this.JX;
            }
            if (componentType == Double.TYPE) {
                return this.JX;
            }
            if (componentType == Float.TYPE) {
                return this.JX;
            }
            if (componentType == Integer.TYPE) {
                return this.JX;
            }
            if (componentType == Long.TYPE) {
                return this.JX;
            }
            if (componentType == Short.TYPE) {
                return this.JX;
            }
            if (componentType == String.class) {
                return this.JX;
            }
            int length = Array.getLength(this.JX);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                Object a2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.v(Array.get(this.JX, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
                if (a2 != null) {
                    jSONArray.put(a2);
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
        return this.JX;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object e(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Object a2 = a(cVar);
        if (a2 != null) {
            if (a2 instanceof JSONObject) {
                return a2.toString();
            }
            if (a2 instanceof JSONArray) {
                return a2.toString();
            }
            return a2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object f(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return this.JX;
    }
}
