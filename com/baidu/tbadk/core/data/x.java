package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private int UU;
    private String UV;
    private int UW;
    private String UX;
    public String UY;
    public float UZ;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pM() {
        return this.UU;
    }

    public String pN() {
        return this.UV;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pO() {
        return this.UX;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.UU = jSONObject.optInt("bannerType");
                this.UV = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.UW = jSONObject.optInt("template_id");
                this.UX = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.UY = jSONObject.optString("tag_name_url");
                cm(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.UU = banner.banner_type.intValue();
            this.UV = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.UW = banner.template_id.intValue();
            this.UX = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.UY = banner.tag_name_url;
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
                        this.UZ = g / g2;
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
        return this.mType == 1 ? this.UU == 1 || this.UU == 4 || this.UU == 2 || this.UU == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
