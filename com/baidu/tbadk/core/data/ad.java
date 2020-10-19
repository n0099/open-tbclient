package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class ad {
    private int emB;
    private String emC;
    private int emD;
    private String emE;
    public String emF;
    public float emG;
    public boolean emH = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int bgt() {
        return this.emB;
    }

    public String bgu() {
        return this.emC;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String bgm() {
        return this.emE;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.emB = jSONObject.optInt("bannerType");
                this.emC = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.emD = jSONObject.optInt("template_id");
                this.emE = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.emF = jSONObject.optString("tag_name_url");
                Ai(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.emB = banner.banner_type.intValue();
            this.emC = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.emD = banner.template_id.intValue();
            this.emE = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.emF = banner.tag_name_url;
            Ai(banner.tag_name_wh);
        }
    }

    private void Ai(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.emG = i / i2;
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
        return this.mType == 1 ? this.emB == 1 || this.emB == 4 || this.emB == 2 || this.emB == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
