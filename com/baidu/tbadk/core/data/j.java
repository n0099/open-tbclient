package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class j {
    private int DU;
    private String DV;
    private String DW;
    private int mType;
    private String mValue;

    public int mK() {
        return this.DU;
    }

    public String mL() {
        return this.DV;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String mM() {
        return this.DW;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.DU = jSONObject.optInt("bannerType");
                this.DV = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.DW = jSONObject.optString("desc");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.DU = banner.banner_type.intValue();
            this.DV = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.DW = banner.desc;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.DU == 1 || this.DU == 4 || this.DU == 2 || this.DU == 3 : this.mType == 2 && !StringUtils.isNull(this.DW);
    }
}
