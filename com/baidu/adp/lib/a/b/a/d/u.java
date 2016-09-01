package com.baidu.adp.lib.a.b.a.d;

import android.util.SparseArray;
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

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> dd;
        try {
            dd = cVar.dd();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (dd == Byte.class || dd == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (dd == Short.class || dd == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (dd == Integer.class || dd == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (dd == Long.class || dd == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (dd == Float.class || dd == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (dd == Double.class || dd == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (dd == Character.class || dd == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (dd == Boolean.class || dd == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (dd == String.class) {
            return this.value;
        }
        if (dd == char[].class) {
            return this.value.toCharArray();
        }
        if (dd == byte[].class) {
            try {
                return com.baidu.adp.lib.util.c.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.a.a.a.e(dd, com.baidu.adp.lib.a.b.a.a.i.class)) {
            return com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(this.value, dd);
        } else {
            if (com.baidu.adp.lib.a.a.a.e(dd, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (dd.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.e(dd, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.e(dd, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.e(dd, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.a.a.a.e(dd, SparseArray.class)) {
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
