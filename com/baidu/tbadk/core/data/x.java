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
    private String aVI;
    private int byA;
    private String byB;
    private int byC;
    private String byD;
    public String byE;
    public float byF;
    public boolean byG = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int Xl() {
        return this.byA;
    }

    public String Xm() {
        return this.byB;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String Xn() {
        return this.byD;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.byA = jSONObject.optInt("bannerType");
                this.byB = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
                this.mType = jSONObject.optInt("type");
                this.aVI = jSONObject.optString("desc");
                this.byC = jSONObject.optInt("template_id");
                this.byD = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.byE = jSONObject.optString("tag_name_url");
                la(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.byA = banner.banner_type.intValue();
            this.byB = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aVI = banner.desc;
            this.byC = banner.template_id.intValue();
            this.byD = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.byE = banner.tag_name_url;
            la(banner.tag_name_wh);
        }
    }

    private void la(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length >= 2) {
                    int l = com.baidu.adp.lib.g.b.l(split[0], 1);
                    int l2 = com.baidu.adp.lib.g.b.l(split[1], 1);
                    if (l2 != 0) {
                        this.byF = l / l2;
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
        return this.mType == 1 ? this.byA == 1 || this.byA == 4 || this.byA == 2 || this.byA == 3 : this.mType == 2 && !StringUtils.isNull(this.aVI);
    }
}
