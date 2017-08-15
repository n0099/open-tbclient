package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private int WH;
    private String WI;
    private int WJ;
    private String WK;
    public String WL;
    public float WM;
    public boolean WN = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pW() {
        return this.WH;
    }

    public String pX() {
        return this.WI;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pY() {
        return this.WK;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.WH = jSONObject.optInt("bannerType");
                this.WI = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.WJ = jSONObject.optInt("template_id");
                this.WK = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.WL = jSONObject.optString("tag_name_url");
                cD(jSONObject.optString("tag_name_wh"));
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
            this.mDesc = banner.desc;
            this.WJ = banner.template_id.intValue();
            this.WK = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.WL = banner.tag_name_url;
            cD(banner.tag_name_wh);
        }
    }

    private void cD(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.WM = g / g2;
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
        return this.mType == 1 ? this.WH == 1 || this.WH == 4 || this.WH == 2 || this.WH == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
