package com.baidu.swan.apps.setting.oauth;

import android.text.TextUtils;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class e {
    public JSONObject dDf;
    public boolean dDg;
    public a dDn;
    public JSONObject dDo;
    public String dDp;
    public String dDq;
    public String dDr;
    public List<e> dDs;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String dDh = "";
    public String description = "";
    public List<String> dDi = new ArrayList();
    public final List<String> dDj = new ArrayList();
    public int dDk = -1;
    private String type = "";
    public String dDl = "";
    public String dDm = "";

    /* loaded from: classes25.dex */
    public static class a {
        public String dDt;
        public String dDu;
        public String dDv;
        public String dDw;
        public JSONArray dDx;
        public String detailUrl;
    }

    public void aU(List<e> list) {
        this.dDs = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aLR() {
        return this.dDk > 0;
    }

    public boolean aLS() {
        return this.dDk != 0;
    }

    public boolean aLT() {
        return "1".equals(this.type);
    }

    public static e bT(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("id", "");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return k(optString, jSONObject);
    }

    public static e k(String str, JSONObject jSONObject) {
        e eVar = new e(str);
        eVar.dDf = jSONObject;
        eVar.dDg = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.dDh = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.dDk = jSONObject.optInt("tip_status", -1);
        eVar.dDl = jSONObject.optString("explain", "");
        eVar.dDm = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.dDj.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.dDi.add(optJSONArray2.optString(i2));
            }
        }
        eVar.dDo = jSONObject.optJSONObject("other");
        eVar.dDp = jSONObject.optString("plugin_app_name");
        eVar.dDq = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aLU() {
        if (this.dDo != null && this.dDo.keys() != null && this.dDo.keys().hasNext()) {
            this.dDn = new a();
            this.dDn.dDt = this.dDo.optString("detail_text");
            this.dDn.detailUrl = this.dDo.optString("detail_url");
            this.dDn.dDu = this.dDo.optString("text_color");
            this.dDn.dDv = this.dDo.optString("keyword");
            this.dDn.dDw = this.dDo.optString("key_color");
            JSONObject optJSONObject = this.dDo.optJSONObject("developer_agreements");
            if (optJSONObject != null) {
                this.dDn.dDx = optJSONObject.optJSONArray("details");
            }
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.dDk));
    }
}
