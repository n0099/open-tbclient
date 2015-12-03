package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class j {
    private int Vf;
    private String Vg;
    private String Vh;
    private int Vi;
    private int mType;
    private String mValue;

    public int rN() {
        return this.Vf;
    }

    public String rO() {
        return this.Vg;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vf = jSONObject.optInt("bannerType");
                this.Vg = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.Vh = jSONObject.optString("desc");
                this.Vi = jSONObject.optInt("template_id");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.Vf = banner.banner_type.intValue();
            this.Vg = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.Vh = banner.desc;
            this.Vi = banner.template_id.intValue();
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.Vf == 1 || this.Vf == 4 || this.Vf == 2 || this.Vf == 3 : this.mType == 2 && !StringUtils.isNull(this.Vh);
    }

    public int rP() {
        return this.Vi;
    }
}
