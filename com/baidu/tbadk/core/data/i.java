package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class i {
    private int DP;
    private String DQ;
    private String DR;
    private int mType;
    private String mValue;

    public int mI() {
        return this.DP;
    }

    public String mJ() {
        return this.DQ;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String mK() {
        return this.DR;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.DP = jSONObject.optInt("bannerType");
                this.DQ = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.DR = jSONObject.optString("desc");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.DP = banner.banner_type.intValue();
            this.DQ = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.DR = banner.desc;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.DP == 1 || this.DP == 4 || this.DP == 2 || this.DP == 3 : this.mType == 2 && !StringUtils.isNull(this.DR);
    }
}
