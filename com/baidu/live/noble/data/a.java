package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String aTq;
    public String aTr;
    public int aTs;
    public String aTt;
    public JSONObject extInfoJson;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.aTq = jSONObject.optString("head_img");
            this.aTr = jSONObject.optString("nick_name");
            this.aTs = jSONObject.optInt("noble_role_id");
            this.aTt = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
            this.extInfoJson = jSONObject.optJSONObject("ext_info");
        }
    }
}
