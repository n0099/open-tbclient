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
        Class<?> fp;
        try {
            fp = cVar.fp();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (fp == Byte.class || fp == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (fp == Short.class || fp == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (fp == Integer.class || fp == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (fp == Long.class || fp == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (fp == Float.class || fp == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (fp == Double.class || fp == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (fp == Character.class || fp == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (fp == Boolean.class || fp == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (fp == String.class) {
            return this.value;
        }
        if (fp == char[].class) {
            return this.value.toCharArray();
        }
        if (fp == byte[].class) {
            try {
                return com.baidu.adp.lib.util.c.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fp, OrmObject.class)) {
            return OrmObject.objectWithJsonStr(this.value, fp);
        } else {
            if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fp, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (fp.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fp, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fp, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fp, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fp, SparseArray.class)) {
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
