package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Badges;
/* loaded from: classes.dex */
public class a {
    private int a;
    private String b;
    private String c;

    public String a() {
        return this.b;
    }

    public String b() {
        return String.valueOf(this.a);
    }

    public String c() {
        return this.c;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("badge_id", 0);
                this.b = jSONObject.optString("badge_url", "");
                this.c = jSONObject.optString("webview");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Badges badges) {
        if (badges != null) {
            this.a = badges.badge_id.intValue();
            this.b = badges.badge_url;
            this.c = badges.webview;
        }
    }
}
