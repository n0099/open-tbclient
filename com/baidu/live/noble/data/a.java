package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String aXF;
    public String aXG;
    public int aXH;
    public String aXI;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.aXF = jSONObject.optString("head_img");
            this.aXG = jSONObject.optString("nick_name");
            this.aXH = jSONObject.optInt("noble_role_id");
            this.aXI = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
        }
    }
}
