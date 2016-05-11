package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class ao {
    private String Py;
    private IconData Pz = new IconData();
    private String introduction;
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void qf() {
        this.isAdded = true;
    }

    public boolean qg() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.Py = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.introduction = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Pz.setIcon(userInfo.tshow_icon.icon);
                this.Pz.setIconName(userInfo.tshow_icon.name);
                this.Pz.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String qh() {
        return this.Py;
    }

    public String getName() {
        return this.name;
    }

    public boolean qi() {
        return 2 == this.sex;
    }

    public String qj() {
        return this.introduction;
    }

    public IconData qk() {
        return this.Pz;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.Py = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.introduction = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Pz.setIcon(optJSONObject.optString("icon"));
                this.Pz.setIconName(optJSONObject.optString("user_name"));
                this.Pz.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
