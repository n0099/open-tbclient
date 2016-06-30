package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class r {
    private int NL;
    private String NM;
    private String NN;
    private int NP;
    private String NQ;
    private int mType;
    private String mValue;

    public int oO() {
        return this.NL;
    }

    public String oP() {
        return this.NM;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String oL() {
        return this.NQ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.NL = jSONObject.optInt("bannerType");
                this.NM = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.NN = jSONObject.optString("desc");
                this.NP = jSONObject.optInt("template_id");
                this.NQ = jSONObject.optString("obj_id");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.NL = banner.banner_type.intValue();
            this.NM = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.NN = banner.desc;
            this.NP = banner.template_id.intValue();
            this.NQ = banner.obj_id;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.NL == 1 || this.NL == 4 || this.NL == 2 || this.NL == 3 : this.mType == 2 && !StringUtils.isNull(this.NN);
    }
}
