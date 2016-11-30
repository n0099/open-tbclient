package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class bb {
    private String Ts;
    private IconData Tt = new IconData();
    private String introduction;
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void qZ() {
        this.isAdded = true;
    }

    public boolean ra() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.Ts = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.introduction = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Tt.setIcon(userInfo.tshow_icon.icon);
                this.Tt.setIconName(userInfo.tshow_icon.name);
                this.Tt.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String rb() {
        return this.Ts;
    }

    public String getName() {
        return this.name;
    }

    public boolean rc() {
        return 2 == this.sex;
    }

    public String rd() {
        return this.introduction;
    }

    public IconData re() {
        return this.Tt;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.Ts = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.introduction = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Tt.setIcon(optJSONObject.optString("icon"));
                this.Tt.setIconName(optJSONObject.optString("user_name"));
                this.Tt.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
