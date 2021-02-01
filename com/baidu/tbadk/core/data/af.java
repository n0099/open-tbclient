package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class af {
    private int eNB;
    private String eNC;
    private int eND;
    private String eNE;
    public String eNF;
    public float eNG;
    public boolean eNH = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int blZ() {
        return this.eNB;
    }

    public String bma() {
        return this.eNC;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String blS() {
        return this.eNE;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eNB = jSONObject.optInt("bannerType");
                this.eNC = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.eND = jSONObject.optInt("template_id");
                this.eNE = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.eNF = jSONObject.optString("tag_name_url");
                zU(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.eNB = banner.banner_type.intValue();
            this.eNC = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.eND = banner.template_id.intValue();
            this.eNE = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.eNF = banner.tag_name_url;
            zU(banner.tag_name_wh);
        }
    }

    private void zU(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.eNG = i / i2;
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
        return this.mType == 1 ? this.eNB == 1 || this.eNB == 4 || this.eNB == 2 || this.eNB == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
