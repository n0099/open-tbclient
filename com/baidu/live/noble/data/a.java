package com.baidu.live.noble.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String bal;
    public String bam;
    public int ban;
    public String bao;
    public String icon_url;
    public String user_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.user_id = jSONObject.optString("user_id");
            this.bal = jSONObject.optString("head_img");
            this.bam = jSONObject.optString("nick_name");
            this.ban = jSONObject.optInt("noble_role_id");
            this.bao = jSONObject.optString("noble_role_name");
            this.icon_url = jSONObject.optString("icon_url");
        }
    }
}
