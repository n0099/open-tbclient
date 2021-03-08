package com.baidu.ar.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class d {
    public static a a(Context context) {
        JSONObject jSONObject;
        SharedPreferences sharedPreferences = context.getSharedPreferences("ar_ability_classification", 0);
        String string = sharedPreferences.getString("s", null);
        if (TextUtils.isEmpty(string)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
        }
        if (jSONObject != null) {
            a aVar = new a();
            aVar.bH = sharedPreferences.getString("v", "");
            aVar.bI = jSONObject;
            return aVar;
        }
        return null;
    }

    public static void a(Context context, a aVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("ar_ability_classification", 0).edit();
        edit.putString("v", aVar.bH);
        edit.putString("s", aVar.bI.toString());
        edit.putInt("sv", com.baidu.ar.h.c.getVersionCode());
        edit.apply();
    }
}
