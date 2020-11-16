package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aQZ;
    public String aRa;
    public int aRb;
    public String aRc;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.aQZ = jSONObject.optString("head_img");
            this.aRa = jSONObject.optString("nick_name");
            this.aRb = jSONObject.optInt("noble_role_id");
            this.aRc = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
        }
    }
}
