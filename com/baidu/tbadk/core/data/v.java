package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class v {
    private int anD;
    private String anE;
    private int anF;
    private String anG;
    public String anH;
    public float anI;
    public boolean anJ = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int xo() {
        return this.anD;
    }

    public String xp() {
        return this.anE;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String xq() {
        return this.anG;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.anD = jSONObject.optInt("bannerType");
                this.anE = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.anF = jSONObject.optInt("template_id");
                this.anG = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.anH = jSONObject.optString("tag_name_url");
                dO(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.anD = banner.banner_type.intValue();
            this.anE = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.anF = banner.template_id.intValue();
            this.anG = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.anH = banner.tag_name_url;
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
                        this.anI = l / l2;
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
        return this.mType == 1 ? this.anD == 1 || this.anD == 4 || this.anD == 2 || this.anD == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
