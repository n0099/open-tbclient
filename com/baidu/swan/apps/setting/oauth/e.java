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
    public boolean bTl;
    public a bTs;
    public JSONObject bTt;
    public String bTu;
    public String bTv;
    public boolean forbidden;
    public final String id;
    public String grade = "";
    public String name = "";
    public String bTm = "";
    public String description = "";
    public List<String> bTn = new ArrayList();
    public final List<String> bTo = new ArrayList();
    public int bTp = -1;
    private String type = "";
    public String bTq = "";
    public String bTr = "";

    /* loaded from: classes11.dex */
    public static class a {
        public String bTw;
        public String bTx;
        public String bTy;
        public String bTz;
        public String detailUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str) {
        this.id = str;
    }

    public boolean aem() {
        return this.bTp > 0;
    }

    public boolean aen() {
        return this.bTp != 0;
    }

    public boolean aeo() {
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
        eVar.bTl = jSONObject.optBoolean("permit", false);
        eVar.forbidden = jSONObject.optBoolean("forbidden", true);
        eVar.grade = jSONObject.optString("grade");
        eVar.type = jSONObject.optString("type", "");
        eVar.name = jSONObject.optString("name", "");
        eVar.bTm = jSONObject.optString("short_name", "");
        eVar.description = jSONObject.optString("description", "");
        eVar.bTp = jSONObject.optInt("tip_status", -1);
        eVar.bTq = jSONObject.optString("explain", "");
        eVar.bTr = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.bTo.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.bTn.add(optJSONArray2.optString(i2));
            }
        }
        eVar.bTt = jSONObject.optJSONObject("other");
        eVar.bTu = jSONObject.optString("plugin_app_name");
        eVar.bTv = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public void aep() {
        if (this.bTt != null && this.bTt.keys() != null && this.bTt.keys().hasNext()) {
            this.bTs = new a();
            this.bTs.bTw = this.bTt.optString("detail_text");
            this.bTs.detailUrl = this.bTt.optString("detail_url");
            this.bTs.bTx = this.bTt.optString("text_color");
            this.bTs.bTy = this.bTt.optString("keyword");
            this.bTs.bTz = this.bTt.optString("key_color");
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.id, Integer.valueOf(this.bTp));
    }
}
