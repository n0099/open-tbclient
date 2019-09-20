package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.ubc.UBC;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private String aZR;
    private int bHn;
    private String bHo;
    private int bHp;
    private String bHq;
    public String bHr;
    public float bHs;
    public boolean bHt = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int ada() {
        return this.bHn;
    }

    public String adb() {
        return this.bHo;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String acR() {
        return this.bHq;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bHn = jSONObject.optInt("bannerType");
                this.bHo = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
                this.mType = jSONObject.optInt("type");
                this.aZR = jSONObject.optString("desc");
                this.bHp = jSONObject.optInt("template_id");
                this.bHq = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.bHr = jSONObject.optString("tag_name_url");
                mr(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.bHn = banner.banner_type.intValue();
            this.bHo = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aZR = banner.desc;
            this.bHp = banner.template_id.intValue();
            this.bHq = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.bHr = banner.tag_name_url;
            mr(banner.tag_name_wh);
        }
    }

    private void mr(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int f = com.baidu.adp.lib.g.b.f(split[0], 1);
                    int f2 = com.baidu.adp.lib.g.b.f(split[1], 1);
                    if (f2 != 0) {
                        this.bHs = f / f2;
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
        return this.mType == 1 ? this.bHn == 1 || this.bHn == 4 || this.bHn == 2 || this.bHn == 3 : this.mType == 2 && !StringUtils.isNull(this.aZR);
    }
}
