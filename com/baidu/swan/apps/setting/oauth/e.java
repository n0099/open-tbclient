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
    public JSONObject dKC;
    public boolean dKD;
    public a dKK;
    public JSONObject dKL;
    public String dKM;
    public String dKN;
    public String dKO;
    public List<e> dKP;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String dKE = "";
    public String description = "";
    public List<String> dKF = new ArrayList();
    public final List<String> dKG = new ArrayList();
    public int dKH = -1;
    private String type = "";
    public String dKI = "";
    public String dKJ = "";

    /* loaded from: classes8.dex */
    public static class a {
        public String dKQ;
        public String dKR;
        public String dKS;
        public String dKT;
        public JSONArray dKU;
        public String detailUrl;
    }

    public void aW(List<e> list) {
        this.dKP = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aKK() {
        return this.dKH > 0;
    }

    public boolean aKL() {
        return this.dKH != 0;
    }

    public boolean aKM() {
        return "1".equals(this.type);
    }

    public static e ca(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("id", "");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return m(optString, jSONObject);
    }

    public static e m(String str, JSONObject jSONObject) {
        e eVar = new e(str);
        eVar.dKC = jSONObject;
        eVar.dKD = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.dKE = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.dKH = jSONObject.optInt("tip_status", -1);
        eVar.dKI = jSONObject.optString("explain", "");
        eVar.dKJ = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.dKG.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.dKF.add(optJSONArray2.optString(i2));
            }
        }
        eVar.dKL = jSONObject.optJSONObject("other");
        eVar.dKM = jSONObject.optString("plugin_app_name");
        eVar.dKN = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aKN() {
        if (this.dKL != null && this.dKL.keys() != null && this.dKL.keys().hasNext()) {
            this.dKK = new a();
            this.dKK.dKQ = this.dKL.optString("detail_text");
            this.dKK.detailUrl = this.dKL.optString("detail_url");
            this.dKK.dKR = this.dKL.optString("text_color");
            this.dKK.dKS = this.dKL.optString("keyword");
            this.dKK.dKT = this.dKL.optString("key_color");
            JSONObject optJSONObject = this.dKL.optJSONObject("developer_agreements");
            if (optJSONObject != null) {
                this.dKK.dKU = optJSONObject.optJSONArray("details");
            }
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.dKH));
    }
}
