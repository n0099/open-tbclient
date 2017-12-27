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
        Class<?> lK;
        try {
            lK = cVar.lK();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (lK == Byte.class || lK == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (lK == Short.class || lK == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (lK == Integer.class || lK == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (lK == Long.class || lK == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (lK == Float.class || lK == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (lK == Double.class || lK == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (lK == Character.class || lK == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (lK == Boolean.class || lK == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (lK == String.class) {
            return this.value;
        }
        if (lK == char[].class) {
            return this.value.toCharArray();
        }
        if (lK == byte[].class) {
            try {
                return com.baidu.adp.lib.util.c.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.OrmObject.a.a.d(lK, OrmObject.class)) {
            return OrmObject.objectWithJsonStr(this.value, lK);
        } else {
            if (com.baidu.adp.lib.OrmObject.a.a.d(lK, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (lK.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(lK, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(lK, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(lK, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.OrmObject.a.a.d(lK, SparseArray.class)) {
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
