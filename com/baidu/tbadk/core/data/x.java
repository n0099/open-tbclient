package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private int Vh;
    private String Vi;
    private int Vj;
    private String Vk;
    public String Vl;
    public float Vm;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pU() {
        return this.Vh;
    }

    public String pV() {
        return this.Vi;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pW() {
        return this.Vk;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vh = jSONObject.optInt("bannerType");
                this.Vi = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.Vj = jSONObject.optInt("template_id");
                this.Vk = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.Vl = jSONObject.optString("tag_name_url");
                cm(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.Vh = banner.banner_type.intValue();
            this.Vi = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.Vj = banner.template_id.intValue();
            this.Vk = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.Vl = banner.tag_name_url;
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
                        this.Vm = g / g2;
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
        return this.mType == 1 ? this.Vh == 1 || this.Vh == 4 || this.Vh == 2 || this.Vh == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
