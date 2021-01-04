package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String aVa;
    public String aVb;
    public int aVc;
    public String aVd;
    public JSONObject extInfoJson;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.aVa = jSONObject.optString("head_img");
            this.aVb = jSONObject.optString("nick_name");
            this.aVc = jSONObject.optInt("noble_role_id");
            this.aVd = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
            this.extInfoJson = jSONObject.optJSONObject("ext_info");
        }
    }
}
