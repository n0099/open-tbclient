package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Badges;
/* loaded from: classes.dex */
public class g {
    private int SH;
    private String badge_url;
    private String webview;

    public String rt() {
        return this.badge_url;
    }

    public String ru() {
        return String.valueOf(this.SH);
    }

    public String rv() {
        return this.webview;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.SH = jSONObject.optInt("badge_id", 0);
                this.badge_url = jSONObject.optString("badge_url", "");
                this.webview = jSONObject.optString("webview");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Badges badges) {
        if (badges != null) {
            this.SH = badges.badge_id.intValue();
            this.badge_url = badges.badge_url;
            this.webview = badges.webview;
        }
    }
}
