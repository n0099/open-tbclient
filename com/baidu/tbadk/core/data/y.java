package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class y {
    private String cKA;
    private int cKB;
    private String cKC;
    public String cKD;
    public float cKE;
    public boolean cKF = true;
    private int cKz;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int axY() {
        return this.cKz;
    }

    public String axZ() {
        return this.cKA;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String axP() {
        return this.cKC;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cKz = jSONObject.optInt("bannerType");
                this.cKA = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.cKB = jSONObject.optInt("template_id");
                this.cKC = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.cKD = jSONObject.optString("tag_name_url");
                sc(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.cKz = banner.banner_type.intValue();
            this.cKA = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.cKB = banner.template_id.intValue();
            this.cKC = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.cKD = banner.tag_name_url;
            sc(banner.tag_name_wh);
        }
    }

    private void sc(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.cKE = i / i2;
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
        return this.mType == 1 ? this.cKz == 1 || this.cKz == 4 || this.cKz == 2 || this.cKz == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
