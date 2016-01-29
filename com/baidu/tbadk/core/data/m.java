package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class m {
    private int Vr;
    private String Vs;
    private String Vt;
    private int Vu;
    private int mType;
    private String mValue;

    public int sa() {
        return this.Vr;
    }

    public String sb() {
        return this.Vs;
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
                this.Vr = jSONObject.optInt("bannerType");
                this.Vs = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.Vt = jSONObject.optString("desc");
                this.Vu = jSONObject.optInt("template_id");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.Vr = banner.banner_type.intValue();
            this.Vs = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.Vt = banner.desc;
            this.Vu = banner.template_id.intValue();
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.Vr == 1 || this.Vr == 4 || this.Vr == 2 || this.Vr == 3 : this.mType == 2 && !StringUtils.isNull(this.Vt);
    }

    public int sc() {
        return this.Vu;
    }
}
