package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class v {
    private int arH;
    private String arI;
    private int arJ;
    private String arK;
    public String arL;
    public float arM;
    public boolean arN = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int yG() {
        return this.arH;
    }

    public String yH() {
        return this.arI;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String yx() {
        return this.arK;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arH = jSONObject.optInt("bannerType");
                this.arI = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.arJ = jSONObject.optInt("template_id");
                this.arK = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.arL = jSONObject.optString("tag_name_url");
                ep(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.arH = banner.banner_type.intValue();
            this.arI = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.arJ = banner.template_id.intValue();
            this.arK = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.arL = banner.tag_name_url;
            ep(banner.tag_name_wh);
        }
    }

    private void ep(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int l = com.baidu.adp.lib.g.b.l(split[0], 1);
                    int l2 = com.baidu.adp.lib.g.b.l(split[1], 1);
                    if (l2 != 0) {
                        this.arM = l / l2;
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
        return this.mType == 1 ? this.arH == 1 || this.arH == 4 || this.arH == 2 || this.arH == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
