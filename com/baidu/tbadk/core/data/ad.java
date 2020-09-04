package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class ad {
    private int dYp;
    private String dYq;
    private int dYr;
    private String dYs;
    public String dYt;
    public float dYu;
    public boolean dYv = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int bcQ() {
        return this.dYp;
    }

    public String bcR() {
        return this.dYq;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String bcJ() {
        return this.dYs;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dYp = jSONObject.optInt("bannerType");
                this.dYq = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.dYr = jSONObject.optInt("template_id");
                this.dYs = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.dYt = jSONObject.optString("tag_name_url");
                zb(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.dYp = banner.banner_type.intValue();
            this.dYq = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.dYr = banner.template_id.intValue();
            this.dYs = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.dYt = banner.tag_name_url;
            zb(banner.tag_name_wh);
        }
    }

    private void zb(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.dYu = i / i2;
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
        return this.mType == 1 ? this.dYp == 1 || this.dYp == 4 || this.dYp == 2 || this.dYp == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
