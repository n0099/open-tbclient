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
    public JSONObject cVj;
    public boolean cVk;
    public a cVr;
    public JSONObject cVs;
    public String cVt;
    public String cVu;
    public String cVv;
    public List<e> cVw;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String cVl = "";
    public String description = "";
    public List<String> cVm = new ArrayList();
    public final List<String> cVn = new ArrayList();
    public int cVo = -1;
    private String type = "";
    public String cVp = "";
    public String cVq = "";

    /* loaded from: classes8.dex */
    public static class a {
        public String cVA;
        public JSONArray cVB;
        public String cVx;
        public String cVy;
        public String cVz;
        public String detailUrl;
    }

    public void at(List<e> list) {
        this.cVw = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aBE() {
        return this.cVo > 0;
    }

    public boolean aBF() {
        return this.cVo != 0;
    }

    public boolean aBG() {
        return "1".equals(this.type);
    }

    public static e bE(JSONObject jSONObject) {
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
        eVar.cVj = jSONObject;
        eVar.cVk = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.cVl = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.cVo = jSONObject.optInt("tip_status", -1);
        eVar.cVp = jSONObject.optString("explain", "");
        eVar.cVq = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.cVn.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.cVm.add(optJSONArray2.optString(i2));
            }
        }
        eVar.cVs = jSONObject.optJSONObject("other");
        eVar.cVt = jSONObject.optString("plugin_app_name");
        eVar.cVu = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aBH() {
        if (this.cVs != null && this.cVs.keys() != null && this.cVs.keys().hasNext()) {
            this.cVr = new a();
            this.cVr.cVx = this.cVs.optString("detail_text");
            this.cVr.detailUrl = this.cVs.optString("detail_url");
            this.cVr.cVy = this.cVs.optString("text_color");
            this.cVr.cVz = this.cVs.optString("keyword");
            this.cVr.cVA = this.cVs.optString("key_color");
            JSONObject optJSONObject = this.cVs.optJSONObject("developer_agreements");
            if (optJSONObject != null) {
                this.cVr.cVB = optJSONObject.optJSONArray("details");
            }
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.cVo));
    }
}
