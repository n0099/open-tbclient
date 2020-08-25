package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes2.dex */
public class ad {
    private int dYl;
    private String dYm;
    private int dYn;
    private String dYo;
    public String dYp;
    public float dYq;
    public boolean dYr = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int bcQ() {
        return this.dYl;
    }

    public String bcR() {
        return this.dYm;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String bcJ() {
        return this.dYo;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dYl = jSONObject.optInt("bannerType");
                this.dYm = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.dYn = jSONObject.optInt("template_id");
                this.dYo = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.dYp = jSONObject.optString("tag_name_url");
                za(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.dYl = banner.banner_type.intValue();
            this.dYm = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.dYn = banner.template_id.intValue();
            this.dYo = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.dYp = banner.tag_name_url;
            za(banner.tag_name_wh);
        }
    }

    private void za(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.dYq = i / i2;
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
        return this.mType == 1 ? this.dYl == 1 || this.dYl == 4 || this.dYl == 2 || this.dYl == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
