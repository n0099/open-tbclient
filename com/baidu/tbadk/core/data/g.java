package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Badges;
/* loaded from: classes.dex */
public class g {
    private int UF;
    private String badge_url;
    private String webview;

    public String pX() {
        return this.badge_url;
    }

    public String pY() {
        return String.valueOf(this.UF);
    }

    public String pZ() {
        return this.webview;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.UF = jSONObject.optInt("badge_id", 0);
                this.badge_url = jSONObject.optString("badge_url", "");
                this.webview = jSONObject.optString("webview");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Badges badges) {
        if (badges != null) {
            this.UF = badges.badge_id.intValue();
            this.badge_url = badges.badge_url;
            this.webview = badges.webview;
        }
    }
}
