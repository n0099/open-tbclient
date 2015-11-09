package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class j {
    private int UO;
    private String UQ;
    private String UR;
    private int US;
    private int mType;
    private String mValue;

    public int rz() {
        return this.UO;
    }

    public String rA() {
        return this.UQ;
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
                this.UO = jSONObject.optInt("bannerType");
                this.UQ = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.UR = jSONObject.optString("desc");
                this.US = jSONObject.optInt("template_id");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.UO = banner.banner_type.intValue();
            this.UQ = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.UR = banner.desc;
            this.US = banner.template_id.intValue();
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.UO == 1 || this.UO == 4 || this.UO == 2 || this.UO == 3 : this.mType == 2 && !StringUtils.isNull(this.UR);
    }

    public int rB() {
        return this.US;
    }
}
