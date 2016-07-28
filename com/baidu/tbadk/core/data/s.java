package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class s {
    private int NT;
    private String NU;
    private String NV;
    private int NW;
    private String NX;
    private int mType;
    private String mValue;

    public int oD() {
        return this.NT;
    }

    public String oE() {
        return this.NU;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String oA() {
        return this.NX;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.NT = jSONObject.optInt("bannerType");
                this.NU = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.NV = jSONObject.optString("desc");
                this.NW = jSONObject.optInt("template_id");
                this.NX = jSONObject.optString("obj_id");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.NT = banner.banner_type.intValue();
            this.NU = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.NV = banner.desc;
            this.NW = banner.template_id.intValue();
            this.NX = banner.obj_id;
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.NT == 1 || this.NT == 4 || this.NT == 2 || this.NT == 3 : this.mType == 2 && !StringUtils.isNull(this.NV);
    }
}
