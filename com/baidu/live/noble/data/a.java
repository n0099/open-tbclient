package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public String bfH;
    public String bfI;
    public int bfJ;
    public String bfK;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.bfH = jSONObject.optString("head_img");
            this.bfI = jSONObject.optString("nick_name");
            this.bfJ = jSONObject.optInt("noble_role_id");
            this.bfK = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
        }
    }
}
