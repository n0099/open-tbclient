package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private int dCm;
    private String dCn;
    private int dCo;
    private String dCp;
    public String dCq;
    public float dCr;
    public boolean dCs = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int aOQ() {
        return this.dCm;
    }

    public String aOR() {
        return this.dCn;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String aOH() {
        return this.dCp;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dCm = jSONObject.optInt("bannerType");
                this.dCn = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.dCo = jSONObject.optInt("template_id");
                this.dCp = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.dCq = jSONObject.optString("tag_name_url");
                vs(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.dCm = banner.banner_type.intValue();
            this.dCn = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.dCo = banner.template_id.intValue();
            this.dCp = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.dCq = banner.tag_name_url;
            vs(banner.tag_name_wh);
        }
    }

    private void vs(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.dCr = i / i2;
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
        return this.mType == 1 ? this.dCm == 1 || this.dCm == 4 || this.dCm == 2 || this.dCm == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
