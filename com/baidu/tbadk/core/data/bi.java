package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bi {
    private String bDX;
    private String bDY;
    private int bDZ;
    private String bEa;
    private long bEb;
    private String bEc;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String Xn() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String aaI() {
        return this.bDY;
    }

    public int aaJ() {
        return this.bDZ;
    }

    public String aaK() {
        return this.bEa;
    }

    public long aaL() {
        return this.bEb;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.bDX = topCode.game_link;
            this.summary = topCode.summary;
            this.bDY = topCode.code_link;
            this.bDZ = topCode.get_type.intValue();
            this.bEa = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.bEb = 0L;
            } else {
                this.bEb = topCode.giftworth.longValue();
            }
            this.bEc = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.bDX = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.bDY = jSONObject.optString("code_link");
                this.bDZ = jSONObject.optInt("get_type", 1);
                this.bEa = jSONObject.optString("surplusgift");
                this.bEb = jSONObject.optLong("giftworth", 0L);
                this.bEc = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aaM() {
        return this.bEc;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
