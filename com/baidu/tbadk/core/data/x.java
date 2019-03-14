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
    private String aVF;
    private String byA;
    public String byB;
    public float byC;
    public boolean byD = true;
    private int byx;
    private String byy;
    private int byz;
    private String mTagName;
    private int mType;
    private String mValue;

    public int Xo() {
        return this.byx;
    }

    public String Xp() {
        return this.byy;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String Xq() {
        return this.byA;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.byx = jSONObject.optInt("bannerType");
                this.byy = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
                this.mType = jSONObject.optInt("type");
                this.aVF = jSONObject.optString("desc");
                this.byz = jSONObject.optInt("template_id");
                this.byA = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.byB = jSONObject.optString("tag_name_url");
                kZ(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.byx = banner.banner_type.intValue();
            this.byy = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aVF = banner.desc;
            this.byz = banner.template_id.intValue();
            this.byA = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.byB = banner.tag_name_url;
            kZ(banner.tag_name_wh);
        }
    }

    private void kZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int l = com.baidu.adp.lib.g.b.l(split[0], 1);
                    int l2 = com.baidu.adp.lib.g.b.l(split[1], 1);
                    if (l2 != 0) {
                        this.byC = l / l2;
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
        return this.mType == 1 ? this.byx == 1 || this.byx == 4 || this.byx == 2 || this.byx == 3 : this.mType == 2 && !StringUtils.isNull(this.aVF);
    }
}
