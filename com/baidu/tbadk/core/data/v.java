package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class v {
    private int QY;
    private String QZ;
    private String Ra;
    private int Rb;
    private String Rc;
    public String Rd;
    public float Re;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pV() {
        return this.QY;
    }

    public String pW() {
        return this.QZ;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pA() {
        return this.Rc;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.QY = jSONObject.optInt("bannerType");
                this.QZ = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.Ra = jSONObject.optString("desc");
                this.Rb = jSONObject.optInt("template_id");
                this.Rc = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.Rd = jSONObject.optString("tag_name_url");
                co(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.QY = banner.banner_type.intValue();
            this.QZ = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.Ra = banner.desc;
            this.Rb = banner.template_id.intValue();
            this.Rc = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.Rd = banner.tag_name_url;
            co(banner.tag_name_wh);
        }
    }

    private void co(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.Re = g / g2;
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
        return this.mType == 1 ? this.QY == 1 || this.QY == 4 || this.QY == 2 || this.QY == 3 : this.mType == 2 && !StringUtils.isNull(this.Ra);
    }
}
