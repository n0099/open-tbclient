package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class y {
    private int cPc;
    private String cPd;
    private int cPe;
    private String cPf;
    public String cPg;
    public float cPh;
    public boolean cPi = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int aAK() {
        return this.cPc;
    }

    public String aAL() {
        return this.cPd;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String aAB() {
        return this.cPf;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cPc = jSONObject.optInt("bannerType");
                this.cPd = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.cPe = jSONObject.optInt("template_id");
                this.cPf = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.cPg = jSONObject.optString("tag_name_url");
                sv(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.cPc = banner.banner_type.intValue();
            this.cPd = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.cPe = banner.template_id.intValue();
            this.cPf = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.cPg = banner.tag_name_url;
            sv(banner.tag_name_wh);
        }
    }

    private void sv(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.cPh = i / i2;
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
        return this.mType == 1 ? this.cPc == 1 || this.cPc == 4 || this.cPc == 2 || this.cPc == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
