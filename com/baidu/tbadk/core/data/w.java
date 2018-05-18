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
    private int XJ;
    private String XK;
    private String XL;
    private int XM;
    private String XN;
    public String XO;
    public float XP;
    public boolean XQ = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int qG() {
        return this.XJ;
    }

    public String qH() {
        return this.XK;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String qI() {
        return this.XN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.XJ = jSONObject.optInt("bannerType");
                this.XK = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.XL = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
                this.XM = jSONObject.optInt("template_id");
                this.XN = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.XO = jSONObject.optString("tag_name_url");
                cH(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.XJ = banner.banner_type.intValue();
            this.XK = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.XL = banner.desc;
            this.XM = banner.template_id.intValue();
            this.XN = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.XO = banner.tag_name_url;
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
                        this.XP = g / g2;
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
        return this.mType == 1 ? this.XJ == 1 || this.XJ == 4 || this.XJ == 2 || this.XJ == 3 : this.mType == 2 && !StringUtils.isNull(this.XL);
    }
}
