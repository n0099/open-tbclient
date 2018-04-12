package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class w {
    private int XI;
    private String XJ;
    private String XK;
    private int XL;
    private String XM;
    public String XN;
    public float XO;
    public boolean XP = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int qH() {
        return this.XI;
    }

    public String qI() {
        return this.XJ;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String qJ() {
        return this.XM;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.XI = jSONObject.optInt("bannerType");
                this.XJ = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.XK = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
                this.XL = jSONObject.optInt("template_id");
                this.XM = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.XN = jSONObject.optString("tag_name_url");
                cH(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.XI = banner.banner_type.intValue();
            this.XJ = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.XK = banner.desc;
            this.XL = banner.template_id.intValue();
            this.XM = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.XN = banner.tag_name_url;
            cH(banner.tag_name_wh);
        }
    }

    private void cH(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.XO = g / g2;
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
        return this.mType == 1 ? this.XI == 1 || this.XI == 4 || this.XI == 2 || this.XI == 3 : this.mType == 2 && !StringUtils.isNull(this.XK);
    }
}
