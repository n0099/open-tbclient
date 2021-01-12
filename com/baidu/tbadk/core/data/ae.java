package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class ae {
    private int eLp;
    private String eLq;
    private int eLr;
    private String eLs;
    public String eLt;
    public float eLu;
    public boolean eLv = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int blH() {
        return this.eLp;
    }

    public String blI() {
        return this.eLq;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String blA() {
        return this.eLs;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eLp = jSONObject.optInt("bannerType");
                this.eLq = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.eLr = jSONObject.optInt("template_id");
                this.eLs = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.eLt = jSONObject.optString("tag_name_url");
                zD(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.eLp = banner.banner_type.intValue();
            this.eLq = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.eLr = banner.template_id.intValue();
            this.eLs = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.eLt = banner.tag_name_url;
            zD(banner.tag_name_wh);
        }
    }

    private void zD(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.eLu = i / i2;
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
        return this.mType == 1 ? this.eLp == 1 || this.eLp == 4 || this.eLp == 2 || this.eLp == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
