package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class az {
    private String SX;
    private IconData SY = new IconData();
    private String introduction;
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void qX() {
        this.isAdded = true;
    }

    public boolean qY() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.SX = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.introduction = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.SY.setIcon(userInfo.tshow_icon.icon);
                this.SY.setIconName(userInfo.tshow_icon.name);
                this.SY.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String qZ() {
        return this.SX;
    }

    public String getName() {
        return this.name;
    }

    public boolean ra() {
        return 2 == this.sex;
    }

    public String rb() {
        return this.introduction;
    }

    public IconData rc() {
        return this.SY;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.SX = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.introduction = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.SY.setIcon(optJSONObject.optString("icon"));
                this.SY.setIconName(optJSONObject.optString("user_name"));
                this.SY.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
