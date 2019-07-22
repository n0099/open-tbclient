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
    private int bGO;
    private String bGP;
    private int bGQ;
    private String bGR;
    public String bGS;
    public float bGT;
    public boolean bGU = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int acV() {
        return this.bGO;
    }

    public String acW() {
        return this.bGP;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String acM() {
        return this.bGR;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bGO = jSONObject.optInt("bannerType");
                this.bGP = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
                this.mType = jSONObject.optInt("type");
                this.aZt = jSONObject.optString("desc");
                this.bGQ = jSONObject.optInt("template_id");
                this.bGR = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.bGS = jSONObject.optString("tag_name_url");
                mp(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.bGO = banner.banner_type.intValue();
            this.bGP = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aZt = banner.desc;
            this.bGQ = banner.template_id.intValue();
            this.bGR = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.bGS = banner.tag_name_url;
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
                        this.bGT = f / f2;
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
        return this.mType == 1 ? this.bGO == 1 || this.bGO == 4 || this.bGO == 2 || this.bGO == 3 : this.mType == 2 && !StringUtils.isNull(this.aZt);
    }
}
