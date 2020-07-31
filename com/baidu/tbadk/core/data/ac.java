package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class ac {
    private int dOS;
    private String dOT;
    private int dOU;
    private String dOV;
    public String dOW;
    public float dOX;
    public boolean dOY = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int aUx() {
        return this.dOS;
    }

    public String aUy() {
        return this.dOT;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String aUq() {
        return this.dOV;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dOS = jSONObject.optInt("bannerType");
                this.dOT = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.dOU = jSONObject.optInt("template_id");
                this.dOV = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.dOW = jSONObject.optString("tag_name_url");
                wM(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.dOS = banner.banner_type.intValue();
            this.dOT = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.dOU = banner.template_id.intValue();
            this.dOV = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.dOW = banner.tag_name_url;
            wM(banner.tag_name_wh);
        }
    }

    private void wM(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.dOX = i / i2;
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
        return this.mType == 1 ? this.dOS == 1 || this.dOS == 4 || this.dOS == 2 || this.dOS == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
