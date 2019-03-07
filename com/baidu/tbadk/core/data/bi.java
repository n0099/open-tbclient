package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bi {
    private String bDV;
    private String bDW;
    private int bDX;
    private String bDY;
    private long bDZ;
    private String bEa;
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
        return this.bDW;
    }

    public int aaJ() {
        return this.bDX;
    }

    public String aaK() {
        return this.bDY;
    }

    public long aaL() {
        return this.bDZ;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.bDV = topCode.game_link;
            this.summary = topCode.summary;
            this.bDW = topCode.code_link;
            this.bDX = topCode.get_type.intValue();
            this.bDY = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.bDZ = 0L;
            } else {
                this.bDZ = topCode.giftworth.longValue();
            }
            this.bEa = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.bDV = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.bDW = jSONObject.optString("code_link");
                this.bDX = jSONObject.optInt("get_type", 1);
                this.bDY = jSONObject.optString("surplusgift");
                this.bDZ = jSONObject.optLong("giftworth", 0L);
                this.bEa = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aaM() {
        return this.bEa;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
