package cn.jiguang.d.h;

import com.baidu.ar.util.IoUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class h {
    public static int a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.toString().getBytes(IoUtils.UTF_8).length;
            } catch (UnsupportedEncodingException e) {
            }
        }
        return 0;
    }

    public static JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    public static JSONObject a(JSONObject jSONObject, Set<String> set) {
        JSONObject jSONObject2 = new JSONObject();
        if (set == null || set.isEmpty()) {
            return jSONObject2;
        }
        for (String str : set) {
            try {
                jSONObject2.put(str, jSONObject.opt(str));
            } catch (JSONException e) {
            }
        }
        return jSONObject2;
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null || jSONObject2.length() == 0 || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject.put(next, jSONObject2.get(next));
            } catch (JSONException e) {
            }
        }
    }

    public static boolean h(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }
}
