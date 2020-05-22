package com.baidu.swan.apps.setting.oauth;

import android.text.TextUtils;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public String cEA;
    public JSONObject cEp;
    public boolean cEq;
    public a cEx;
    public JSONObject cEy;
    public String cEz;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String cEr = "";
    public String description = "";
    public List<String> cEs = new ArrayList();
    public final List<String> cEt = new ArrayList();
    public int cEu = -1;
    private String type = "";
    public String cEv = "";
    public String cEw = "";

    /* loaded from: classes11.dex */
    public static class a {
        public String cEB;
        public String cEC;
        public String cED;
        public String cEE;
        public String detailUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aqy() {
        return this.cEu > 0;
    }

    public boolean aqz() {
        return this.cEu != 0;
    }

    public boolean aqA() {
        return "1".equals(this.type);
    }

    public static e bk(JSONObject jSONObject) {
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
        eVar.cEp = jSONObject;
        eVar.cEq = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.cEr = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.cEu = jSONObject.optInt("tip_status", -1);
        eVar.cEv = jSONObject.optString("explain", "");
        eVar.cEw = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.cEt.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.cEs.add(optJSONArray2.optString(i2));
            }
        }
        eVar.cEy = jSONObject.optJSONObject("other");
        eVar.cEz = jSONObject.optString("plugin_app_name");
        eVar.cEA = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aqB() {
        if (this.cEy != null && this.cEy.keys() != null && this.cEy.keys().hasNext()) {
            this.cEx = new a();
            this.cEx.cEB = this.cEy.optString("detail_text");
            this.cEx.detailUrl = this.cEy.optString("detail_url");
            this.cEx.cEC = this.cEy.optString("text_color");
            this.cEx.cED = this.cEy.optString("keyword");
            this.cEx.cEE = this.cEy.optString("key_color");
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.cEu));
    }
}
