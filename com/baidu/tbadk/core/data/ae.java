package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class ae {
    private int eGk;
    private String eGl;
    private int eGm;
    private String eGn;
    public String eGo;
    public float eGp;
    public boolean eGq = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int bnb() {
        return this.eGk;
    }

    public String bnc() {
        return this.eGl;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String bmU() {
        return this.eGn;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eGk = jSONObject.optInt("bannerType");
                this.eGl = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.eGm = jSONObject.optInt("template_id");
                this.eGn = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.eGo = jSONObject.optString("tag_name_url");
                AR(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.eGk = banner.banner_type.intValue();
            this.eGl = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.eGm = banner.template_id.intValue();
            this.eGn = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.eGo = banner.tag_name_url;
            AR(banner.tag_name_wh);
        }
    }

    private void AR(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.eGp = i / i2;
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
        return this.mType == 1 ? this.eGk == 1 || this.eGk == 4 || this.eGk == 2 || this.eGk == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
