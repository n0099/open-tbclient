package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class p {
    private int Tb;
    private String Tc;
    private String Td;
    private int Te;
    private int mType;
    private String mValue;

    public int rD() {
        return this.Tb;
    }

    public String rE() {
        return this.Tc;
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
                this.Tb = jSONObject.optInt("bannerType");
                this.Tc = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.Td = jSONObject.optString("desc");
                this.Te = jSONObject.optInt("template_id");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.Tb = banner.banner_type.intValue();
            this.Tc = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.Td = banner.desc;
            this.Te = banner.template_id.intValue();
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.Tb == 1 || this.Tb == 4 || this.Tb == 2 || this.Tb == 3 : this.mType == 2 && !StringUtils.isNull(this.Td);
    }

    public int rF() {
        return this.Te;
    }
}
