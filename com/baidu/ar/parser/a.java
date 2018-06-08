package com.baidu.ar.parser;

import android.text.TextUtils;
import com.baidu.ar.bean.c;
import com.baidu.ar.util.ARFileUtils;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    private static final String a = a.class.getSimpleName();

    private a() {
    }

    private static c.a a(JSONObject jSONObject) {
        c.a aVar = new c.a();
        try {
            if (jSONObject.has("resPath")) {
                aVar.a(jSONObject.getString("resPath"));
            }
            if (jSONObject.has("resId")) {
                aVar.b(jSONObject.getString("resId"));
            }
            if (jSONObject.has("encoding")) {
                aVar.c(jSONObject.getString("encoding"));
            }
            if (jSONObject.has(ARResourceKey.HTTP_AR_MD5)) {
                aVar.d(jSONObject.getString(ARResourceKey.HTTP_AR_MD5));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aVar;
    }

    public static c a(String str, String str2) {
        String resConfigJsonPath = ARFileUtils.getResConfigJsonPath(str);
        try {
            if (!new File(resConfigJsonPath).exists() || TextUtils.isEmpty(str2)) {
                return null;
            }
            return b(str2, resConfigJsonPath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static c b(String str, String str2) {
        JSONObject jSONObject;
        c cVar = new c();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONObject.has("res")) {
            JSONArray jSONArray = jSONObject.getJSONArray("res");
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                try {
                    c.a a2 = a((JSONObject) jSONArray.get(i2));
                    if (a2 != null && !TextUtils.isEmpty(a2.a())) {
                        hashMap.put(a2.a(), a2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                i = i2 + 1;
                e.printStackTrace();
            }
            cVar.a(hashMap);
        }
        return cVar;
    }
}
