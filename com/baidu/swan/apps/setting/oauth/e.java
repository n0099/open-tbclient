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
    public JSONObject cVf;
    public boolean cVg;
    public a cVn;
    public JSONObject cVo;
    public String cVp;
    public String cVq;
    public String cVr;
    public List<e> cVs;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String cVh = "";
    public String description = "";
    public List<String> cVi = new ArrayList();
    public final List<String> cVj = new ArrayList();
    public int cVk = -1;
    private String type = "";
    public String cVl = "";
    public String cVm = "";

    /* loaded from: classes8.dex */
    public static class a {
        public String cVt;
        public String cVu;
        public String cVv;
        public String cVw;
        public JSONArray cVx;
        public String detailUrl;
    }

    public void at(List<e> list) {
        this.cVs = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aBE() {
        return this.cVk > 0;
    }

    public boolean aBF() {
        return this.cVk != 0;
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
        eVar.cVf = jSONObject;
        eVar.cVg = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.cVh = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.cVk = jSONObject.optInt("tip_status", -1);
        eVar.cVl = jSONObject.optString("explain", "");
        eVar.cVm = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.cVj.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.cVi.add(optJSONArray2.optString(i2));
            }
        }
        eVar.cVo = jSONObject.optJSONObject("other");
        eVar.cVp = jSONObject.optString("plugin_app_name");
        eVar.cVq = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aBH() {
        if (this.cVo != null && this.cVo.keys() != null && this.cVo.keys().hasNext()) {
            this.cVn = new a();
            this.cVn.cVt = this.cVo.optString("detail_text");
            this.cVn.detailUrl = this.cVo.optString("detail_url");
            this.cVn.cVu = this.cVo.optString("text_color");
            this.cVn.cVv = this.cVo.optString("keyword");
            this.cVn.cVw = this.cVo.optString("key_color");
            JSONObject optJSONObject = this.cVo.optJSONObject("developer_agreements");
            if (optJSONObject != null) {
                this.cVn.cVx = optJSONObject.optJSONArray("details");
            }
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.cVk));
    }
}
