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
    private String aVE;
    public float byA;
    public boolean byB = true;
    private int byv;
    private String byw;
    private int byx;
    private String byy;
    public String byz;
    private String mTagName;
    private int mType;
    private String mValue;

    public int Xo() {
        return this.byv;
    }

    public String Xp() {
        return this.byw;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String Xq() {
        return this.byy;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.byv = jSONObject.optInt("bannerType");
                this.byw = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
                this.mType = jSONObject.optInt("type");
                this.aVE = jSONObject.optString("desc");
                this.byx = jSONObject.optInt("template_id");
                this.byy = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.byz = jSONObject.optString("tag_name_url");
                kZ(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.byv = banner.banner_type.intValue();
            this.byw = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.aVE = banner.desc;
            this.byx = banner.template_id.intValue();
            this.byy = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.byz = banner.tag_name_url;
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
                        this.byA = l / l2;
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
        return this.mType == 1 ? this.byv == 1 || this.byv == 4 || this.byv == 2 || this.byv == 3 : this.mType == 2 && !StringUtils.isNull(this.aVE);
    }
}
