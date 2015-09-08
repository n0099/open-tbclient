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
        Class<?> fL;
        try {
            fL = cVar.fL();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (fL == Byte.class || fL == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (fL == Short.class || fL == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (fL == Integer.class || fL == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (fL == Long.class || fL == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (fL == Float.class || fL == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (fL == Double.class || fL == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (fL == Character.class || fL == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (fL == Boolean.class || fL == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (fL == String.class) {
            return this.value;
        }
        if (fL == char[].class) {
            return this.value.toCharArray();
        }
        if (fL == byte[].class) {
            try {
                return com.baidu.adp.lib.util.c.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.a.a.a.a(fL, com.baidu.adp.lib.a.b.a.a.i.class)) {
            return com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(this.value, fL);
        } else {
            if (com.baidu.adp.lib.a.a.a.a(fL, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (fL.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(fL, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(fL, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(fL, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.a.a.a.a(fL, SparseArray.class)) {
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
