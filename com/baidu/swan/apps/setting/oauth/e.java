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
    public JSONObject dJb;
    public boolean dJc;
    public a dJj;
    public JSONObject dJk;
    public String dJl;
    public String dJm;
    public String dJn;
    public List<e> dJo;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String dJd = "";
    public String description = "";
    public List<String> dJe = new ArrayList();
    public final List<String> dJf = new ArrayList();
    public int dJg = -1;
    private String type = "";
    public String dJh = "";
    public String dJi = "";

    /* loaded from: classes9.dex */
    public static class a {
        public String dJp;
        public String dJq;
        public String dJr;
        public String dJs;
        public JSONArray dJt;
        public String detailUrl;
    }

    public void aW(List<e> list) {
        this.dJo = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aKH() {
        return this.dJg > 0;
    }

    public boolean aKI() {
        return this.dJg != 0;
    }

    public boolean aKJ() {
        return "1".equals(this.type);
    }

    public static e bY(JSONObject jSONObject) {
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
        eVar.dJb = jSONObject;
        eVar.dJc = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.dJd = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.dJg = jSONObject.optInt("tip_status", -1);
        eVar.dJh = jSONObject.optString("explain", "");
        eVar.dJi = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.dJf.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.dJe.add(optJSONArray2.optString(i2));
            }
        }
        eVar.dJk = jSONObject.optJSONObject("other");
        eVar.dJl = jSONObject.optString("plugin_app_name");
        eVar.dJm = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aKK() {
        if (this.dJk != null && this.dJk.keys() != null && this.dJk.keys().hasNext()) {
            this.dJj = new a();
            this.dJj.dJp = this.dJk.optString("detail_text");
            this.dJj.detailUrl = this.dJk.optString("detail_url");
            this.dJj.dJq = this.dJk.optString("text_color");
            this.dJj.dJr = this.dJk.optString("keyword");
            this.dJj.dJs = this.dJk.optString("key_color");
            JSONObject optJSONObject = this.dJk.optJSONObject("developer_agreements");
            if (optJSONObject != null) {
                this.dJj.dJt = optJSONObject.optJSONArray("details");
            }
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.dJg));
    }
}
