package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u implements h {
    private String value;

    public u(String str) {
        this.value = str;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eV;
        try {
            eV = cVar.eV();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (eV == Byte.class || eV == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (eV == Short.class || eV == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (eV == Integer.class || eV == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (eV == Long.class || eV == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (eV == Float.class || eV == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (eV == Double.class || eV == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (eV == Character.class || eV == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (eV == Boolean.class || eV == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (eV == String.class) {
            return this.value;
        }
        if (eV == char[].class) {
            return this.value.toCharArray();
        }
        if (eV == byte[].class) {
            try {
                return com.baidu.adp.lib.util.c.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(eV, OrmObject.class)) {
            return OrmObject.objectWithJsonStr(this.value, eV);
        } else {
            if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(eV, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (eV.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(eV, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(eV, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(eV, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(eV, SparseArray.class)) {
                    try {
                        return new k(new JSONObject(this.value)).g(cVar);
                    } catch (JSONException e8) {
                        e8.printStackTrace();
                    }
                }
                return null;
            }
        }
        e.printStackTrace();
        return null;
    }
}
