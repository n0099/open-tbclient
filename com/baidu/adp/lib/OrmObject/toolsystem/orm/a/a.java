package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements h {
    private Object Kq;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.Kq = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.Kq != null) {
            Class<?> componentType = this.Kq.getClass().getComponentType();
            if (componentType == Character.TYPE) {
                return String.valueOf((char[]) this.Kq);
            }
            if (componentType == Byte.TYPE) {
                try {
                    com.baidu.adp.lib.util.c.encodeBytes((byte[]) this.Kq, 0);
                } catch (Exception e) {
                    return null;
                }
            } else {
                int length = Array.getLength(this.Kq);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    Object a2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.r(Array.get(this.Kq, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
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
        if (this.Kq != null) {
            Class<?> componentType = this.Kq.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                return this.Kq;
            }
            if (componentType == Byte.TYPE) {
                return this.Kq;
            }
            if (componentType == Character.TYPE) {
                return this.Kq;
            }
            if (componentType == Double.TYPE) {
                return this.Kq;
            }
            if (componentType == Float.TYPE) {
                return this.Kq;
            }
            if (componentType == Integer.TYPE) {
                return this.Kq;
            }
            if (componentType == Long.TYPE) {
                return this.Kq;
            }
            if (componentType == Short.TYPE) {
                return this.Kq;
            }
            if (componentType == String.class) {
                return this.Kq;
            }
            int length = Array.getLength(this.Kq);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                Object a2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.r(Array.get(this.Kq, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
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
        return this.Kq;
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
        return this.Kq;
    }
}
