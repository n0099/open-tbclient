package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class s {
    private String Vn;
    private String Vo;
    private IconData Vp = new IconData();
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void rT() {
        this.isAdded = true;
    }

    public boolean rU() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.Vn = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.Vo = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Vp.setIcon(userInfo.tshow_icon.icon);
                this.Vp.setIconName(userInfo.tshow_icon.name);
                this.Vp.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String rV() {
        return this.Vn;
    }

    public String getName() {
        return this.name;
    }

    public boolean rW() {
        return 2 == this.sex;
    }

    public String rX() {
        return this.Vo;
    }

    public IconData rY() {
        return this.Vp;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.Vn = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.Vo = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Vp.setIcon(optJSONObject.optString("icon"));
                this.Vp.setIconName(optJSONObject.optString("user_name"));
                this.Vp.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
