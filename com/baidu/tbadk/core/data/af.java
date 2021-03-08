package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class af {
    private int ePc;
    private String ePd;
    private int ePe;
    private String ePf;
    public String ePg;
    public float ePh;
    public boolean ePi = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int bmb() {
        return this.ePc;
    }

    public String bmc() {
        return this.ePd;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String blU() {
        return this.ePf;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ePc = jSONObject.optInt("bannerType");
                this.ePd = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.ePe = jSONObject.optInt("template_id");
                this.ePf = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.ePg = jSONObject.optString("tag_name_url");
                Ab(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.ePc = banner.banner_type.intValue();
            this.ePd = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.ePe = banner.template_id.intValue();
            this.ePf = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.ePg = banner.tag_name_url;
            Ab(banner.tag_name_wh);
        }
    }

    private void Ab(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.ePh = i / i2;
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
        return this.mType == 1 ? this.ePc == 1 || this.ePc == 4 || this.ePc == 2 || this.ePc == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
