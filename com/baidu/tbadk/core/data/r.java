package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes.dex */
public class r {
    private String Vl;
    private String Vm;
    private IconData Vn = new IconData();
    private boolean isAdded;
    private String name;
    private int sex;
    private long userId;

    public void rW() {
        this.isAdded = true;
    }

    public boolean rX() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.user_id.longValue();
            this.Vl = userInfo.portrait;
            this.name = userInfo.user_name;
            this.sex = userInfo.gender.intValue();
            this.Vm = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.Vn.setIcon(userInfo.tshow_icon.icon);
                this.Vn.setIconName(userInfo.tshow_icon.name);
                this.Vn.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String rY() {
        return this.Vl;
    }

    public String getName() {
        return this.name;
    }

    public boolean rZ() {
        return 2 == this.sex;
    }

    public String sa() {
        return this.Vm;
    }

    public IconData sb() {
        return this.Vn;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.name = jSONObject.optString("user_name");
            this.Vl = jSONObject.optString("portait");
            this.sex = jSONObject.optInt("gender");
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.Vm = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Vn.setIcon(optJSONObject.optString("icon"));
                this.Vn.setIconName(optJSONObject.optString("user_name"));
                this.Vn.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
