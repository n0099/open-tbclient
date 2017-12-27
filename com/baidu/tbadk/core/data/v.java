package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class v {
    private int aLc;
    private String aLd;
    private String aLe;
    private int aLf;
    private String aLg;
    public String aLh;
    public float aLi;
    public boolean aLj = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int xv() {
        return this.aLc;
    }

    public String xw() {
        return this.aLd;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String xx() {
        return this.aLg;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aLc = jSONObject.optInt("bannerType");
                this.aLd = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.aLe = jSONObject.optString("desc");
                this.aLf = jSONObject.optInt("template_id");
                this.aLg = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.aLh = jSONObject.optString("tag_name_url");
                cI(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.aLc = banner.banner_type.intValue();
            this.aLd = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aLe = banner.desc;
            this.aLf = banner.template_id.intValue();
            this.aLg = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.aLh = banner.tag_name_url;
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
                        this.aLi = h / h2;
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
        return this.mType == 1 ? this.aLc == 1 || this.aLc == 4 || this.aLc == 2 || this.aLc == 3 : this.mType == 2 && !StringUtils.isNull(this.aLe);
    }
}
