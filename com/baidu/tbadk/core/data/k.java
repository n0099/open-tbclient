package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class k {
    private int Qe;
    private String Qf;
    private String Qg;
    private int mType;
    private String mValue;

    public int qE() {
        return this.Qe;
    }

    public String qF() {
        return this.Qf;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String qG() {
        return this.Qg;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Qe = jSONObject.optInt("bannerType");
                this.Qf = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.Qg = jSONObject.optString("desc");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.Qe = banner.banner_type.intValue();
            this.Qf = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.Qg = banner.desc;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.Qe == 1 || this.Qe == 4 || this.Qe == 2 || this.Qe == 3 : this.mType == 2 && !StringUtils.isNull(this.Qg);
    }
}
