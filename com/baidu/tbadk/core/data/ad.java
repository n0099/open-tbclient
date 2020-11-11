package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class ad {
    private int eAU;
    private String eAV;
    private int eAW;
    private String eAX;
    public String eAY;
    public float eAZ;
    public boolean eBa = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int bkM() {
        return this.eAU;
    }

    public String bkN() {
        return this.eAV;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String bkF() {
        return this.eAX;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eAU = jSONObject.optInt("bannerType");
                this.eAV = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.eAW = jSONObject.optInt("template_id");
                this.eAX = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.eAY = jSONObject.optString("tag_name_url");
                AP(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.eAU = banner.banner_type.intValue();
            this.eAV = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.eAW = banner.template_id.intValue();
            this.eAX = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.eAY = banner.tag_name_url;
            AP(banner.tag_name_wh);
        }
    }

    private void AP(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.eAZ = i / i2;
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
        return this.mType == 1 ? this.eAU == 1 || this.eAU == 4 || this.eAU == 2 || this.eAU == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
