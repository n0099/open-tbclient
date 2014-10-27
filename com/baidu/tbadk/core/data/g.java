package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class g {
    private int mType;
    private String mValue;
    private int zJ;
    private String zK;
    private String zL;

    public int jT() {
        return this.zJ;
    }

    public String jU() {
        return this.zK;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String jV() {
        return this.zL;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.zJ = jSONObject.optInt("bannerType");
                this.zK = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.zL = jSONObject.optString("desc");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.zJ = banner.banner_type.intValue();
            this.zK = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.zL = banner.desc;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.zK)) {
            return false;
        }
        if (this.mType == 1 || this.mType == 2) {
            return (this.zJ == 1 || this.zJ == 4 || this.zJ == 2 || this.zJ == 3) && !StringUtils.isNull(this.mValue);
        }
        return false;
    }
}
