package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class u {
    private int WE;
    private String WF;
    private String WG;
    private int WH;
    private String WI;
    public String WJ;
    public float WK;
    public boolean WL = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pS() {
        return this.WE;
    }

    public String pT() {
        return this.WF;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pU() {
        return this.WI;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.WE = jSONObject.optInt("bannerType");
                this.WF = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.WG = jSONObject.optString("desc");
                this.WH = jSONObject.optInt("template_id");
                this.WI = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.WJ = jSONObject.optString("tag_name_url");
                cB(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.WE = banner.banner_type.intValue();
            this.WF = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.WG = banner.desc;
            this.WH = banner.template_id.intValue();
            this.WI = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.WJ = banner.tag_name_url;
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
                        this.WK = g / g2;
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
        return this.mType == 1 ? this.WE == 1 || this.WE == 4 || this.WE == 2 || this.WE == 3 : this.mType == 2 && !StringUtils.isNull(this.WG);
    }
}
