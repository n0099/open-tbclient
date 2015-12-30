package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class j {
    private int VF;
    private String VG;
    private String VH;
    private int VI;
    private int mType;
    private String mValue;

    public int rw() {
        return this.VF;
    }

    public String rx() {
        return this.VG;
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
                this.VF = jSONObject.optInt("bannerType");
                this.VG = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.VH = jSONObject.optString("desc");
                this.VI = jSONObject.optInt("template_id");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.VF = banner.banner_type.intValue();
            this.VG = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.VH = banner.desc;
            this.VI = banner.template_id.intValue();
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.VF == 1 || this.VF == 4 || this.VF == 2 || this.VF == 3 : this.mType == 2 && !StringUtils.isNull(this.VH);
    }

    public int ry() {
        return this.VI;
    }
}
