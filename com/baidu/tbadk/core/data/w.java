package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class w {
    private int afK;
    private String afL;
    private String afM;
    private int afN;
    private String afO;
    public String afP;
    public float afQ;
    public boolean afR = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int uc() {
        return this.afK;
    }

    public String ud() {
        return this.afL;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String ue() {
        return this.afO;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.afK = jSONObject.optInt("bannerType");
                this.afL = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.afM = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
                this.afN = jSONObject.optInt("template_id");
                this.afO = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.afP = jSONObject.optString("tag_name_url");
                df(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.afK = banner.banner_type.intValue();
            this.afL = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.afM = banner.desc;
            this.afN = banner.template_id.intValue();
            this.afO = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.afP = banner.tag_name_url;
            df(banner.tag_name_wh);
        }
    }

    private void df(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.afQ = g / g2;
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
        return this.mType == 1 ? this.afK == 1 || this.afK == 4 || this.afK == 2 || this.afK == 3 : this.mType == 2 && !StringUtils.isNull(this.afM);
    }
}
