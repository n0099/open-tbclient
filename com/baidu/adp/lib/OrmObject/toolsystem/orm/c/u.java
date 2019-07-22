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
        Class<?> hb;
        try {
            hb = cVar.hb();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (hb == Byte.class || hb == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (hb == Short.class || hb == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (hb == Integer.class || hb == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (hb == Long.class || hb == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (hb == Float.class || hb == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (hb == Double.class || hb == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (hb == Character.class || hb == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (hb == Boolean.class || hb == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (hb == String.class) {
            return this.value;
        }
        if (hb == char[].class) {
            return this.value.toCharArray();
        }
        if (hb == byte[].class) {
            try {
                return com.baidu.adp.lib.util.c.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.OrmObject.a.a.d(hb, OrmObject.class)) {
            return OrmObject.objectWithJsonStr(this.value, hb);
        } else {
            if (com.baidu.adp.lib.OrmObject.a.a.d(hb, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (hb.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(hb, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(hb, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(hb, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.OrmObject.a.a.d(hb, SparseArray.class)) {
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
