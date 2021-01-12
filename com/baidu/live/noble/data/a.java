package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String aQn;
    public String aQo;
    public int aQp;
    public String aQq;
    public JSONObject extInfoJson;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.aQn = jSONObject.optString("head_img");
            this.aQo = jSONObject.optString("nick_name");
            this.aQp = jSONObject.optInt("noble_role_id");
            this.aQq = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
            this.extInfoJson = jSONObject.optJSONObject("ext_info");
        }
    }
}
