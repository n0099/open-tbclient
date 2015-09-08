package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class s {
    private String Vw;
    private String Vx;
    private IconData Vy = new IconData();
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void sb() {
        this.isAdded = true;
    }

    public boolean sc() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.Vw = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.Vx = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Vy.setIcon(userInfo.tshow_icon.icon);
                this.Vy.setIconName(userInfo.tshow_icon.name);
                this.Vy.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String sd() {
        return this.Vw;
    }

    public String getName() {
        return this.name;
    }

    public boolean se() {
        return 2 == this.sex;
    }

    public String sf() {
        return this.Vx;
    }

    public IconData sg() {
        return this.Vy;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.Vw = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.Vx = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Vy.setIcon(optJSONObject.optString("icon"));
                this.Vy.setIconName(optJSONObject.optString("user_name"));
                this.Vy.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
