package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class i {
    private int UL;
    private String UM;
    private String UN;
    private int mType;
    private String mValue;

    public int rB() {
        return this.UL;
    }

    public String rC() {
        return this.UM;
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
                this.UL = jSONObject.optInt("bannerType");
                this.UM = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.UN = jSONObject.optString("desc");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.UL = banner.banner_type.intValue();
            this.UM = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.UN = banner.desc;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.UL == 1 || this.UL == 4 || this.UL == 2 || this.UL == 3 : this.mType == 2 && !StringUtils.isNull(this.UN);
    }
}
