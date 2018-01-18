package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class v {
    private int aLa;
    private String aLb;
    private String aLc;
    private int aLd;
    private String aLe;
    public String aLf;
    public float aLg;
    public boolean aLh = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int xu() {
        return this.aLa;
    }

    public String xv() {
        return this.aLb;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String xw() {
        return this.aLe;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aLa = jSONObject.optInt("bannerType");
                this.aLb = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.aLc = jSONObject.optString("desc");
                this.aLd = jSONObject.optInt("template_id");
                this.aLe = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.aLf = jSONObject.optString("tag_name_url");
                cI(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.aLa = banner.banner_type.intValue();
            this.aLb = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aLc = banner.desc;
            this.aLd = banner.template_id.intValue();
            this.aLe = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.aLf = banner.tag_name_url;
            cI(banner.tag_name_wh);
        }
    }

    private void cI(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int h = com.baidu.adp.lib.g.b.h(split[0], 1);
                    int h2 = com.baidu.adp.lib.g.b.h(split[1], 1);
                    if (h2 != 0) {
                        this.aLg = h / h2;
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
        return this.mType == 1 ? this.aLa == 1 || this.aLa == 4 || this.aLa == 2 || this.aLa == 3 : this.mType == 2 && !StringUtils.isNull(this.aLc);
    }
}
