package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aSK;
    public String aSL;
    public int aSM;
    public String aSN;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.aSK = jSONObject.optString("head_img");
            this.aSL = jSONObject.optString("nick_name");
            this.aSM = jSONObject.optInt("noble_role_id");
            this.aSN = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
        }
    }
}
