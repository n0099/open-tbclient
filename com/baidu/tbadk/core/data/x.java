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
    private int bFM;
    private String bFN;
    private int bFO;
    private String bFP;
    public String bFQ;
    public float bFR;
    public boolean bFS = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int abT() {
        return this.bFM;
    }

    public String abU() {
        return this.bFN;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String abK() {
        return this.bFP;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bFM = jSONObject.optInt("bannerType");
                this.bFN = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
                this.mType = jSONObject.optInt("type");
                this.aYJ = jSONObject.optString("desc");
                this.bFO = jSONObject.optInt("template_id");
                this.bFP = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.bFQ = jSONObject.optString("tag_name_url");
                mf(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.bFM = banner.banner_type.intValue();
            this.bFN = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aYJ = banner.desc;
            this.bFO = banner.template_id.intValue();
            this.bFP = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.bFQ = banner.tag_name_url;
            mf(banner.tag_name_wh);
        }
    }

    private void mf(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int f = com.baidu.adp.lib.g.b.f(split[0], 1);
                    int f2 = com.baidu.adp.lib.g.b.f(split[1], 1);
                    if (f2 != 0) {
                        this.bFR = f / f2;
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
        return this.mType == 1 ? this.bFM == 1 || this.bFM == 4 || this.bFM == 2 || this.bFM == 3 : this.mType == 2 && !StringUtils.isNull(this.aYJ);
    }
}
