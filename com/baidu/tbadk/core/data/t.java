package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class t {
    private String Ev;
    private String Ew;
    private IconData Ex = new IconData();
    private boolean isAdded;
    private String name;
    private int sex;
    private int userId;

    public void nj() {
        this.isAdded = true;
    }

    public boolean nk() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.intValue();
            this.Ev = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.Ew = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Ex.setIcon(userInfo.tshow_icon.icon);
                this.Ex.setIconName(userInfo.tshow_icon.name);
                this.Ex.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public String nl() {
        return this.Ev;
    }

    public String getName() {
        return this.name;
    }

    public boolean nm() {
        return 2 == this.sex;
    }

    public String nn() {
        return this.Ew;
    }

    public IconData no() {
        return this.Ex;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optInt("user_id");
            this.name = jSONObject.optString("user_name");
            this.Ev = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.Ew = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Ex.setIcon(optJSONObject.optString("icon"));
                this.Ex.setIconName(optJSONObject.optString("user_name"));
                this.Ex.setUrl(optJSONObject.optString(ImageViewerConfig.URL));
            }
        }
    }
}
