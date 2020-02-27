package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class y {
    private int cON;
    private String cOO;
    private int cOP;
    private String cOQ;
    public String cOR;
    public float cOS;
    public boolean cOT = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int aAF() {
        return this.cON;
    }

    public String aAG() {
        return this.cOO;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String aAw() {
        return this.cOQ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cON = jSONObject.optInt("bannerType");
                this.cOO = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.cOP = jSONObject.optInt("template_id");
                this.cOQ = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.cOR = jSONObject.optString("tag_name_url");
                sw(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.cON = banner.banner_type.intValue();
            this.cOO = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.cOP = banner.template_id.intValue();
            this.cOQ = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.cOR = banner.tag_name_url;
            sw(banner.tag_name_wh);
        }
    }

    private void sw(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.cOS = i / i2;
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
        return this.mType == 1 ? this.cON == 1 || this.cON == 4 || this.cON == 2 || this.cON == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
