package com.baidu.swan.apps.setting.oauth;

import android.text.TextUtils;
import com.coloros.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    public a bOD;
    public JSONObject bOE;
    public String bOF;
    public String bOG;
    public boolean bOw;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String bOx = "";
    public String description = "";
    public List<String> bOy = new ArrayList();
    public final List<String> bOz = new ArrayList();
    public int bOA = -1;
    private String type = "";
    public String bOB = "";
    public String bOC = "";

    /* loaded from: classes9.dex */
    public static class a {
        public String bOH;
        public String bOI;
        public String bOJ;
        public String bOK;
        public String detailUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean abB() {
        return this.bOA > 0;
    }

    public boolean abC() {
        return this.bOA != 0;
    }

    public boolean abD() {
        return "1".equals(this.type);
    }

    public static e aQ(JSONObject jSONObject) {
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
        eVar.bOw = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.bOx = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.bOA = jSONObject.optInt("tip_status", -1);
        eVar.bOB = jSONObject.optString("explain", "");
        eVar.bOC = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.bOz.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.bOy.add(optJSONArray2.optString(i2));
            }
        }
        eVar.bOE = jSONObject.optJSONObject("other");
        eVar.bOF = jSONObject.optString("plugin_app_name");
        eVar.bOG = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void abE() {
        if (this.bOE != null && this.bOE.keys() != null && this.bOE.keys().hasNext()) {
            this.bOD = new a();
            this.bOD.bOH = this.bOE.optString("detail_text");
            this.bOD.detailUrl = this.bOE.optString("detail_url");
            this.bOD.bOI = this.bOE.optString("text_color");
            this.bOD.bOJ = this.bOE.optString("keyword");
            this.bOD.bOK = this.bOE.optString("key_color");
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.bOA));
    }
}
