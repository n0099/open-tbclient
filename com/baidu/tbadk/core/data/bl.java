package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bl {
    private String cUR;
    private String cUS;
    private int cUT;
    private String cUU;
    private long cUV;
    private String cUW;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String aAJ() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String aEr() {
        return this.cUS;
    }

    public int aEs() {
        return this.cUT;
    }

    public String aEt() {
        return this.cUU;
    }

    public long aEu() {
        return this.cUV;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.cUR = topCode.game_link;
            this.summary = topCode.summary;
            this.cUS = topCode.code_link;
            this.cUT = topCode.get_type.intValue();
            this.cUU = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.cUV = 0L;
            } else {
                this.cUV = topCode.giftworth.longValue();
            }
            this.cUW = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.cUR = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.cUS = jSONObject.optString("code_link");
                this.cUT = jSONObject.optInt("get_type", 1);
                this.cUU = jSONObject.optString("surplusgift");
                this.cUV = jSONObject.optLong("giftworth", 0L);
                this.cUW = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aEv() {
        return this.cUW;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
