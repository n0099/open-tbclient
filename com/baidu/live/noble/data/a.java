package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String biB;
    public String biC;
    public int biD;
    public String biE;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.biB = jSONObject.optString("head_img");
            this.biC = jSONObject.optString("nick_name");
            this.biD = jSONObject.optInt("noble_role_id");
            this.biE = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
        }
    }
}
