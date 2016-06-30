package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class aq {
    private String PJ;
    private IconData PK = new IconData();
    private String introduction;
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void pZ() {
        this.isAdded = true;
    }

    public boolean qa() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.PJ = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.introduction = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.PK.setIcon(userInfo.tshow_icon.icon);
                this.PK.setIconName(userInfo.tshow_icon.name);
                this.PK.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String qb() {
        return this.PJ;
    }

    public String getName() {
        return this.name;
    }

    public boolean qc() {
        return 2 == this.sex;
    }

    public String qd() {
        return this.introduction;
    }

    public IconData qe() {
        return this.PK;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.PJ = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.introduction = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.PK.setIcon(optJSONObject.optString("icon"));
                this.PK.setIconName(optJSONObject.optString("user_name"));
                this.PK.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
