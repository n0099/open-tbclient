package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private int bYY;
    private String bYZ;
    private int bZa;
    private String bZb;
    public String bZc;
    public float bZd;
    public boolean bZe = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int ahg() {
        return this.bYY;
    }

    public String ahh() {
        return this.bYZ;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String agX() {
        return this.bZb;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bYY = jSONObject.optInt("bannerType");
                this.bYZ = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.bZa = jSONObject.optInt("template_id");
                this.bZb = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.bZc = jSONObject.optString("tag_name_url");
                mO(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.bYY = banner.banner_type.intValue();
            this.bYZ = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.bZa = banner.template_id.intValue();
            this.bZb = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.bZc = banner.tag_name_url;
            mO(banner.tag_name_wh);
        }
    }

    private void mO(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.g.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.g.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.bZd = i / i2;
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
        return this.mType == 1 ? this.bYY == 1 || this.bYY == 4 || this.bYY == 2 || this.bYY == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
