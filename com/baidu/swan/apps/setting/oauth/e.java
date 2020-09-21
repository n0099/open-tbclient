package com.baidu.swan.apps.setting.oauth;

import android.text.TextUtils;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public JSONObject cXj;
    public boolean cXk;
    public a cXr;
    public JSONObject cXs;
    public String cXt;
    public String cXu;
    public String cXv;
    public List<e> cXw;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String cXl = "";
    public String description = "";
    public List<String> cXm = new ArrayList();
    public final List<String> cXn = new ArrayList();
    public int cXo = -1;
    private String type = "";
    public String cXp = "";
    public String cXq = "";

    /* loaded from: classes3.dex */
    public static class a {
        public String cXA;
        public JSONArray cXB;
        public String cXx;
        public String cXy;
        public String cXz;
        public String detailUrl;
    }

    public void ax(List<e> list) {
        this.cXw = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aCo() {
        return this.cXo > 0;
    }

    public boolean aCp() {
        return this.cXo != 0;
    }

    public boolean aCq() {
        return "1".equals(this.type);
    }

    public static e bH(JSONObject jSONObject) {
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
        eVar.cXj = jSONObject;
        eVar.cXk = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.cXl = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.cXo = jSONObject.optInt("tip_status", -1);
        eVar.cXp = jSONObject.optString("explain", "");
        eVar.cXq = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.cXn.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.cXm.add(optJSONArray2.optString(i2));
            }
        }
        eVar.cXs = jSONObject.optJSONObject("other");
        eVar.cXt = jSONObject.optString("plugin_app_name");
        eVar.cXu = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aCr() {
        if (this.cXs != null && this.cXs.keys() != null && this.cXs.keys().hasNext()) {
            this.cXr = new a();
            this.cXr.cXx = this.cXs.optString("detail_text");
            this.cXr.detailUrl = this.cXs.optString("detail_url");
            this.cXr.cXy = this.cXs.optString("text_color");
            this.cXr.cXz = this.cXs.optString("keyword");
            this.cXr.cXA = this.cXs.optString("key_color");
            JSONObject optJSONObject = this.cXs.optJSONObject("developer_agreements");
            if (optJSONObject != null) {
                this.cXr.cXB = optJSONObject.optJSONArray("details");
            }
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.cXo));
    }
}
