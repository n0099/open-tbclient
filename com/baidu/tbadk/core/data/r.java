package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class r {
    private String Vt;
    private String Vu;
    private IconData Vv = new IconData();
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void sd() {
        this.isAdded = true;
    }

    public boolean se() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.Vt = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.Vu = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Vv.setIcon(userInfo.tshow_icon.icon);
                this.Vv.setIconName(userInfo.tshow_icon.name);
                this.Vv.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String sf() {
        return this.Vt;
    }

    public String getName() {
        return this.name;
    }

    public boolean sg() {
        return 2 == this.sex;
    }

    public String sh() {
        return this.Vu;
    }

    public IconData si() {
        return this.Vv;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.Vt = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.Vu = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Vv.setIcon(optJSONObject.optString("icon"));
                this.Vv.setIconName(optJSONObject.optString("user_name"));
                this.Vv.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
