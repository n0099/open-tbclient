package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class y {
    private int UT;
    private String UU;
    private int UV;
    private String UW;
    public String UX;
    public float UY;
    public boolean UZ = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pJ() {
        return this.UT;
    }

    public String pK() {
        return this.UU;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pL() {
        return this.UW;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.UT = jSONObject.optInt("bannerType");
                this.UU = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.UV = jSONObject.optInt("template_id");
                this.UW = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.UX = jSONObject.optString("tag_name_url");
                cs(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.UT = banner.banner_type.intValue();
            this.UU = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.UV = banner.template_id.intValue();
            this.UW = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.UX = banner.tag_name_url;
            cs(banner.tag_name_wh);
        }
    }

    private void cs(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.UY = g / g2;
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
        return this.mType == 1 ? this.UT == 1 || this.UT == 4 || this.UT == 2 || this.UT == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
