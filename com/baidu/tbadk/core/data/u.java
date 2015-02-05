package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class u {
    private String Ew;
    private String Ex;
    private IconData Ey = new IconData();
    private boolean isAdded;
    private String name;
    private int sex;
    private int userId;

    public void ne() {
        this.isAdded = true;
    }

    public boolean nf() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.intValue();
            this.Ew = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.Ex = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Ey.setIcon(userInfo.tshow_icon.icon);
                this.Ey.setIconName(userInfo.tshow_icon.name);
                this.Ey.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public String ng() {
        return this.Ew;
    }

    public String getName() {
        return this.name;
    }

    public boolean nh() {
        return 2 == this.sex;
    }

    public String ni() {
        return this.Ex;
    }

    public IconData nj() {
        return this.Ey;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optInt("user_id");
            this.name = jSONObject.optString("user_name");
            this.Ew = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.Ex = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Ey.setIcon(optJSONObject.optString("icon"));
                this.Ey.setIconName(optJSONObject.optString("user_name"));
                this.Ey.setUrl(optJSONObject.optString(ImageViewerConfig.URL));
            }
        }
    }
}
