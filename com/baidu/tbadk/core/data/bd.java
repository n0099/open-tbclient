package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bd {
    private String amF;
    private String amG;
    private int amH;
    private String amI;
    private long amJ;
    private String amK;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String uW() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String xT() {
        return this.amG;
    }

    public int xU() {
        return this.amH;
    }

    public String xV() {
        return this.amI;
    }

    public long xW() {
        return this.amJ;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.amF = topCode.game_link;
            this.summary = topCode.summary;
            this.amG = topCode.code_link;
            this.amH = topCode.get_type.intValue();
            this.amI = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.amJ = 0L;
            } else {
                this.amJ = topCode.giftworth.longValue();
            }
            this.amK = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.amF = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.amG = jSONObject.optString("code_link");
                this.amH = jSONObject.optInt("get_type", 1);
                this.amI = jSONObject.optString("surplusgift");
                this.amJ = jSONObject.optLong("giftworth", 0L);
                this.amK = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String xX() {
        return this.amK;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
