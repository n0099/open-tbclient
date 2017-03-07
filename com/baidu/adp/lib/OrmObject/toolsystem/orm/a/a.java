package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements h {
    private Object sF;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.sF = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.sF != null) {
            Class<?> componentType = this.sF.getClass().getComponentType();
            if (componentType == Character.TYPE) {
                return String.valueOf((char[]) this.sF);
            }
            if (componentType == Byte.TYPE) {
                try {
                    com.baidu.adp.lib.util.c.encodeBytes((byte[]) this.sF, 0);
                } catch (Exception e) {
                    return null;
                }
            } else {
                int length = Array.getLength(this.sF);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.l(Array.get(this.sF, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
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
        if (this.sF != null) {
            Class<?> componentType = this.sF.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                return this.sF;
            }
            if (componentType == Byte.TYPE) {
                return this.sF;
            }
            if (componentType == Character.TYPE) {
                return this.sF;
            }
            if (componentType == Double.TYPE) {
                return this.sF;
            }
            if (componentType == Float.TYPE) {
                return this.sF;
            }
            if (componentType == Integer.TYPE) {
                return this.sF;
            }
            if (componentType == Long.TYPE) {
                return this.sF;
            }
            if (componentType == Short.TYPE) {
                return this.sF;
            }
            if (componentType == String.class) {
                return this.sF;
            }
            int length = Array.getLength(this.sF);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.l(Array.get(this.sF, i)).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
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
        return this.sF;
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
        return this.sF;
    }
}
