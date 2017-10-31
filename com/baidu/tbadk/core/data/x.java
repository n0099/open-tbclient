package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private int Wk;
    private String Wl;
    private String Wm;
    private int Wn;
    private String Wo;
    public String Wp;
    public float Wq;
    public boolean Wr = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pR() {
        return this.Wk;
    }

    public String pS() {
        return this.Wl;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pT() {
        return this.Wo;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wk = jSONObject.optInt("bannerType");
                this.Wl = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.Wm = jSONObject.optString("desc");
                this.Wn = jSONObject.optInt("template_id");
                this.Wo = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.Wp = jSONObject.optString("tag_name_url");
                cB(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.Wk = banner.banner_type.intValue();
            this.Wl = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.Wm = banner.desc;
            this.Wn = banner.template_id.intValue();
            this.Wo = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.Wp = banner.tag_name_url;
            cB(banner.tag_name_wh);
        }
    }

    private void cB(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.Wq = g / g2;
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
        return this.mType == 1 ? this.Wk == 1 || this.Wk == 4 || this.Wk == 2 || this.Wk == 3 : this.mType == 2 && !StringUtils.isNull(this.Wm);
    }
}
