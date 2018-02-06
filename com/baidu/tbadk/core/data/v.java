package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class v {
    private int aMA;
    private String aMB;
    public String aMC;
    public float aMD;
    public boolean aME = true;
    private int aMx;
    private String aMy;
    private String aMz;
    private String mTagName;
    private int mType;
    private String mValue;

    public int yb() {
        return this.aMx;
    }

    public String yc() {
        return this.aMy;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String yd() {
        return this.aMB;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aMx = jSONObject.optInt("bannerType");
                this.aMy = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.aMz = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
                this.aMA = jSONObject.optInt("template_id");
                this.aMB = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.aMC = jSONObject.optString("tag_name_url");
                cT(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.aMx = banner.banner_type.intValue();
            this.aMy = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aMz = banner.desc;
            this.aMA = banner.template_id.intValue();
            this.aMB = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.aMC = banner.tag_name_url;
            cT(banner.tag_name_wh);
        }
    }

    private void cT(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int h = com.baidu.adp.lib.g.b.h(split[0], 1);
                    int h2 = com.baidu.adp.lib.g.b.h(split[1], 1);
                    if (h2 != 0) {
                        this.aMD = h / h2;
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
        return this.mType == 1 ? this.aMx == 1 || this.aMx == 4 || this.aMx == 2 || this.aMx == 3 : this.mType == 2 && !StringUtils.isNull(this.aMz);
    }
}
