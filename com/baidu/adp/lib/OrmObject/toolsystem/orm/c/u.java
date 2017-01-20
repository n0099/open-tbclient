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
        Class<?> db;
        try {
            db = cVar.db();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (db == Byte.class || db == Byte.TYPE) {
            return Byte.valueOf(Byte.parseByte(this.value));
        }
        if (db == Short.class || db == Short.TYPE) {
            return Short.valueOf(Short.parseShort(this.value));
        }
        if (db == Integer.class || db == Integer.TYPE) {
            return Integer.valueOf(Integer.parseInt(this.value));
        }
        if (db == Long.class || db == Long.TYPE) {
            return Long.valueOf(Long.parseLong(this.value));
        }
        if (db == Float.class || db == Float.TYPE) {
            return Float.valueOf(Float.parseFloat(this.value));
        }
        if (db == Double.class || db == Double.TYPE) {
            return Double.valueOf(Double.parseDouble(this.value));
        }
        if (db == Character.class || db == Character.TYPE) {
            return Character.valueOf(this.value.charAt(0));
        }
        if (db == Boolean.class || db == Boolean.TYPE) {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        }
        if (db == String.class) {
            return this.value;
        }
        if (db == char[].class) {
            return this.value.toCharArray();
        }
        if (db == byte[].class) {
            try {
                return com.baidu.adp.lib.util.c.decode(this.value, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else if (com.baidu.adp.lib.OrmObject.a.a.e(db, OrmObject.class)) {
            return OrmObject.objectWithJsonStr(this.value, db);
        } else {
            if (com.baidu.adp.lib.OrmObject.a.a.e(db, List.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } else if (db.isArray()) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.e(db, Queue.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.e(db, Set.class)) {
                try {
                    return new j(new JSONArray(this.value)).g(cVar);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else if (com.baidu.adp.lib.OrmObject.a.a.e(db, Map.class)) {
                try {
                    return new k(new JSONObject(this.value)).g(cVar);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            } else {
                if (com.baidu.adp.lib.OrmObject.a.a.e(db, SparseArray.class)) {
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
