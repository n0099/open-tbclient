package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private int VQ;
    private String VR;
    private String VS;
    private int VT;
    private String VU;
    public String VV;
    public float VW;
    public boolean VX = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pS() {
        return this.VQ;
    }

    public String pT() {
        return this.VR;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pU() {
        return this.VU;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VQ = jSONObject.optInt("bannerType");
                this.VR = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.VS = jSONObject.optString("desc");
                this.VT = jSONObject.optInt("template_id");
                this.VU = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.VV = jSONObject.optString("tag_name_url");
                cw(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.VQ = banner.banner_type.intValue();
            this.VR = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.VS = banner.desc;
            this.VT = banner.template_id.intValue();
            this.VU = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.VV = banner.tag_name_url;
            cw(banner.tag_name_wh);
        }
    }

    private void cw(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.VW = g / g2;
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
        return this.mType == 1 ? this.VQ == 1 || this.VQ == 4 || this.VQ == 2 || this.VQ == 3 : this.mType == 2 && !StringUtils.isNull(this.VS);
    }
}
