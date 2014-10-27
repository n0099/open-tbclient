package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class p {
    private String Ak;
    private String Al;
    private IconData Am = new IconData();
    private boolean isAdded;
    private String name;
    private int sex;
    private int userId;

    public void kq() {
        this.isAdded = true;
    }

    public boolean kr() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.intValue();
            this.Ak = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.Al = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Am.setIcon(userInfo.tshow_icon.icon);
                this.Am.setIconName(userInfo.tshow_icon.name);
                this.Am.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public String ks() {
        return this.Ak;
    }

    public String getName() {
        return this.name;
    }

    public boolean kt() {
        return 2 == this.sex;
    }

    public String ku() {
        return this.Al;
    }

    public IconData kv() {
        return this.Am;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.USER_ID);
            this.name = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
            this.Ak = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.Al = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Am.setIcon(optJSONObject.optString("icon"));
                this.Am.setIconName(optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME));
                this.Am.setUrl(optJSONObject.optString(ImageViewerConfig.URL));
            }
        }
    }
}
