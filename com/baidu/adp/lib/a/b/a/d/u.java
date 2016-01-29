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
        Class<?> fT;
        try {
            fT = cVar.fT();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (fT == Byte.class || fT == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (fT == Short.class || fT == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (fT == Integer.class || fT == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (fT == Long.class || fT == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (fT == Float.class || fT == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (fT == Double.class || fT == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (fT == Character.class || fT == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (fT == Boolean.class || fT == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (fT == String.class) {
            return this.value;
        }
        if (fT == char[].class) {
            return this.value.toCharArray();
        }
        if (fT == byte[].class) {
            try {
                return com.baidu.adp.lib.util.c.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.a.a.a.a(fT, com.baidu.adp.lib.a.b.a.a.i.class)) {
            return com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(this.value, fT);
        } else {
            if (com.baidu.adp.lib.a.a.a.a(fT, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (fT.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(fT, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(fT, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.a.a.a.a(fT, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.a.a.a.a(fT, SparseArray.class)) {
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
