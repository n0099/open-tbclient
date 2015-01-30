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
        Class<?> cq;
        try {
            cq = cVar.cq();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (cq == Byte.class || cq == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (cq == Short.class || cq == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (cq == Integer.class || cq == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (cq == Long.class || cq == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (cq == Float.class || cq == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (cq == Double.class || cq == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (cq == Character.class || cq == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (cq == Boolean.class || cq == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (cq == String.class) {
            return this.value;
        }
        if (cq == char[].class) {
            return this.value.toCharArray();
        }
        if (cq == byte[].class) {
            try {
                return com.baidu.adp.lib.webSocket.a.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.a.a.a.a(cq, com.baidu.adp.lib.a.b.a.a.i.class)) {
            return com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(this.value, cq);
        } else {
            if (com.baidu.adp.lib.a.a.a.a(cq, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (cq.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(cq, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(cq, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(cq, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.a.a.a.a(cq, SparseArray.class)) {
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
