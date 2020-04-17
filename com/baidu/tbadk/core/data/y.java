package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class y {
    private int doi;
    private String doj;
    private int dok;
    private String dol;
    public String dom;
    public float don;
    public boolean doo = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int aIX() {
        return this.doi;
    }

    public String aIY() {
        return this.doj;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String aIO() {
        return this.dol;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.doi = jSONObject.optInt("bannerType");
                this.doj = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.dok = jSONObject.optInt("template_id");
                this.dol = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.dom = jSONObject.optString("tag_name_url");
                tJ(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.doi = banner.banner_type.intValue();
            this.doj = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.dok = banner.template_id.intValue();
            this.dol = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.dom = banner.tag_name_url;
            tJ(banner.tag_name_wh);
        }
    }

    private void tJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.don = i / i2;
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
        return this.mType == 1 ? this.doi == 1 || this.doi == 4 || this.doi == 2 || this.doi == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
