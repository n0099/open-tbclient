package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String bmo;
    public String bmp;
    public int bmq;
    public String bmr;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.bmo = jSONObject.optString("head_img");
            this.bmp = jSONObject.optString("nick_name");
            this.bmq = jSONObject.optInt("noble_role_id");
            this.bmr = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
        }
    }
}
