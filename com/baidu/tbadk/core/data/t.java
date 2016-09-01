package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class t {
    private int QB;
    private String QC;
    private String QD;
    private int QE;
    private String QF;
    private String QG;
    public String QH;
    public float QI;
    private int mType;
    private String mValue;

    public int pG() {
        return this.QB;
    }

    public String pH() {
        return this.QC;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pw() {
        return this.QF;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.QB = jSONObject.optInt("bannerType");
                this.QC = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.QD = jSONObject.optString("desc");
                this.QE = jSONObject.optInt("template_id");
                this.QF = jSONObject.optString("obj_id");
                this.QG = jSONObject.optString("tag_name");
                this.QH = jSONObject.optString("tag_name_url");
                String optString = jSONObject.optString("tag_name_wh");
                if (optString != null) {
                    try {
                        String[] split = optString.split(",");
                        int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                        int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                        if (g2 != 0) {
                            this.QI = g / g2;
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
            this.QB = banner.banner_type.intValue();
            this.QC = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.QD = banner.desc;
            this.QE = banner.template_id.intValue();
            this.QF = banner.obj_id;
            this.QG = banner.tag_name;
            this.QH = banner.tag_name_url;
            String str = banner.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.QI = g / g2;
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
        return this.mType == 1 ? this.QB == 1 || this.QB == 4 || this.QB == 2 || this.QB == 3 : this.mType == 2 && !StringUtils.isNull(this.QD);
    }
}
