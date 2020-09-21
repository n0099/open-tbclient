package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class ad {
    private String eaA;
    private int eaB;
    private String eaC;
    public String eaD;
    public float eaE;
    public boolean eaF = true;
    private int eaz;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int bdK() {
        return this.eaz;
    }

    public String bdL() {
        return this.eaA;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String bdD() {
        return this.eaC;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eaz = jSONObject.optInt("bannerType");
                this.eaA = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.eaB = jSONObject.optInt("template_id");
                this.eaC = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.eaD = jSONObject.optString("tag_name_url");
                zw(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.eaz = banner.banner_type.intValue();
            this.eaA = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.eaB = banner.template_id.intValue();
            this.eaC = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.eaD = banner.tag_name_url;
            zw(banner.tag_name_wh);
        }
    }

    private void zw(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.eaE = i / i2;
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
        return this.mType == 1 ? this.eaz == 1 || this.eaz == 4 || this.eaz == 2 || this.eaz == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
