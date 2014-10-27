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
        Class<?> bS;
        try {
            bS = cVar.bS();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (bS == Byte.class || bS == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (bS == Short.class || bS == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (bS == Integer.class || bS == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (bS == Long.class || bS == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (bS == Float.class || bS == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (bS == Double.class || bS == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (bS == Character.class || bS == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (bS == Boolean.class || bS == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (bS == String.class) {
            return this.value;
        }
        if (bS == char[].class) {
            return this.value.toCharArray();
        }
        if (bS == byte[].class) {
            try {
                return com.baidu.adp.lib.webSocket.a.k(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.a.a.a.a(bS, com.baidu.adp.lib.a.b.a.a.i.class)) {
            return com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(this.value, bS);
        } else {
            if (com.baidu.adp.lib.a.a.a.a(bS, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (bS.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(bS, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(bS, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(bS, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.a.a.a.a(bS, SparseArray.class)) {
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
