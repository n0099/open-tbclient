package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class t {
    private String Qi;
    private String Qj;
    private IconData Qk = new IconData();
    private boolean isAdded;
    private String name;
    private int sex;
    private int userId;

    public void qu() {
        this.isAdded = true;
    }

    public boolean qv() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.intValue();
            this.Qi = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.Qj = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Qk.setIcon(userInfo.tshow_icon.icon);
                this.Qk.setIconName(userInfo.tshow_icon.name);
                this.Qk.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public String qw() {
        return this.Qi;
    }

    public String getName() {
        return this.name;
    }

    public boolean qx() {
        return 2 == this.sex;
    }

    public String qy() {
        return this.Qj;
    }

    public IconData qz() {
        return this.Qk;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optInt("user_id");
            this.name = jSONObject.optString("user_name");
            this.Qi = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.Qj = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Qk.setIcon(optJSONObject.optString("icon"));
                this.Qk.setIconName(optJSONObject.optString("user_name"));
                this.Qk.setUrl(optJSONObject.optString(ImageViewerConfig.URL));
            }
        }
    }
}
