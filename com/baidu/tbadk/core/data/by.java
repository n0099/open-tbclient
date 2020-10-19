package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class by {
    private String etb;
    private String etd;
    private int ete;
    private String etf;
    private long etg;
    private String eth;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String bgd() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String bkq() {
        return this.etd;
    }

    public int bkr() {
        return this.ete;
    }

    public String bks() {
        return this.etf;
    }

    public long bkt() {
        return this.etg;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.etb = topCode.game_link;
            this.summary = topCode.summary;
            this.etd = topCode.code_link;
            this.ete = topCode.get_type.intValue();
            this.etf = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.etg = 0L;
            } else {
                this.etg = topCode.giftworth.longValue();
            }
            this.eth = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.etb = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.etd = jSONObject.optString("code_link");
                this.ete = jSONObject.optInt("get_type", 1);
                this.etf = jSONObject.optString("surplusgift");
                this.etg = jSONObject.optLong("giftworth", 0L);
                this.eth = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String bku() {
        return this.eth;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
