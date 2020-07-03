package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements h {
    private Object IW;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.IW = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.IW != null) {
            Class<?> componentType = this.IW.getClass().getComponentType();
            if (componentType == Character.TYPE) {
                return String.valueOf((char[]) this.IW);
            }
            if (componentType == Byte.TYPE) {
                try {
                    com.baidu.adp.lib.util.c.encodeBytes((byte[]) this.IW, 0);
                } catch (Exception e) {
                    return null;
                }
            } else {
                int length = Array.getLength(this.IW);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.t(Array.get(this.IW, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
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
        if (this.IW != null) {
            Class<?> componentType = this.IW.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                return this.IW;
            }
            if (componentType == Byte.TYPE) {
                return this.IW;
            }
            if (componentType == Character.TYPE) {
                return this.IW;
            }
            if (componentType == Double.TYPE) {
                return this.IW;
            }
            if (componentType == Float.TYPE) {
                return this.IW;
            }
            if (componentType == Integer.TYPE) {
                return this.IW;
            }
            if (componentType == Long.TYPE) {
                return this.IW;
            }
            if (componentType == Short.TYPE) {
                return this.IW;
            }
            if (componentType == String.class) {
                return this.IW;
            }
            int length = Array.getLength(this.IW);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.t(Array.get(this.IW, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
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
        return this.IW;
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
        return this.IW;
    }
}
