package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class j {
    private int UW;
    private String UX;
    private String UY;
    private int mType;
    private String mValue;

    public int rH() {
        return this.UW;
    }

    public String rI() {
        return this.UX;
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
                this.UW = jSONObject.optInt("bannerType");
                this.UX = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.UY = jSONObject.optString("desc");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.UW = banner.banner_type.intValue();
            this.UX = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.UY = banner.desc;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.UW == 1 || this.UW == 4 || this.UW == 2 || this.UW == 3 : this.mType == 2 && !StringUtils.isNull(this.UY);
    }
}
