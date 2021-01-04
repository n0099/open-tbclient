package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class ae {
    private int eQa;
    private String eQb;
    private int eQc;
    private String eQd;
    public String eQe;
    public float eQf;
    public boolean eQg = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int bpA() {
        return this.eQa;
    }

    public String bpB() {
        return this.eQb;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String bpt() {
        return this.eQd;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eQa = jSONObject.optInt("bannerType");
                this.eQb = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.eQc = jSONObject.optInt("template_id");
                this.eQd = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.eQe = jSONObject.optString("tag_name_url");
                AP(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.eQa = banner.banner_type.intValue();
            this.eQb = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.eQc = banner.template_id.intValue();
            this.eQd = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.eQe = banner.tag_name_url;
            AP(banner.tag_name_wh);
        }
    }

    private void AP(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.eQf = i / i2;
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
        return this.mType == 1 ? this.eQa == 1 || this.eQa == 4 || this.eQa == 2 || this.eQa == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
