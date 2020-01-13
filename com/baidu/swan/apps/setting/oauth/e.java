package com.baidu.swan.apps.setting.oauth;

import android.text.TextUtils;
import com.coloros.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    public boolean bPg;
    public a bPn;
    public JSONObject bPo;
    public String bPp;
    public String bPq;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String bPh = "";
    public String description = "";
    public List<String> bPi = new ArrayList();
    public final List<String> bPj = new ArrayList();
    public int bPk = -1;
    private String type = "";
    public String bPl = "";
    public String bPm = "";

    /* loaded from: classes10.dex */
    public static class a {
        public String bPr;
        public String bPs;
        public String bPt;
        public String bPu;
        public String detailUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean abY() {
        return this.bPk > 0;
    }

    public boolean abZ() {
        return this.bPk != 0;
    }

    public boolean aca() {
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
        eVar.bPg = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.bPh = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.bPk = jSONObject.optInt("tip_status", -1);
        eVar.bPl = jSONObject.optString("explain", "");
        eVar.bPm = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.bPj.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.bPi.add(optJSONArray2.optString(i2));
            }
        }
        eVar.bPo = jSONObject.optJSONObject("other");
        eVar.bPp = jSONObject.optString("plugin_app_name");
        eVar.bPq = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void acb() {
        if (this.bPo != null && this.bPo.keys() != null && this.bPo.keys().hasNext()) {
            this.bPn = new a();
            this.bPn.bPr = this.bPo.optString("detail_text");
            this.bPn.detailUrl = this.bPo.optString("detail_url");
            this.bPn.bPs = this.bPo.optString("text_color");
            this.bPn.bPt = this.bPo.optString("keyword");
            this.bPn.bPu = this.bPo.optString("key_color");
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.bPk));
    }
}
