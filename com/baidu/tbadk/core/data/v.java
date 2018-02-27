package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class v {
    private int aMm;
    private String aMn;
    private String aMo;
    private int aMp;
    private String aMq;
    public String aMr;
    public float aMs;
    public boolean aMt = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int yb() {
        return this.aMm;
    }

    public String yc() {
        return this.aMn;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String yd() {
        return this.aMq;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aMm = jSONObject.optInt("bannerType");
                this.aMn = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.aMo = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
                this.aMp = jSONObject.optInt("template_id");
                this.aMq = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.aMr = jSONObject.optString("tag_name_url");
                cT(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.aMm = banner.banner_type.intValue();
            this.aMn = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aMo = banner.desc;
            this.aMp = banner.template_id.intValue();
            this.aMq = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.aMr = banner.tag_name_url;
            cT(banner.tag_name_wh);
        }
    }

    private void cT(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int h = com.baidu.adp.lib.g.b.h(split[0], 1);
                    int h2 = com.baidu.adp.lib.g.b.h(split[1], 1);
                    if (h2 != 0) {
                        this.aMs = h / h2;
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
        return this.mType == 1 ? this.aMm == 1 || this.aMm == 4 || this.aMm == 2 || this.aMm == 3 : this.mType == 2 && !StringUtils.isNull(this.aMo);
    }
}
