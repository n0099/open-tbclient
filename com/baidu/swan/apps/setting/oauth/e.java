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
    public JSONObject drT;
    public boolean drU;
    public a dsb;
    public JSONObject dsc;
    public String dsd;
    public String dse;
    public String dsf;
    public List<e> dsg;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String drV = "";
    public String description = "";
    public List<String> drW = new ArrayList();
    public final List<String> drX = new ArrayList();
    public int drY = -1;
    private String type = "";
    public String drZ = "";
    public String dsa = "";

    /* loaded from: classes10.dex */
    public static class a {
        public String detailUrl;
        public String dsh;
        public String dsi;
        public String dsj;
        public String dsk;
        public JSONArray dsl;
    }

    public void aK(List<e> list) {
        this.dsg = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aGR() {
        return this.drY > 0;
    }

    public boolean aGS() {
        return this.drY != 0;
    }

    public boolean aGT() {
        return "1".equals(this.type);
    }

    public static e bR(JSONObject jSONObject) {
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
        eVar.drT = jSONObject;
        eVar.drU = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.drV = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.drY = jSONObject.optInt("tip_status", -1);
        eVar.drZ = jSONObject.optString("explain", "");
        eVar.dsa = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.drX.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.drW.add(optJSONArray2.optString(i2));
            }
        }
        eVar.dsc = jSONObject.optJSONObject("other");
        eVar.dsd = jSONObject.optString("plugin_app_name");
        eVar.dse = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aGU() {
        if (this.dsc != null && this.dsc.keys() != null && this.dsc.keys().hasNext()) {
            this.dsb = new a();
            this.dsb.dsh = this.dsc.optString("detail_text");
            this.dsb.detailUrl = this.dsc.optString("detail_url");
            this.dsb.dsi = this.dsc.optString("text_color");
            this.dsb.dsj = this.dsc.optString("keyword");
            this.dsb.dsk = this.dsc.optString("key_color");
            JSONObject optJSONObject = this.dsc.optJSONObject("developer_agreements");
            if (optJSONObject != null) {
                this.dsb.dsl = optJSONObject.optJSONArray("details");
            }
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.drY));
    }
}
