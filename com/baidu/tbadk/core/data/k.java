package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class k {
    private int PH;
    private String PJ;
    private String PK;
    private int mType;
    private String mValue;

    public int pY() {
        return this.PH;
    }

    public String pZ() {
        return this.PJ;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String qa() {
        return this.PK;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.PH = jSONObject.optInt("bannerType");
                this.PJ = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.PK = jSONObject.optString("desc");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.PH = banner.banner_type.intValue();
            this.PJ = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.PK = banner.desc;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.PH == 1 || this.PH == 4 || this.PH == 2 || this.PH == 3 : this.mType == 2 && !StringUtils.isNull(this.PK);
    }
}
