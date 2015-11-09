package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class s {
    private String Vp;
    private String Vq;
    private IconData Vr = new IconData();
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void rV() {
        this.isAdded = true;
    }

    public boolean rW() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.Vp = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.Vq = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Vr.setIcon(userInfo.tshow_icon.icon);
                this.Vr.setIconName(userInfo.tshow_icon.name);
                this.Vr.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String rX() {
        return this.Vp;
    }

    public String getName() {
        return this.name;
    }

    public boolean rY() {
        return 2 == this.sex;
    }

    public String rZ() {
        return this.Vq;
    }

    public IconData sa() {
        return this.Vr;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.Vp = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.Vq = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Vr.setIcon(optJSONObject.optString("icon"));
                this.Vr.setIconName(optJSONObject.optString("user_name"));
                this.Vr.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
