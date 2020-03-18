package com.baidu.swan.apps.setting.oauth;

import android.text.TextUtils;
import com.coloros.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public a bTF;
    public JSONObject bTG;
    public String bTH;
    public String bTI;
    public boolean bTy;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String bTz = "";
    public String description = "";
    public List<String> bTA = new ArrayList();
    public final List<String> bTB = new ArrayList();
    public int bTC = -1;
    private String type = "";
    public String bTD = "";
    public String bTE = "";

    /* loaded from: classes11.dex */
    public static class a {
        public String bTJ;
        public String bTK;
        public String bTL;
        public String bTM;
        public String detailUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aer() {
        return this.bTC > 0;
    }

    public boolean aes() {
        return this.bTC != 0;
    }

    public boolean aet() {
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
        eVar.bTy = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.bTz = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.bTC = jSONObject.optInt("tip_status", -1);
        eVar.bTD = jSONObject.optString("explain", "");
        eVar.bTE = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.bTB.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.bTA.add(optJSONArray2.optString(i2));
            }
        }
        eVar.bTG = jSONObject.optJSONObject("other");
        eVar.bTH = jSONObject.optString("plugin_app_name");
        eVar.bTI = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aeu() {
        if (this.bTG != null && this.bTG.keys() != null && this.bTG.keys().hasNext()) {
            this.bTF = new a();
            this.bTF.bTJ = this.bTG.optString("detail_text");
            this.bTF.detailUrl = this.bTG.optString("detail_url");
            this.bTF.bTK = this.bTG.optString("text_color");
            this.bTF.bTL = this.bTG.optString("keyword");
            this.bTF.bTM = this.bTG.optString("key_color");
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.bTC));
    }
}
