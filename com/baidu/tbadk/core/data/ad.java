package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class ad {
    private int evb;
    private String evc;
    private int evd;
    private String eve;
    public String evf;
    public float evg;
    public boolean evh = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int bim() {
        return this.evb;
    }

    public String bin() {
        return this.evc;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String bif() {
        return this.eve;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.evb = jSONObject.optInt("bannerType");
                this.evc = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.evd = jSONObject.optInt("template_id");
                this.eve = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.evf = jSONObject.optString("tag_name_url");
                AB(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.evb = banner.banner_type.intValue();
            this.evc = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.evd = banner.template_id.intValue();
            this.eve = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.evf = banner.tag_name_url;
            AB(banner.tag_name_wh);
        }
    }

    private void AB(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.evg = i / i2;
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
        return this.mType == 1 ? this.evb == 1 || this.evb == 4 || this.evb == 2 || this.evb == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
