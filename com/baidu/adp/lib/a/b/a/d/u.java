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
        Class<?> cs;
        try {
            cs = cVar.cs();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (cs == Byte.class || cs == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (cs == Short.class || cs == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (cs == Integer.class || cs == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (cs == Long.class || cs == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (cs == Float.class || cs == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (cs == Double.class || cs == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (cs == Character.class || cs == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (cs == Boolean.class || cs == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (cs == String.class) {
            return this.value;
        }
        if (cs == char[].class) {
            return this.value.toCharArray();
        }
        if (cs == byte[].class) {
            try {
                return com.baidu.adp.lib.webSocket.a.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.a.a.a.a(cs, com.baidu.adp.lib.a.b.a.a.i.class)) {
            return com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(this.value, cs);
        } else {
            if (com.baidu.adp.lib.a.a.a.a(cs, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (cs.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(cs, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(cs, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(cs, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.a.a.a.a(cs, SparseArray.class)) {
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
