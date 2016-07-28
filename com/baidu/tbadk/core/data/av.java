package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class av {
    private String Qh;
    private IconData Qi = new IconData();
    private String introduction;
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void pI() {
        this.isAdded = true;
    }

    public boolean pJ() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.Qh = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.introduction = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Qi.setIcon(userInfo.tshow_icon.icon);
                this.Qi.setIconName(userInfo.tshow_icon.name);
                this.Qi.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String pK() {
        return this.Qh;
    }

    public String getName() {
        return this.name;
    }

    public boolean pL() {
        return 2 == this.sex;
    }

    public String pM() {
        return this.introduction;
    }

    public IconData pN() {
        return this.Qi;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.Qh = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.introduction = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Qi.setIcon(optJSONObject.optString("icon"));
                this.Qi.setIconName(optJSONObject.optString("user_name"));
                this.Qi.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
