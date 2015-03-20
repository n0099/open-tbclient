package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class k {
    private int PF;
    private String PG;
    private String PH;
    private int mType;
    private String mValue;

    public int pY() {
        return this.PF;
    }

    public String pZ() {
        return this.PG;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String qa() {
        return this.PH;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.PF = jSONObject.optInt("bannerType");
                this.PG = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.PH = jSONObject.optString("desc");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.PF = banner.banner_type.intValue();
            this.PG = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.PH = banner.desc;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.PF == 1 || this.PF == 4 || this.PF == 2 || this.PF == 3 : this.mType == 2 && !StringUtils.isNull(this.PH);
    }
}
