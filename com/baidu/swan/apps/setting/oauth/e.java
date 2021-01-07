package com.baidu.swan.apps.setting.oauth;

import android.text.TextUtils;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    public JSONObject dLJ;
    public boolean dLK;
    public a dLR;
    public JSONObject dLS;
    public String dLT;
    public String dLU;
    public String dLV;
    public List<e> dLW;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String dLL = "";
    public String description = "";
    public List<String> dLM = new ArrayList();
    public final List<String> dLN = new ArrayList();
    public int dLO = -1;
    private String type = "";
    public String dLP = "";
    public String dLQ = "";

    /* loaded from: classes9.dex */
    public static class a {
        public String dLX;
        public String dLY;
        public String dLZ;
        public String dMa;
        public JSONArray dMb;
        public String detailUrl;
    }

    public void bb(List<e> list) {
        this.dLW = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aOi() {
        return this.dLO > 0;
    }

    public boolean aOj() {
        return this.dLO != 0;
    }

    public boolean aOk() {
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
        eVar.dLJ = jSONObject;
        eVar.dLK = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.dLL = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.dLO = jSONObject.optInt("tip_status", -1);
        eVar.dLP = jSONObject.optString("explain", "");
        eVar.dLQ = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.dLN.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.dLM.add(optJSONArray2.optString(i2));
            }
        }
        eVar.dLS = jSONObject.optJSONObject("other");
        eVar.dLT = jSONObject.optString("plugin_app_name");
        eVar.dLU = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aOl() {
        if (this.dLS != null && this.dLS.keys() != null && this.dLS.keys().hasNext()) {
            this.dLR = new a();
            this.dLR.dLX = this.dLS.optString("detail_text");
            this.dLR.detailUrl = this.dLS.optString("detail_url");
            this.dLR.dLY = this.dLS.optString("text_color");
            this.dLR.dLZ = this.dLS.optString("keyword");
            this.dLR.dMa = this.dLS.optString("key_color");
            JSONObject optJSONObject = this.dLS.optJSONObject("developer_agreements");
            if (optJSONObject != null) {
                this.dLR.dMb = optJSONObject.optJSONArray("details");
            }
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.dLO));
    }
}
