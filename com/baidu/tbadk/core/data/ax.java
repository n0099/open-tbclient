package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class ax {
    private String SQ;
    private IconData SR = new IconData();
    private String introduction;
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void qM() {
        this.isAdded = true;
    }

    public boolean qN() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.SQ = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.introduction = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.SR.setIcon(userInfo.tshow_icon.icon);
                this.SR.setIconName(userInfo.tshow_icon.name);
                this.SR.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String qO() {
        return this.SQ;
    }

    public String getName() {
        return this.name;
    }

    public boolean qP() {
        return 2 == this.sex;
    }

    public String qQ() {
        return this.introduction;
    }

    public IconData qR() {
        return this.SR;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.SQ = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.introduction = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.SR.setIcon(optJSONObject.optString("icon"));
                this.SR.setIconName(optJSONObject.optString("user_name"));
                this.SR.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
