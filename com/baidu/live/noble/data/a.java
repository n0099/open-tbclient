package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String aUQ;
    public String aUR;
    public int aUS;
    public String aUT;
    public JSONObject extInfoJson;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.aUQ = jSONObject.optString("head_img");
            this.aUR = jSONObject.optString("nick_name");
            this.aUS = jSONObject.optInt("noble_role_id");
            this.aUT = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
            this.extInfoJson = jSONObject.optJSONObject("ext_info");
        }
    }
}
