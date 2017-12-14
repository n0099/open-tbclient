package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class u {
    private int WB;
    private String WC;
    private String WD;
    private int WE;
    private String WF;
    public String WG;
    public float WH;
    public boolean WI = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pS() {
        return this.WB;
    }

    public String pT() {
        return this.WC;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pU() {
        return this.WF;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.WB = jSONObject.optInt("bannerType");
                this.WC = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.WD = jSONObject.optString("desc");
                this.WE = jSONObject.optInt("template_id");
                this.WF = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.WG = jSONObject.optString("tag_name_url");
                cB(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.WB = banner.banner_type.intValue();
            this.WC = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.WD = banner.desc;
            this.WE = banner.template_id.intValue();
            this.WF = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.WG = banner.tag_name_url;
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
                        this.WH = g / g2;
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
        return this.mType == 1 ? this.WB == 1 || this.WB == 4 || this.WB == 2 || this.WB == 3 : this.mType == 2 && !StringUtils.isNull(this.WD);
    }
}
