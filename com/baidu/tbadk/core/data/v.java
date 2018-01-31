package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class v {
    private int aLd;
    private String aLe;
    private String aLf;
    private int aLg;
    private String aLh;
    public String aLi;
    public float aLj;
    public boolean aLk = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int xv() {
        return this.aLd;
    }

    public String xw() {
        return this.aLe;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String xx() {
        return this.aLh;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aLd = jSONObject.optInt("bannerType");
                this.aLe = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.aLf = jSONObject.optString("desc");
                this.aLg = jSONObject.optInt("template_id");
                this.aLh = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.aLi = jSONObject.optString("tag_name_url");
                cI(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.aLd = banner.banner_type.intValue();
            this.aLe = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aLf = banner.desc;
            this.aLg = banner.template_id.intValue();
            this.aLh = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.aLi = banner.tag_name_url;
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
                        this.aLj = h / h2;
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
        return this.mType == 1 ? this.aLd == 1 || this.aLd == 4 || this.aLd == 2 || this.aLd == 3 : this.mType == 2 && !StringUtils.isNull(this.aLf);
    }
}
