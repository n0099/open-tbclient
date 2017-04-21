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
        Class<?> ek;
        try {
            ek = cVar.ek();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (ek == Byte.class || ek == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (ek == Short.class || ek == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (ek == Integer.class || ek == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (ek == Long.class || ek == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (ek == Float.class || ek == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (ek == Double.class || ek == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (ek == Character.class || ek == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (ek == Boolean.class || ek == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (ek == String.class) {
            return this.value;
        }
        if (ek == char[].class) {
            return this.value.toCharArray();
        }
        if (ek == byte[].class) {
            try {
                return com.baidu.adp.lib.util.c.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.OrmObject.a.a.e(ek, OrmObject.class)) {
            return OrmObject.objectWithJsonStr(this.value, ek);
        } else {
            if (com.baidu.adp.lib.OrmObject.a.a.e(ek, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (ek.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.e(ek, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.e(ek, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.e(ek, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.OrmObject.a.a.e(ek, SparseArray.class)) {
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
