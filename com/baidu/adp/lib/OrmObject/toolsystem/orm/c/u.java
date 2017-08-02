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
        Class<?> eh;
        try {
            eh = cVar.eh();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (eh == Byte.class || eh == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (eh == Short.class || eh == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (eh == Integer.class || eh == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (eh == Long.class || eh == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (eh == Float.class || eh == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (eh == Double.class || eh == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (eh == Character.class || eh == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (eh == Boolean.class || eh == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (eh == String.class) {
            return this.value;
        }
        if (eh == char[].class) {
            return this.value.toCharArray();
        }
        if (eh == byte[].class) {
            try {
                return com.baidu.adp.lib.util.c.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.OrmObject.a.a.e(eh, OrmObject.class)) {
            return OrmObject.objectWithJsonStr(this.value, eh);
        } else {
            if (com.baidu.adp.lib.OrmObject.a.a.e(eh, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (eh.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.e(eh, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.e(eh, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.e(eh, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.OrmObject.a.a.e(eh, SparseArray.class)) {
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
