package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public String bfJ;
    public String bfK;
    public int bfL;
    public String bfM;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.bfJ = jSONObject.optString("head_img");
            this.bfK = jSONObject.optString("nick_name");
            this.bfL = jSONObject.optInt("noble_role_id");
            this.bfM = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
        }
    }
}
