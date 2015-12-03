package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class v {
    private String VU;
    private String VV;
    private IconData VW = new IconData();
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void ss() {
        this.isAdded = true;
    }

    public boolean st() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.VU = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.VV = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.VW.setIcon(userInfo.tshow_icon.icon);
                this.VW.setIconName(userInfo.tshow_icon.name);
                this.VW.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String su() {
        return this.VU;
    }

    public String getName() {
        return this.name;
    }

    public boolean sv() {
        return 2 == this.sex;
    }

    public String sw() {
        return this.VV;
    }

    public IconData sx() {
        return this.VW;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.VU = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.VV = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.VW.setIcon(optJSONObject.optString("icon"));
                this.VW.setIconName(optJSONObject.optString("user_name"));
                this.VW.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
