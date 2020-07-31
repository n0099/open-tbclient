package com.baidu.swan.apps.setting.oauth;

import android.text.TextUtils;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public JSONObject cMj;
    public boolean cMk;
    public a cMr;
    public JSONObject cMs;
    public String cMt;
    public String cMu;
    public String cMv;
    public List<e> cMw;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String cMl = "";
    public String description = "";
    public List<String> cMm = new ArrayList();
    public final List<String> cMn = new ArrayList();
    public int cMo = -1;
    private String type = "";
    public String cMp = "";
    public String cMq = "";

    /* loaded from: classes7.dex */
    public static class a {
        public String cMA;
        public JSONArray cMB;
        public String cMx;
        public String cMy;
        public String cMz;
        public String detailUrl;
    }

    public void as(List<e> list) {
        this.cMw = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean atw() {
        return this.cMo > 0;
    }

    public boolean atx() {
        return this.cMo != 0;
    }

    public boolean aty() {
        return "1".equals(this.type);
    }

    public static e bw(JSONObject jSONObject) {
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
        eVar.cMj = jSONObject;
        eVar.cMk = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.cMl = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.cMo = jSONObject.optInt("tip_status", -1);
        eVar.cMp = jSONObject.optString("explain", "");
        eVar.cMq = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.cMn.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.cMm.add(optJSONArray2.optString(i2));
            }
        }
        eVar.cMs = jSONObject.optJSONObject("other");
        eVar.cMt = jSONObject.optString("plugin_app_name");
        eVar.cMu = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void atz() {
        if (this.cMs != null && this.cMs.keys() != null && this.cMs.keys().hasNext()) {
            this.cMr = new a();
            this.cMr.cMx = this.cMs.optString("detail_text");
            this.cMr.detailUrl = this.cMs.optString("detail_url");
            this.cMr.cMy = this.cMs.optString("text_color");
            this.cMr.cMz = this.cMs.optString("keyword");
            this.cMr.cMA = this.cMs.optString("key_color");
            JSONObject optJSONObject = this.cMs.optJSONObject("developer_agreements");
            if (optJSONObject != null) {
                this.cMr.cMB = optJSONObject.optJSONArray("details");
            }
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.cMo));
    }
}
