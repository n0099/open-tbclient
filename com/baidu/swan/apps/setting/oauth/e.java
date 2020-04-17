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
    public boolean csn;
    public a csu;
    public JSONObject csv;
    public String csw;
    public String csx;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String cso = "";
    public String description = "";
    public List<String> csp = new ArrayList();
    public final List<String> csq = new ArrayList();
    public int csr = -1;
    private String type = "";
    public String css = "";
    public String cst = "";

    /* loaded from: classes11.dex */
    public static class a {
        public String csA;
        public String csB;
        public String csy;
        public String csz;
        public String detailUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean amw() {
        return this.csr > 0;
    }

    public boolean amx() {
        return this.csr != 0;
    }

    public boolean amy() {
        return "1".equals(this.type);
    }

    public static e bb(JSONObject jSONObject) {
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
        eVar.csn = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.cso = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.csr = jSONObject.optInt("tip_status", -1);
        eVar.css = jSONObject.optString("explain", "");
        eVar.cst = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.csq.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.csp.add(optJSONArray2.optString(i2));
            }
        }
        eVar.csv = jSONObject.optJSONObject("other");
        eVar.csw = jSONObject.optString("plugin_app_name");
        eVar.csx = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void amz() {
        if (this.csv != null && this.csv.keys() != null && this.csv.keys().hasNext()) {
            this.csu = new a();
            this.csu.csy = this.csv.optString("detail_text");
            this.csu.detailUrl = this.csv.optString("detail_url");
            this.csu.csz = this.csv.optString("text_color");
            this.csu.csA = this.csv.optString("keyword");
            this.csu.csB = this.csv.optString("key_color");
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.csr));
    }
}
