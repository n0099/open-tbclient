package com.baidu.swan.apps.setting.oauth;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String aRq = "";
    public String description = "";
    public final List<String> aRr = new ArrayList();
    public int aRs = -1;
    private String type = "";

    private e(String str) {
        this.id = str;
    }

    public boolean Kf() {
        return this.aRs > 0;
    }

    public boolean Kg() {
        return this.aRs != 0;
    }

    public boolean Kh() {
        return "1".equals(this.type);
    }

    public static e af(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("id", "");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return h(optString, jSONObject);
    }

    public static e h(String str, JSONObject jSONObject) {
        e eVar = new e(str);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.aRq = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.aRs = jSONObject.optInt("tip_status", -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.aRr.add(optJSONArray.optString(i));
            }
        }
        return eVar;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.aRs));
    }
}
