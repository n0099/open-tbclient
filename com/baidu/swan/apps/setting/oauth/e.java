package com.baidu.swan.apps.setting.oauth;

import android.text.TextUtils;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    public a djB;
    public JSONObject djC;
    public String djD;
    public String djE;
    public String djF;
    public List<e> djG;
    public JSONObject djt;
    public boolean dju;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String djv = "";
    public String description = "";
    public List<String> djw = new ArrayList();
    public final List<String> djx = new ArrayList();
    public int djy = -1;
    private String type = "";
    public String djz = "";
    public String djA = "";

    /* loaded from: classes10.dex */
    public static class a {
        public String detailUrl;
        public String djH;
        public String djI;
        public String djJ;
        public String djK;
        public JSONArray djL;
    }

    public void aA(List<e> list) {
        this.djG = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aEX() {
        return this.djy > 0;
    }

    public boolean aEY() {
        return this.djy != 0;
    }

    public boolean aEZ() {
        return "1".equals(this.type);
    }

    public static e bO(JSONObject jSONObject) {
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
        eVar.djt = jSONObject;
        eVar.dju = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.djv = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.djy = jSONObject.optInt("tip_status", -1);
        eVar.djz = jSONObject.optString("explain", "");
        eVar.djA = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.djx.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.djw.add(optJSONArray2.optString(i2));
            }
        }
        eVar.djC = jSONObject.optJSONObject("other");
        eVar.djD = jSONObject.optString("plugin_app_name");
        eVar.djE = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aFa() {
        if (this.djC != null && this.djC.keys() != null && this.djC.keys().hasNext()) {
            this.djB = new a();
            this.djB.djH = this.djC.optString("detail_text");
            this.djB.detailUrl = this.djC.optString("detail_url");
            this.djB.djI = this.djC.optString("text_color");
            this.djB.djJ = this.djC.optString("keyword");
            this.djB.djK = this.djC.optString("key_color");
            JSONObject optJSONObject = this.djC.optJSONObject("developer_agreements");
            if (optJSONObject != null) {
                this.djB.djL = optJSONObject.optJSONArray("details");
            }
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.djy));
    }
}
