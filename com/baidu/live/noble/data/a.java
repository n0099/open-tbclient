package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aUb;
    public String aUc;
    public int aUd;
    public String aUe;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.aUb = jSONObject.optString("head_img");
            this.aUc = jSONObject.optString("nick_name");
            this.aUd = jSONObject.optInt("noble_role_id");
            this.aUe = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
        }
    }
}
