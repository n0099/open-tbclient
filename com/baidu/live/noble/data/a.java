package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aRt;
    public String aRu;
    public int aRv;
    public String aRw;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.aRt = jSONObject.optString("head_img");
            this.aRu = jSONObject.optString("nick_name");
            this.aRv = jSONObject.optInt("noble_role_id");
            this.aRw = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
        }
    }
}
