package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    public float VA;
    private int Vu;
    private String Vv;
    private String Vw;
    private int Vx;
    private String Vy;
    public String Vz;
    private String mTagName;
    private int mType;
    private String mValue;

    public int qg() {
        return this.Vu;
    }

    public String qh() {
        return this.Vv;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pL() {
        return this.Vy;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vu = jSONObject.optInt("bannerType");
                this.Vv = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.Vw = jSONObject.optString("desc");
                this.Vx = jSONObject.optInt("template_id");
                this.Vy = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.Vz = jSONObject.optString("tag_name_url");
                cf(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.Vu = banner.banner_type.intValue();
            this.Vv = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.Vw = banner.desc;
            this.Vx = banner.template_id.intValue();
            this.Vy = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.Vz = banner.tag_name_url;
            cf(banner.tag_name_wh);
        }
    }

    private void cf(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.VA = g / g2;
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
        return this.mType == 1 ? this.Vu == 1 || this.Vu == 4 || this.Vu == 2 || this.Vu == 3 : this.mType == 2 && !StringUtils.isNull(this.Vw);
    }
}
