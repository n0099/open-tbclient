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
    public a csA;
    public JSONObject csB;
    public String csC;
    public String csD;
    public boolean cst;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String csu = "";
    public String description = "";
    public List<String> csv = new ArrayList();
    public final List<String> csw = new ArrayList();
    public int csx = -1;
    private String type = "";
    public String csy = "";
    public String csz = "";

    /* loaded from: classes11.dex */
    public static class a {
        public String csE;
        public String csF;
        public String csG;
        public String csH;
        public String detailUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean amv() {
        return this.csx > 0;
    }

    public boolean amw() {
        return this.csx != 0;
    }

    public boolean amx() {
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
        eVar.cst = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.csu = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.csx = jSONObject.optInt("tip_status", -1);
        eVar.csy = jSONObject.optString("explain", "");
        eVar.csz = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.csw.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.csv.add(optJSONArray2.optString(i2));
            }
        }
        eVar.csB = jSONObject.optJSONObject("other");
        eVar.csC = jSONObject.optString("plugin_app_name");
        eVar.csD = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void amy() {
        if (this.csB != null && this.csB.keys() != null && this.csB.keys().hasNext()) {
            this.csA = new a();
            this.csA.csE = this.csB.optString("detail_text");
            this.csA.detailUrl = this.csB.optString("detail_url");
            this.csA.csF = this.csB.optString("text_color");
            this.csA.csG = this.csB.optString("keyword");
            this.csA.csH = this.csB.optString("key_color");
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.csx));
    }
}
