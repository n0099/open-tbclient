package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private int We;
    private String Wf;
    private String Wg;
    private int Wh;
    private String Wi;
    public String Wj;
    public float Wk;
    public boolean Wl = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int pT() {
        return this.We;
    }

    public String pU() {
        return this.Wf;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String pV() {
        return this.Wi;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.We = jSONObject.optInt("bannerType");
                this.Wf = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.Wg = jSONObject.optString("desc");
                this.Wh = jSONObject.optInt("template_id");
                this.Wi = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.Wj = jSONObject.optString("tag_name_url");
                cw(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.We = banner.banner_type.intValue();
            this.Wf = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.Wg = banner.desc;
            this.Wh = banner.template_id.intValue();
            this.Wi = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.Wj = banner.tag_name_url;
            cw(banner.tag_name_wh);
        }
    }

    private void cw(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.Wk = g / g2;
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
        return this.mType == 1 ? this.We == 1 || this.We == 4 || this.We == 2 || this.We == 3 : this.mType == 2 && !StringUtils.isNull(this.Wg);
    }
}
