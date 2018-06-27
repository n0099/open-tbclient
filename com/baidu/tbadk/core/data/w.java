package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class w {
    private int afZ;
    private String aga;
    private String agb;
    private int agc;
    private String agd;
    public String agf;
    public float agg;
    public boolean agh = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int ui() {
        return this.afZ;
    }

    public String uj() {
        return this.aga;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String uk() {
        return this.agd;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.afZ = jSONObject.optInt("bannerType");
                this.aga = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.agb = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
                this.agc = jSONObject.optInt("template_id");
                this.agd = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.agf = jSONObject.optString("tag_name_url");
                di(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.afZ = banner.banner_type.intValue();
            this.aga = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.agb = banner.desc;
            this.agc = banner.template_id.intValue();
            this.agd = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.agf = banner.tag_name_url;
            di(banner.tag_name_wh);
        }
    }

    private void di(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.agg = g / g2;
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
        return this.mType == 1 ? this.afZ == 1 || this.afZ == 4 || this.afZ == 2 || this.afZ == 3 : this.mType == 2 && !StringUtils.isNull(this.agb);
    }
}
