package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class y {
    private int cKK;
    private String cKL;
    private int cKM;
    private String cKN;
    public String cKO;
    public float cKP;
    public boolean cKQ = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int ayr() {
        return this.cKK;
    }

    public String ays() {
        return this.cKL;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String ayi() {
        return this.cKN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cKK = jSONObject.optInt("bannerType");
                this.cKL = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.cKM = jSONObject.optInt("template_id");
                this.cKN = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.cKO = jSONObject.optString("tag_name_url");
                sf(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.cKK = banner.banner_type.intValue();
            this.cKL = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.cKM = banner.template_id.intValue();
            this.cKN = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.cKO = banner.tag_name_url;
            sf(banner.tag_name_wh);
        }
    }

    private void sf(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.cKP = i / i2;
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
        return this.mType == 1 ? this.cKK == 1 || this.cKK == 4 || this.cKK == 2 || this.cKK == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
