package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class v {
    public boolean afA = true;
    private int aft;
    private String afu;
    private String afv;
    private int afw;
    private String afx;
    public String afy;
    public float afz;
    private String mTagName;
    private int mType;
    private String mValue;

    public int tU() {
        return this.aft;
    }

    public String tV() {
        return this.afu;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String tW() {
        return this.afx;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aft = jSONObject.optInt("bannerType");
                this.afu = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.afv = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
                this.afw = jSONObject.optInt("template_id");
                this.afx = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.afy = jSONObject.optString("tag_name_url");
                dg(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.aft = banner.banner_type.intValue();
            this.afu = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.afv = banner.desc;
            this.afw = banner.template_id.intValue();
            this.afx = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.afy = banner.tag_name_url;
            dg(banner.tag_name_wh);
        }
    }

    private void dg(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.afz = g / g2;
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
        return this.mType == 1 ? this.aft == 1 || this.aft == 4 || this.aft == 2 || this.aft == 3 : this.mType == 2 && !StringUtils.isNull(this.afv);
    }
}
