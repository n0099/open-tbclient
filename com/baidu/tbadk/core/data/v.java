package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class v {
    private int amQ;
    private String amR;
    private int amS;
    private String amT;
    public String amU;
    public float amV;
    public boolean amW = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int xg() {
        return this.amQ;
    }

    public String xh() {
        return this.amR;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String xi() {
        return this.amT;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.amQ = jSONObject.optInt("bannerType");
                this.amR = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.amS = jSONObject.optInt("template_id");
                this.amT = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.amU = jSONObject.optString("tag_name_url");
                dO(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.amQ = banner.banner_type.intValue();
            this.amR = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.amS = banner.template_id.intValue();
            this.amT = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.amU = banner.tag_name_url;
            dO(banner.tag_name_wh);
        }
    }

    private void dO(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int l = com.baidu.adp.lib.g.b.l(split[0], 1);
                    int l2 = com.baidu.adp.lib.g.b.l(split[1], 1);
                    if (l2 != 0) {
                        this.amV = l / l2;
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
        return this.mType == 1 ? this.amQ == 1 || this.amQ == 4 || this.amQ == 2 || this.amQ == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
