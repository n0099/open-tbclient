package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bj {
    private String bMA;
    private String bMB;
    private int bMC;
    private String bMD;
    private long bME;
    private String bMF;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String acV() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String agt() {
        return this.bMB;
    }

    public int agu() {
        return this.bMC;
    }

    public String agv() {
        return this.bMD;
    }

    public long agw() {
        return this.bME;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.bMA = topCode.game_link;
            this.summary = topCode.summary;
            this.bMB = topCode.code_link;
            this.bMC = topCode.get_type.intValue();
            this.bMD = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.bME = 0L;
            } else {
                this.bME = topCode.giftworth.longValue();
            }
            this.bMF = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.bMA = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.bMB = jSONObject.optString("code_link");
                this.bMC = jSONObject.optInt("get_type", 1);
                this.bMD = jSONObject.optString("surplusgift");
                this.bME = jSONObject.optLong("giftworth", 0L);
                this.bMF = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String agx() {
        return this.bMF;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
