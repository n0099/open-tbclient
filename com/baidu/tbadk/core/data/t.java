package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class t {
    private String QG;
    private String QH;
    private IconData QI = new IconData();
    private boolean isAdded;
    private String name;
    private int sex;
    private int userId;

    public void ra() {
        this.isAdded = true;
    }

    public boolean rb() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.intValue();
            this.QG = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.QH = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.QI.setIcon(userInfo.tshow_icon.icon);
                this.QI.setIconName(userInfo.tshow_icon.name);
                this.QI.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public String rc() {
        return this.QG;
    }

    public String getName() {
        return this.name;
    }

    public boolean rd() {
        return 2 == this.sex;
    }

    public String re() {
        return this.QH;
    }

    public IconData rf() {
        return this.QI;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optInt("user_id");
            this.name = jSONObject.optString("user_name");
            this.QG = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.QH = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.QI.setIcon(optJSONObject.optString("icon"));
                this.QI.setIconName(optJSONObject.optString("user_name"));
                this.QI.setUrl(optJSONObject.optString(ImageViewerConfig.URL));
            }
        }
    }
}
