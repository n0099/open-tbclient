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
    private String aYJ;
    private int bFN;
    private String bFO;
    private int bFP;
    private String bFQ;
    public String bFR;
    public float bFS;
    public boolean bFT = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int abT() {
        return this.bFN;
    }

    public String abU() {
        return this.bFO;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String abK() {
        return this.bFQ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bFN = jSONObject.optInt("bannerType");
                this.bFO = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
                this.mType = jSONObject.optInt("type");
                this.aYJ = jSONObject.optString("desc");
                this.bFP = jSONObject.optInt("template_id");
                this.bFQ = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.bFR = jSONObject.optString("tag_name_url");
                me(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.bFN = banner.banner_type.intValue();
            this.bFO = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aYJ = banner.desc;
            this.bFP = banner.template_id.intValue();
            this.bFQ = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.bFR = banner.tag_name_url;
            me(banner.tag_name_wh);
        }
    }

    private void me(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int f = com.baidu.adp.lib.g.b.f(split[0], 1);
                    int f2 = com.baidu.adp.lib.g.b.f(split[1], 1);
                    if (f2 != 0) {
                        this.bFS = f / f2;
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
        return this.mType == 1 ? this.bFN == 1 || this.bFN == 4 || this.bFN == 2 || this.bFN == 3 : this.mType == 2 && !StringUtils.isNull(this.aYJ);
    }
}
