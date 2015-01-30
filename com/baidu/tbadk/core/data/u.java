package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class u {
    private String EA;
    private IconData EB = new IconData();
    private String Ez;
    private boolean isAdded;
    private String name;
    private int sex;
    private int userId;

    public void nl() {
        this.isAdded = true;
    }

    public boolean nm() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.intValue();
            this.Ez = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.EA = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.EB.setIcon(userInfo.tshow_icon.icon);
                this.EB.setIconName(userInfo.tshow_icon.name);
                this.EB.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public String nn() {
        return this.Ez;
    }

    public String getName() {
        return this.name;
    }

    public boolean no() {
        return 2 == this.sex;
    }

    public String np() {
        return this.EA;
    }

    public IconData nq() {
        return this.EB;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optInt("user_id");
            this.name = jSONObject.optString("user_name");
            this.Ez = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.EA = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.EB.setIcon(optJSONObject.optString("icon"));
                this.EB.setIconName(optJSONObject.optString("user_name"));
                this.EB.setUrl(optJSONObject.optString(ImageViewerConfig.URL));
            }
        }
    }
}
