package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class v {
    private String Wu;
    private String Wv;
    private IconData Ww = new IconData();
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void sb() {
        this.isAdded = true;
    }

    public boolean sc() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.Wu = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.Wv = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Ww.setIcon(userInfo.tshow_icon.icon);
                this.Ww.setIconName(userInfo.tshow_icon.name);
                this.Ww.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String sd() {
        return this.Wu;
    }

    public String getName() {
        return this.name;
    }

    public boolean se() {
        return 2 == this.sex;
    }

    public String sf() {
        return this.Wv;
    }

    public IconData sg() {
        return this.Ww;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.Wu = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.Wv = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Ww.setIcon(optJSONObject.optString("icon"));
                this.Ww.setIconName(optJSONObject.optString("user_name"));
                this.Ww.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
