package com.baidu.swan.apps.setting.oauth;

import android.text.TextUtils;
import com.coloros.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public boolean bTn;
    public a bTu;
    public JSONObject bTv;
    public String bTw;
    public String bTx;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String bTo = "";
    public String description = "";
    public List<String> bTp = new ArrayList();
    public final List<String> bTq = new ArrayList();
    public int bTr = -1;
    private String type = "";
    public String bTs = "";
    public String bTt = "";

    /* loaded from: classes11.dex */
    public static class a {
        public String bTA;
        public String bTB;
        public String bTy;
        public String bTz;
        public String detailUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aeo() {
        return this.bTr > 0;
    }

    public boolean aep() {
        return this.bTr != 0;
    }

    public boolean aeq() {
        return "1".equals(this.type);
    }

    public static e aQ(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("id", "");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return h(optString, jSONObject);
    }

    public static e h(String str, JSONObject jSONObject) {
        e eVar = new e(str);
        eVar.bTn = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.bTo = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.bTr = jSONObject.optInt("tip_status", -1);
        eVar.bTs = jSONObject.optString("explain", "");
        eVar.bTt = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.bTq.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.bTp.add(optJSONArray2.optString(i2));
            }
        }
        eVar.bTv = jSONObject.optJSONObject("other");
        eVar.bTw = jSONObject.optString("plugin_app_name");
        eVar.bTx = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aer() {
        if (this.bTv != null && this.bTv.keys() != null && this.bTv.keys().hasNext()) {
            this.bTu = new a();
            this.bTu.bTy = this.bTv.optString("detail_text");
            this.bTu.detailUrl = this.bTv.optString("detail_url");
            this.bTu.bTz = this.bTv.optString("text_color");
            this.bTu.bTA = this.bTv.optString("keyword");
            this.bTu.bTB = this.bTv.optString("key_color");
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.bTr));
    }
}
