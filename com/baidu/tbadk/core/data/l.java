package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.MemberShowIcon;
/* loaded from: classes.dex */
public class l {
    private String Vq;
    private String mName;
    private String mUrl;

    public String getIcon() {
        return this.Vq;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void a(MemberShowIcon memberShowIcon) {
        if (memberShowIcon != null) {
            this.Vq = memberShowIcon.icon;
            this.mName = memberShowIcon.name;
            this.mUrl = memberShowIcon.url;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vq = jSONObject.optString("icon");
                this.mName = jSONObject.optString("name");
                this.mUrl = jSONObject.optString("url");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
