package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class ak {
    private IconData UB = new IconData();
    private String Uz;
    private String introduction;
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void sH() {
        this.isAdded = true;
    }

    public boolean sI() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.Uz = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.introduction = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.UB.setIcon(userInfo.tshow_icon.icon);
                this.UB.setIconName(userInfo.tshow_icon.name);
                this.UB.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String sJ() {
        return this.Uz;
    }

    public String getName() {
        return this.name;
    }

    public boolean sK() {
        return 2 == this.sex;
    }

    public String sL() {
        return this.introduction;
    }

    public IconData sM() {
        return this.UB;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.Uz = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.introduction = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.UB.setIcon(optJSONObject.optString("icon"));
                this.UB.setIconName(optJSONObject.optString("user_name"));
                this.UB.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
