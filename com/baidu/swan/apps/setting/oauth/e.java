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
    public JSONObject cIZ;
    public boolean cJa;
    public a cJh;
    public JSONObject cJi;
    public String cJj;
    public String cJk;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String cJb = "";
    public String description = "";
    public List<String> cJc = new ArrayList();
    public final List<String> cJd = new ArrayList();
    public int cJe = -1;
    private String type = "";
    public String cJf = "";
    public String cJg = "";

    /* loaded from: classes11.dex */
    public static class a {
        public String cJl;
        public String cJm;
        public String cJn;
        public String cJo;
        public String detailUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean arE() {
        return this.cJe > 0;
    }

    public boolean arF() {
        return this.cJe != 0;
    }

    public boolean arG() {
        return "1".equals(this.type);
    }

    public static e br(JSONObject jSONObject) {
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
        eVar.cIZ = jSONObject;
        eVar.cJa = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.cJb = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.cJe = jSONObject.optInt("tip_status", -1);
        eVar.cJf = jSONObject.optString("explain", "");
        eVar.cJg = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.cJd.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.cJc.add(optJSONArray2.optString(i2));
            }
        }
        eVar.cJi = jSONObject.optJSONObject("other");
        eVar.cJj = jSONObject.optString("plugin_app_name");
        eVar.cJk = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void arH() {
        if (this.cJi != null && this.cJi.keys() != null && this.cJi.keys().hasNext()) {
            this.cJh = new a();
            this.cJh.cJl = this.cJi.optString("detail_text");
            this.cJh.detailUrl = this.cJi.optString("detail_url");
            this.cJh.cJm = this.cJi.optString("text_color");
            this.cJh.cJn = this.cJi.optString("keyword");
            this.cJh.cJo = this.cJi.optString("key_color");
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.cJe));
    }
}
