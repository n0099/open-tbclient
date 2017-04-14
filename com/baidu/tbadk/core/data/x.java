package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes.dex */
public class x {
    private int VM;
    private String VN;
    private int VO;
    private String VP;
    public String VQ;
    public float VR;
    private String mDesc;
    private String mTagName;
    private int mType;
    private String mValue;

    public int qE() {
        return this.VM;
    }

    public String qF() {
        return this.VN;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getType() {
        return this.mType;
    }

    public String qj() {
        return this.VP;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VM = jSONObject.optInt("bannerType");
                this.VN = jSONObject.optString("bannerUrl");
                this.mValue = jSONObject.optString("value");
                this.mType = jSONObject.optInt("type");
                this.mDesc = jSONObject.optString("desc");
                this.VO = jSONObject.optInt("template_id");
                this.VP = jSONObject.optString("obj_id");
                this.mTagName = jSONObject.optString("tag_name");
                this.VQ = jSONObject.optString("tag_name_url");
                cm(jSONObject.optString("tag_name_wh"));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a(Banner banner) {
        if (banner != null) {
            this.VM = banner.banner_type.intValue();
            this.VN = banner.banner_url;
            this.mValue = banner.value;
            this.mType = banner.type.intValue();
            this.mDesc = banner.desc;
            this.VO = banner.template_id.intValue();
            this.VP = banner.obj_id;
            this.mTagName = banner.tag_name;
            this.VQ = banner.tag_name_url;
            cm(banner.tag_name_wh);
        }
    }

    private void cm(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 2) {
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.VR = g / g2;
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
        return this.mType == 1 ? this.VM == 1 || this.VM == 4 || this.VM == 2 || this.VM == 3 : this.mType == 2 && !StringUtils.isNull(this.mDesc);
    }
}
