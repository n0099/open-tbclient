package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class j {
    private int UN;
    private String UO;
    private String UQ;
    private int mType;
    private String mValue;

    public int rB() {
        return this.UN;
    }

    public String rC() {
        return this.UO;
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
                this.UN = jSONObject.optInt("bannerType");
                this.UO = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.UQ = jSONObject.optString("desc");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.UN = banner.banner_type.intValue();
            this.UO = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.UQ = banner.desc;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.UN == 1 || this.UN == 4 || this.UN == 2 || this.UN == 3 : this.mType == 2 && !StringUtils.isNull(this.UQ);
    }
}
