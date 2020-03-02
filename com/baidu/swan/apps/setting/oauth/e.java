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
    public boolean bTm;
    public a bTt;
    public JSONObject bTu;
    public String bTv;
    public String bTw;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String bTn = "";
    public String description = "";
    public List<String> bTo = new ArrayList();
    public final List<String> bTp = new ArrayList();
    public int bTq = -1;
    private String type = "";
    public String bTr = "";
    public String bTs = "";

    /* loaded from: classes11.dex */
    public static class a {
        public String bTA;
        public String bTx;
        public String bTy;
        public String bTz;
        public String detailUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aeo() {
        return this.bTq > 0;
    }

    public boolean aep() {
        return this.bTq != 0;
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
        eVar.bTm = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.bTn = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.bTq = jSONObject.optInt("tip_status", -1);
        eVar.bTr = jSONObject.optString("explain", "");
        eVar.bTs = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.bTp.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.bTo.add(optJSONArray2.optString(i2));
            }
        }
        eVar.bTu = jSONObject.optJSONObject("other");
        eVar.bTv = jSONObject.optString("plugin_app_name");
        eVar.bTw = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aer() {
        if (this.bTu != null && this.bTu.keys() != null && this.bTu.keys().hasNext()) {
            this.bTt = new a();
            this.bTt.bTx = this.bTu.optString("detail_text");
            this.bTt.detailUrl = this.bTu.optString("detail_url");
            this.bTt.bTy = this.bTu.optString("text_color");
            this.bTt.bTz = this.bTu.optString("keyword");
            this.bTt.bTA = this.bTu.optString("key_color");
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.bTq));
    }
}
