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
    private int aMn;
    private String aMo;
    private String aMp;
    private int aMq;
    private String aMr;
    public String aMs;
    public float aMt;
    public boolean aMu = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int yb() {
        return this.aMn;
    }

    public String yc() {
        return this.aMo;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String yd() {
        return this.aMr;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aMn = jSONObject.optInt("bannerType");
                this.aMo = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.aMp = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
                this.aMq = jSONObject.optInt("template_id");
                this.aMr = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.aMs = jSONObject.optString("tag_name_url");
                cT(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.aMn = banner.banner_type.intValue();
            this.aMo = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aMp = banner.desc;
            this.aMq = banner.template_id.intValue();
            this.aMr = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.aMs = banner.tag_name_url;
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
                        this.aMt = h / h2;
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
        return this.mType == 1 ? this.aMn == 1 || this.aMn == 4 || this.aMn == 2 || this.aMn == 3 : this.mType == 2 && !StringUtils.isNull(this.aMp);
    }
}
