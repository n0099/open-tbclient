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
        Class<?> hZ;
        try {
            hZ = cVar.hZ();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (hZ == Byte.class || hZ == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (hZ == Short.class || hZ == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (hZ == Integer.class || hZ == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (hZ == Long.class || hZ == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (hZ == Float.class || hZ == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (hZ == Double.class || hZ == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (hZ == Character.class || hZ == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (hZ == Boolean.class || hZ == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (hZ == String.class) {
            return this.value;
        }
        if (hZ == char[].class) {
            return this.value.toCharArray();
        }
        if (hZ == byte[].class) {
            try {
                return com.baidu.adp.lib.util.c.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.OrmObject.a.a.d(hZ, OrmObject.class)) {
            return OrmObject.objectWithJsonStr(this.value, hZ);
        } else {
            if (com.baidu.adp.lib.OrmObject.a.a.d(hZ, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (hZ.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(hZ, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(hZ, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(hZ, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.OrmObject.a.a.d(hZ, SparseArray.class)) {
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
