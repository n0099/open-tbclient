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
    public JSONObject dwg;
    public boolean dwh;
    public a dwo;
    public JSONObject dwp;
    public String dwq;
    public String dwr;
    public String dws;
    public List<e> dwt;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String dwi = "";
    public String description = "";
    public List<String> dwj = new ArrayList();
    public final List<String> dwk = new ArrayList();
    public int dwl = -1;
    private String type = "";
    public String dwm = "";
    public String dwn = "";

    /* loaded from: classes7.dex */
    public static class a {
        public String detailUrl;
        public String dwu;
        public String dwv;
        public String dww;
        public String dwx;
        public JSONArray dwy;
    }

    public void aR(List<e> list) {
        this.dwt = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aIJ() {
        return this.dwl > 0;
    }

    public boolean aIK() {
        return this.dwl != 0;
    }

    public boolean aIL() {
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
        return k(optString, jSONObject);
    }

    public static e k(String str, JSONObject jSONObject) {
        e eVar = new e(str);
        eVar.dwg = jSONObject;
        eVar.dwh = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.dwi = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.dwl = jSONObject.optInt("tip_status", -1);
        eVar.dwm = jSONObject.optString("explain", "");
        eVar.dwn = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.dwk.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.dwj.add(optJSONArray2.optString(i2));
            }
        }
        eVar.dwp = jSONObject.optJSONObject("other");
        eVar.dwq = jSONObject.optString("plugin_app_name");
        eVar.dwr = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aIM() {
        if (this.dwp != null && this.dwp.keys() != null && this.dwp.keys().hasNext()) {
            this.dwo = new a();
            this.dwo.dwu = this.dwp.optString("detail_text");
            this.dwo.detailUrl = this.dwp.optString("detail_url");
            this.dwo.dwv = this.dwp.optString("text_color");
            this.dwo.dww = this.dwp.optString("keyword");
            this.dwo.dwx = this.dwp.optString("key_color");
            JSONObject optJSONObject = this.dwp.optJSONObject("developer_agreements");
            if (optJSONObject != null) {
                this.dwo.dwy = optJSONObject.optJSONArray("details");
            }
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.dwl));
    }
}
