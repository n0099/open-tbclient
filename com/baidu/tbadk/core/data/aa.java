package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class aa {
    private String Wq;
    private String Wr;
    private IconData Ws = new IconData();
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void sM() {
        this.isAdded = true;
    }

    public boolean sN() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.Wq = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.Wr = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Ws.setIcon(userInfo.tshow_icon.icon);
                this.Ws.setIconName(userInfo.tshow_icon.name);
                this.Ws.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String sO() {
        return this.Wq;
    }

    public String getName() {
        return this.name;
    }

    public boolean sP() {
        return 2 == this.sex;
    }

    public String sQ() {
        return this.Wr;
    }

    public IconData sR() {
        return this.Ws;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.Wq = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.Wr = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Ws.setIcon(optJSONObject.optString("icon"));
                this.Ws.setIconName(optJSONObject.optString("user_name"));
                this.Ws.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
