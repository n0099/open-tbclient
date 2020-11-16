package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class ae {
    private int ezl;
    private String ezm;
    private int ezn;
    private String ezo;
    public String ezp;
    public float ezq;
    public boolean ezr = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int bjO() {
        return this.ezl;
    }

    public String bjP() {
        return this.ezm;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String bjH() {
        return this.ezo;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ezl = jSONObject.optInt("bannerType");
                this.ezm = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.ezn = jSONObject.optInt("template_id");
                this.ezo = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.ezp = jSONObject.optString("tag_name_url");
                Ak(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.ezl = banner.banner_type.intValue();
            this.ezm = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.ezn = banner.template_id.intValue();
            this.ezo = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.ezp = banner.tag_name_url;
            Ak(banner.tag_name_wh);
        }
    }

    private void Ak(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.ezq = i / i2;
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
        return this.mType == 1 ? this.ezl == 1 || this.ezl == 4 || this.ezl == 2 || this.ezl == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
