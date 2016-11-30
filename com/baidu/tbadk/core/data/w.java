package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class w {
    private int Rb;
    private String Rc;
    private String Rd;
    private int Re;
    private String Rf;
    public String Rg;
    public float Rh;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pU() {
        return this.Rb;
    }

    public String pV() {
        return this.Rc;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pA() {
        return this.Rf;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Rb = jSONObject.optInt("bannerType");
                this.Rc = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.Rd = jSONObject.optString("desc");
                this.Re = jSONObject.optInt("template_id");
                this.Rf = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.Rg = jSONObject.optString("tag_name_url");
                cn(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.Rb = banner.banner_type.intValue();
            this.Rc = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.Rd = banner.desc;
            this.Re = banner.template_id.intValue();
            this.Rf = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.Rg = banner.tag_name_url;
            cn(banner.tag_name_wh);
        }
    }

    private void cn(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.Rh = g / g2;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.Rb == 1 || this.Rb == 4 || this.Rb == 2 || this.Rb == 3 : this.mType == 2 && !StringUtils.isNull(this.Rd);
    }
}
