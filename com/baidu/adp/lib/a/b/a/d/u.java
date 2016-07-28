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
        Class<?> ci;
        try {
            ci = cVar.ci();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (ci == Byte.class || ci == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (ci == Short.class || ci == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (ci == Integer.class || ci == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (ci == Long.class || ci == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (ci == Float.class || ci == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (ci == Double.class || ci == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (ci == Character.class || ci == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (ci == Boolean.class || ci == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (ci == String.class) {
            return this.value;
        }
        if (ci == char[].class) {
            return this.value.toCharArray();
        }
        if (ci == byte[].class) {
            try {
                return com.baidu.adp.lib.util.c.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.a.a.a.e(ci, com.baidu.adp.lib.a.b.a.a.i.class)) {
            return com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(this.value, ci);
        } else {
            if (com.baidu.adp.lib.a.a.a.e(ci, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (ci.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.e(ci, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.e(ci, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.e(ci, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.a.a.a.e(ci, SparseArray.class)) {
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
