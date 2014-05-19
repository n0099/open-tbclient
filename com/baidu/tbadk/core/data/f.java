package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class f {
    private int a;
    private String b;
    private String c;

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("bannerType");
                this.b = jSONObject.optString("bannerUrl");
                this.c = jSONObject.optString("value");
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.a = banner.banner_type.intValue();
            this.b = banner.banner_url;
            this.c = banner.value;
        }
    }
}
