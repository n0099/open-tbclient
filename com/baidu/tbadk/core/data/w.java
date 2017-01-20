package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class w {
    private int Qh;
    private String Qi;
    private String Qj;
    private int Qk;
    private String Ql;
    public String Qm;
    public float Qn;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pO() {
        return this.Qh;
    }

    public String pP() {
        return this.Qi;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pt() {
        return this.Ql;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Qh = jSONObject.optInt("bannerType");
                this.Qi = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.Qj = jSONObject.optString("desc");
                this.Qk = jSONObject.optInt("template_id");
                this.Ql = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.Qm = jSONObject.optString("tag_name_url");
                cm(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.Qh = banner.banner_type.intValue();
            this.Qi = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.Qj = banner.desc;
            this.Qk = banner.template_id.intValue();
            this.Ql = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.Qm = banner.tag_name_url;
            cm(banner.tag_name_wh);
        }
    }

    private void cm(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.Qn = g / g2;
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
        return this.mType == 1 ? this.Qh == 1 || this.Qh == 4 || this.Qh == 2 || this.Qh == 3 : this.mType == 2 && !StringUtils.isNull(this.Qj);
    }
}
