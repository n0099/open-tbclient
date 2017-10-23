package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private int VS;
    private String VT;
    private String VU;
    private int VV;
    private String VW;
    public String VX;
    public float VY;
    public boolean VZ = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pM() {
        return this.VS;
    }

    public String pN() {
        return this.VT;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pO() {
        return this.VW;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VS = jSONObject.optInt("bannerType");
                this.VT = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.VU = jSONObject.optString("desc");
                this.VV = jSONObject.optInt("template_id");
                this.VW = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.VX = jSONObject.optString("tag_name_url");
                cv(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.VS = banner.banner_type.intValue();
            this.VT = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.VU = banner.desc;
            this.VV = banner.template_id.intValue();
            this.VW = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.VX = banner.tag_name_url;
            cv(banner.tag_name_wh);
        }
    }

    private void cv(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.VY = g / g2;
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
        return this.mType == 1 ? this.VS == 1 || this.VS == 4 || this.VS == 2 || this.VS == 3 : this.mType == 2 && !StringUtils.isNull(this.VU);
    }
}
