package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String ban;
    public String bao;
    public int bap;
    public String baq;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.ban = jSONObject.optString("head_img");
            this.bao = jSONObject.optString("nick_name");
            this.bap = jSONObject.optInt("noble_role_id");
            this.baq = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
        }
    }
}
