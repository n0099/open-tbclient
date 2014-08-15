package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class g {
    private int a;
    private String b;
    private String c;
    private int d;
    private String e;

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("bannerType");
                this.b = jSONObject.optString("bannerUrl");
                this.c = jSONObject.optString("value");
                this.d = jSONObject.optInt("type");
                this.e = jSONObject.optString("desc");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.a = banner.banner_type.intValue();
            this.b = banner.banner_url;
            this.c = banner.value;
            this.d = banner.type.intValue();
            this.e = banner.desc;
        }
    }
}
