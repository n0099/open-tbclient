package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class t {
    private String Qk;
    private String Ql;
    private IconData Qm = new IconData();
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
            this.Qk = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.Ql = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Qm.setIcon(userInfo.tshow_icon.icon);
                this.Qm.setIconName(userInfo.tshow_icon.name);
                this.Qm.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public String qw() {
        return this.Qk;
    }

    public String getName() {
        return this.name;
    }

    public boolean qx() {
        return 2 == this.sex;
    }

    public String qy() {
        return this.Ql;
    }

    public IconData qz() {
        return this.Qm;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optInt("user_id");
            this.name = jSONObject.optString("user_name");
            this.Qk = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.Ql = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Qm.setIcon(optJSONObject.optString("icon"));
                this.Qm.setIconName(optJSONObject.optString("user_name"));
                this.Qm.setUrl(optJSONObject.optString(ImageViewerConfig.URL));
            }
        }
    }
}
