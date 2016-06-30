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
        Class<?> cj;
        try {
            cj = cVar.cj();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (cj == Byte.class || cj == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (cj == Short.class || cj == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (cj == Integer.class || cj == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (cj == Long.class || cj == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (cj == Float.class || cj == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (cj == Double.class || cj == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (cj == Character.class || cj == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (cj == Boolean.class || cj == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (cj == String.class) {
            return this.value;
        }
        if (cj == char[].class) {
            return this.value.toCharArray();
        }
        if (cj == byte[].class) {
            try {
                return com.baidu.adp.lib.util.c.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.a.a.a.a(cj, com.baidu.adp.lib.a.b.a.a.i.class)) {
            return com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(this.value, cj);
        } else {
            if (com.baidu.adp.lib.a.a.a.a(cj, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (cj.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(cj, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(cj, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(cj, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.a.a.a.a(cj, SparseArray.class)) {
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
