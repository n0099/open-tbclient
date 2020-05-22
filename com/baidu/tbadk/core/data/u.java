package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
import tbclient.FrsPage.MemberShowIcon;
/* loaded from: classes.dex */
public class u {
    private String mIcon;
    private String mName;
    private String mUrl;

    public void a(MemberShowIcon memberShowIcon) {
        if (memberShowIcon != null) {
            this.mIcon = memberShowIcon.icon;
            this.mName = memberShowIcon.name;
            this.mUrl = memberShowIcon.url;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.mName = jSONObject.optString("name");
                this.mUrl = jSONObject.optString("url");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
