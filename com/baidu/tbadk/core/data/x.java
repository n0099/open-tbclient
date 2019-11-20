package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private int bYh;
    private String bYi;
    private int bYj;
    private String bYk;
    public String bYl;
    public float bYm;
    public boolean bYn = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int ahe() {
        return this.bYh;
    }

    public String ahf() {
        return this.bYi;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String agV() {
        return this.bYk;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bYh = jSONObject.optInt("bannerType");
                this.bYi = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.bYj = jSONObject.optInt("template_id");
                this.bYk = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.bYl = jSONObject.optString("tag_name_url");
                mO(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.bYh = banner.banner_type.intValue();
            this.bYi = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.bYj = banner.template_id.intValue();
            this.bYk = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.bYl = banner.tag_name_url;
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
                        this.bYm = i / i2;
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
        return this.mType == 1 ? this.bYh == 1 || this.bYh == 4 || this.bYh == 2 || this.bYh == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
