package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class j {
    private int DQ;
    private String DR;
    private String DS;
    private int mType;
    private String mValue;

    public int mD() {
        return this.DQ;
    }

    public String mE() {
        return this.DR;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String mF() {
        return this.DS;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.DQ = jSONObject.optInt("bannerType");
                this.DR = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.DS = jSONObject.optString("desc");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.DQ = banner.banner_type.intValue();
            this.DR = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.DS = banner.desc;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.DQ == 1 || this.DQ == 4 || this.DQ == 2 || this.DQ == 3 : this.mType == 2 && !StringUtils.isNull(this.DS);
    }
}
