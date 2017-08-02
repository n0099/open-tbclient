package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private int Vj;
    private String Vk;
    private int Vl;
    private String Vm;
    public String Vn;
    public float Vo;
    public boolean Vp = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pM() {
        return this.Vj;
    }

    public String pN() {
        return this.Vk;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pO() {
        return this.Vm;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vj = jSONObject.optInt("bannerType");
                this.Vk = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.Vl = jSONObject.optInt("template_id");
                this.Vm = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.Vn = jSONObject.optString("tag_name_url");
                cx(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.Vj = banner.banner_type.intValue();
            this.Vk = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.Vl = banner.template_id.intValue();
            this.Vm = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.Vn = banner.tag_name_url;
            cx(banner.tag_name_wh);
        }
    }

    private void cx(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.Vo = g / g2;
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
        return this.mType == 1 ? this.Vj == 1 || this.Vj == 4 || this.Vj == 2 || this.Vj == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
