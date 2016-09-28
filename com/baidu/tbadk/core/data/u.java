package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class u {
    private int QF;
    private String QG;
    private String QH;
    private int QI;
    private String QJ;
    public String QK;
    public float QL;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pR() {
        return this.QF;
    }

    public String pS() {
        return this.QG;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String px() {
        return this.QJ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.QF = jSONObject.optInt("bannerType");
                this.QG = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.QH = jSONObject.optString("desc");
                this.QI = jSONObject.optInt("template_id");
                this.QJ = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.QK = jSONObject.optString("tag_name_url");
                String optString = jSONObject.optString("tag_name_wh");
                if (optString != null) {
                    try {
                        String[] split = optString.split(",");
                        int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                        int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                        if (g2 != 0) {
                            this.QL = g / g2;
                        }
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.QF = banner.banner_type.intValue();
            this.QG = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.QH = banner.desc;
            this.QI = banner.template_id.intValue();
            this.QJ = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.QK = banner.tag_name_url;
            String str = banner.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.QL = g / g2;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    public boolean isValid() {
        if (StringUtils.isNull(this.mValue)) {
            return false;
        }
        return this.mType == 1 ? this.QF == 1 || this.QF == 4 || this.QF == 2 || this.QF == 3 : this.mType == 2 && !StringUtils.isNull(this.QH);
    }
}
