package com.baidu.swan.apps.setting.oauth;

import android.text.TextUtils;
import com.coloros.mcssdk.mode.Message;
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
    public String bor = "";
    public String description = "";
    public List<String> bos = new ArrayList();
    public final List<String> bot = new ArrayList();
    public int bou = -1;
    private String type = "";

    private e(String str) {
        this.id = str;
    }

    public boolean So() {
        return this.bou > 0;
    }

    public boolean Sp() {
        return this.bou != 0;
    }

    public boolean Sq() {
        return "1".equals(this.type);
    }

    public static e aE(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("id", "");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return i(optString, jSONObject);
    }

    public static e i(String str, JSONObject jSONObject) {
        e eVar = new e(str);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.bor = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.bou = jSONObject.optInt("tip_status", -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.bot.add(optJSONArray.optString(i));
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    eVar.bos.add(optJSONArray2.optString(i2));
                }
            }
        }
        return eVar;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.bou));
    }
}
