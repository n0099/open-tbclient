package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class cb {
    private String eWJ;
    private String eWK;
    private int eWL;
    private String eWM;
    private long eWN;
    private String eWO;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String btE() {
        return this.eWK;
    }

    public int btF() {
        return this.eWL;
    }

    public String btG() {
        return this.eWM;
    }

    public long btH() {
        return this.eWN;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.eWJ = topCode.game_link;
            this.summary = topCode.summary;
            this.eWK = topCode.code_link;
            this.eWL = topCode.get_type.intValue();
            this.eWM = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.eWN = 0L;
            } else {
                this.eWN = topCode.giftworth.longValue();
            }
            this.eWO = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.eWJ = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.eWK = jSONObject.optString("code_link");
                this.eWL = jSONObject.optInt("get_type", 1);
                this.eWM = jSONObject.optString("surplusgift");
                this.eWN = jSONObject.optLong("giftworth", 0L);
                this.eWO = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String btI() {
        return this.eWO;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
