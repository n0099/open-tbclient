package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class u {
    private int WH;
    private String WI;
    private String WJ;
    private int WK;
    private String WL;
    public String WM;
    public float WN;
    public boolean WO = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pU() {
        return this.WH;
    }

    public String pV() {
        return this.WI;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pW() {
        return this.WL;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.WH = jSONObject.optInt("bannerType");
                this.WI = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.WJ = jSONObject.optString("desc");
                this.WK = jSONObject.optInt("template_id");
                this.WL = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.WM = jSONObject.optString("tag_name_url");
                cB(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.WH = banner.banner_type.intValue();
            this.WI = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.WJ = banner.desc;
            this.WK = banner.template_id.intValue();
            this.WL = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.WM = banner.tag_name_url;
            cB(banner.tag_name_wh);
        }
    }

    private void cB(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.WN = g / g2;
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
        return this.mType == 1 ? this.WH == 1 || this.WH == 4 || this.WH == 2 || this.WH == 3 : this.mType == 2 && !StringUtils.isNull(this.WJ);
    }
}
