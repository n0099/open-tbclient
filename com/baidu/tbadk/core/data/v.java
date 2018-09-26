package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class v {
    private int ahU;
    private String ahV;
    private String ahW;
    private int ahX;
    private String ahY;
    public String ahZ;
    public float aia;
    public boolean aib = true;
    private String mTagName;
    private int mType;
    private String mValue;

    public int uX() {
        return this.ahU;
    }

    public String uY() {
        return this.ahV;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String uZ() {
        return this.ahY;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ahU = jSONObject.optInt("bannerType");
                this.ahV = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.ahW = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
                this.ahX = jSONObject.optInt("template_id");
                this.ahY = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.ahZ = jSONObject.optString("tag_name_url");
                dy(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.ahU = banner.banner_type.intValue();
            this.ahV = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.ahW = banner.desc;
            this.ahX = banner.template_id.intValue();
            this.ahY = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.ahZ = banner.tag_name_url;
            dy(banner.tag_name_wh);
        }
    }

    private void dy(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int l = com.baidu.adp.lib.g.b.l(split[0], 1);
                    int l2 = com.baidu.adp.lib.g.b.l(split[1], 1);
                    if (l2 != 0) {
                        this.aia = l / l2;
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
        return this.mType == 1 ? this.ahU == 1 || this.ahU == 4 || this.ahU == 2 || this.ahU == 3 : this.mType == 2 && !StringUtils.isNull(this.ahW);
    }
}
