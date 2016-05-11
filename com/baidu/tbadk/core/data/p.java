package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class p {
    private int NN;
    private String NP;
    private String NQ;
    private int NR;
    private String NS;
    private int mType;
    private String mValue;

    public int oX() {
        return this.NN;
    }

    public String oY() {
        return this.NP;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String oT() {
        return this.NS;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.NN = jSONObject.optInt("bannerType");
                this.NP = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.NQ = jSONObject.optString("desc");
                this.NR = jSONObject.optInt("template_id");
                this.NS = jSONObject.optString("obj_id");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.NN = banner.banner_type.intValue();
            this.NP = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.NQ = banner.desc;
            this.NR = banner.template_id.intValue();
            this.NS = banner.obj_id;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.NN == 1 || this.NN == 4 || this.NN == 2 || this.NN == 3 : this.mType == 2 && !StringUtils.isNull(this.NQ);
    }
}
