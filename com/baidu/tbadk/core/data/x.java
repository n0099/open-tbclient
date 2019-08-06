package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.ubc.UBC;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private String aZt;
    private int bGP;
    private String bGQ;
    private int bGR;
    private String bGS;
    public String bGT;
    public float bGU;
    public boolean bGV = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int acW() {
        return this.bGP;
    }

    public String acX() {
        return this.bGQ;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String acN() {
        return this.bGS;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bGP = jSONObject.optInt("bannerType");
                this.bGQ = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
                this.mType = jSONObject.optInt("type");
                this.aZt = jSONObject.optString("desc");
                this.bGR = jSONObject.optInt("template_id");
                this.bGS = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.bGT = jSONObject.optString("tag_name_url");
                mp(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.bGP = banner.banner_type.intValue();
            this.bGQ = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aZt = banner.desc;
            this.bGR = banner.template_id.intValue();
            this.bGS = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.bGT = banner.tag_name_url;
            mp(banner.tag_name_wh);
        }
    }

    private void mp(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int f = com.baidu.adp.lib.g.b.f(split[0], 1);
                    int f2 = com.baidu.adp.lib.g.b.f(split[1], 1);
                    if (f2 != 0) {
                        this.bGU = f / f2;
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
        return this.mType == 1 ? this.bGP == 1 || this.bGP == 4 || this.bGP == 2 || this.bGP == 3 : this.mType == 2 && !StringUtils.isNull(this.aZt);
    }
}
