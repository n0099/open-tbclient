package com.baidu.live.gift;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class v {
    public static List<u> Ie() {
        String string = com.baidu.live.d.BM().getString("gift_dynamic_res_last_accessed", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(new u().D(optJSONObject));
                    }
                }
                return arrayList;
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            com.baidu.live.d.BM().putString("gift_dynamic_res_last_accessed", "");
            return null;
        }
    }

    public static void gP(String str) {
        e(str, System.currentTimeMillis());
    }

    public static void e(String str, long j) {
        JSONArray jSONArray;
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            String string = com.baidu.live.d.BM().getString("gift_dynamic_res_last_accessed", "");
            try {
                if (!TextUtils.isEmpty(string)) {
                    jSONArray = new JSONArray(string);
                } else {
                    jSONArray = new JSONArray();
                }
            } catch (JSONException e) {
                jSONArray = new JSONArray();
                e.printStackTrace();
            }
            int i = 0;
            while (true) {
                if (i >= jSONArray.length()) {
                    break;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject == null || !str.equals(optJSONObject.optString("name"))) {
                    i++;
                } else {
                    z = true;
                    try {
                        optJSONObject.put("last_accessed", j);
                        break;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (!z) {
                u uVar = new u();
                uVar.name = str;
                uVar.aUE = j;
                JSONObject jsonObject = uVar.toJsonObject();
                if (jsonObject != null) {
                    jSONArray.put(jsonObject);
                }
            }
            com.baidu.live.d.BM().putString("gift_dynamic_res_last_accessed", jSONArray.toString());
        }
    }

    public static void he(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.live.d.BM().putString("gift_dynamic_res_last_accessed", "");
            return;
        }
        String string = com.baidu.live.d.BM().getString("gift_dynamic_res_last_accessed", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null && TextUtils.equals(str, optJSONObject.optString("name"))) {
                        if (Build.VERSION.SDK_INT >= 19) {
                            jSONArray.remove(i);
                        } else {
                            Field declaredField = JSONArray.class.getDeclaredField("values");
                            declaredField.setAccessible(true);
                            ((List) declaredField.get(jSONArray)).remove(i);
                        }
                        com.baidu.live.d.BM().putString("gift_dynamic_res_last_accessed", jSONArray.toString());
                        return;
                    }
                }
            } catch (IllegalAccessException | NoSuchFieldException | JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
