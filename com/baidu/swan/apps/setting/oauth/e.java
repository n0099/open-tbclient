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
    public JSONObject dxN;
    public boolean dxO;
    public a dxV;
    public JSONObject dxW;
    public String dxX;
    public String dxY;
    public String dxZ;
    public List<e> dya;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String dxP = "";
    public String description = "";
    public List<String> dxQ = new ArrayList();
    public final List<String> dxR = new ArrayList();
    public int dxS = -1;
    private String type = "";
    public String dxT = "";
    public String dxU = "";

    /* loaded from: classes10.dex */
    public static class a {
        public String detailUrl;
        public String dyb;
        public String dyc;
        public String dyd;
        public String dye;
        public JSONArray dyf;
    }

    public void aR(List<e> list) {
        this.dya = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aJr() {
        return this.dxS > 0;
    }

    public boolean aJs() {
        return this.dxS != 0;
    }

    public boolean aJt() {
        return "1".equals(this.type);
    }

    public static e bX(JSONObject jSONObject) {
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
        eVar.dxN = jSONObject;
        eVar.dxO = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.dxP = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.dxS = jSONObject.optInt("tip_status", -1);
        eVar.dxT = jSONObject.optString("explain", "");
        eVar.dxU = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.dxR.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.dxQ.add(optJSONArray2.optString(i2));
            }
        }
        eVar.dxW = jSONObject.optJSONObject("other");
        eVar.dxX = jSONObject.optString("plugin_app_name");
        eVar.dxY = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aJu() {
        if (this.dxW != null && this.dxW.keys() != null && this.dxW.keys().hasNext()) {
            this.dxV = new a();
            this.dxV.dyb = this.dxW.optString("detail_text");
            this.dxV.detailUrl = this.dxW.optString("detail_url");
            this.dxV.dyc = this.dxW.optString("text_color");
            this.dxV.dyd = this.dxW.optString("keyword");
            this.dxV.dye = this.dxW.optString("key_color");
            JSONObject optJSONObject = this.dxW.optJSONObject("developer_agreements");
            if (optJSONObject != null) {
                this.dxV.dyf = optJSONObject.optJSONArray("details");
            }
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.dxS));
    }
}
