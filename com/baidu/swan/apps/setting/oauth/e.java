package com.baidu.swan.apps.setting.oauth;

import android.text.TextUtils;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public JSONObject dGX;
    public boolean dGY;
    public a dHf;
    public JSONObject dHg;
    public String dHh;
    public String dHi;
    public String dHj;
    public List<e> dHk;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String dGZ = "";
    public String description = "";
    public List<String> dHa = new ArrayList();
    public final List<String> dHb = new ArrayList();
    public int dHc = -1;
    private String type = "";
    public String dHd = "";
    public String dHe = "";

    /* loaded from: classes8.dex */
    public static class a {
        public String dHl;
        public String dHm;
        public String dHn;
        public String dHo;
        public JSONArray dHp;
        public String detailUrl;
    }

    public void bb(List<e> list) {
        this.dHk = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aKo() {
        return this.dHc > 0;
    }

    public boolean aKp() {
        return this.dHc != 0;
    }

    public boolean aKq() {
        return "1".equals(this.type);
    }

    public static e cb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("id", "");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return l(optString, jSONObject);
    }

    public static e l(String str, JSONObject jSONObject) {
        e eVar = new e(str);
        eVar.dGX = jSONObject;
        eVar.dGY = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.dGZ = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.dHc = jSONObject.optInt("tip_status", -1);
        eVar.dHd = jSONObject.optString("explain", "");
        eVar.dHe = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.dHb.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.dHa.add(optJSONArray2.optString(i2));
            }
        }
        eVar.dHg = jSONObject.optJSONObject("other");
        eVar.dHh = jSONObject.optString("plugin_app_name");
        eVar.dHi = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aKr() {
        if (this.dHg != null && this.dHg.keys() != null && this.dHg.keys().hasNext()) {
            this.dHf = new a();
            this.dHf.dHl = this.dHg.optString("detail_text");
            this.dHf.detailUrl = this.dHg.optString("detail_url");
            this.dHf.dHm = this.dHg.optString("text_color");
            this.dHf.dHn = this.dHg.optString("keyword");
            this.dHf.dHo = this.dHg.optString("key_color");
            JSONObject optJSONObject = this.dHg.optJSONObject("developer_agreements");
            if (optJSONObject != null) {
                this.dHf.dHp = optJSONObject.optJSONArray("details");
            }
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.dHc));
    }
}
