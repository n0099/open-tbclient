package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class j {
    private int UX;
    private String UY;
    private String UZ;
    private int mType;
    private String mValue;

    public int rG() {
        return this.UX;
    }

    public String rH() {
        return this.UY;
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
                this.UX = jSONObject.optInt("bannerType");
                this.UY = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.UZ = jSONObject.optString("desc");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.UX = banner.banner_type.intValue();
            this.UY = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.UZ = banner.desc;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.UX == 1 || this.UX == 4 || this.UX == 2 || this.UX == 3 : this.mType == 2 && !StringUtils.isNull(this.UZ);
    }
}
