package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class ab {
    private int dIH;
    private String dII;
    private int dIJ;
    private String dIK;
    public String dIL;
    public float dIM;
    public boolean dIN = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int aQB() {
        return this.dIH;
    }

    public String aQC() {
        return this.dII;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String aQu() {
        return this.dIK;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dIH = jSONObject.optInt("bannerType");
                this.dII = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.dIJ = jSONObject.optInt("template_id");
                this.dIK = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.dIL = jSONObject.optString("tag_name_url");
                vF(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.dIH = banner.banner_type.intValue();
            this.dII = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.dIJ = banner.template_id.intValue();
            this.dIK = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.dIL = banner.tag_name_url;
            vF(banner.tag_name_wh);
        }
    }

    private void vF(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.dIM = i / i2;
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
        return this.mType == 1 ? this.dIH == 1 || this.dIH == 4 || this.dIH == 2 || this.dIH == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
