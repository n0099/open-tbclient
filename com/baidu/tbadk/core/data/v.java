package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class v {
    private int are;
    private String arf;
    private int arg;
    private String arh;
    public String ari;
    public float arj;
    public boolean ark = true;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int yt() {
        return this.are;
    }

    public String yu() {
        return this.arf;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String yk() {
        return this.arh;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.are = jSONObject.optInt("bannerType");
                this.arf = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.arg = jSONObject.optInt("template_id");
                this.arh = jSONObject.optString(VideoPlayActivityConfig.OBJ_ID);
                this.mTagName = jSONObject.optString("tag_name");
                this.ari = jSONObject.optString("tag_name_url");
                eg(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.are = banner.banner_type.intValue();
            this.arf = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.arg = banner.template_id.intValue();
            this.arh = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.ari = banner.tag_name_url;
            eg(banner.tag_name_wh);
        }
    }

    private void eg(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int l = com.baidu.adp.lib.g.b.l(split[0], 1);
                    int l2 = com.baidu.adp.lib.g.b.l(split[1], 1);
                    if (l2 != 0) {
                        this.arj = l / l2;
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
        return this.mType == 1 ? this.are == 1 || this.are == 4 || this.are == 2 || this.are == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
