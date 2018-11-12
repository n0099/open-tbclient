package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bd {
    private String asn;
    private String aso;
    private int asp;
    private String asq;
    private long asr;
    private String ass;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String xn() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String Aj() {
        return this.aso;
    }

    public int Ak() {
        return this.asp;
    }

    public String Al() {
        return this.asq;
    }

    public long Am() {
        return this.asr;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.asn = topCode.game_link;
            this.summary = topCode.summary;
            this.aso = topCode.code_link;
            this.asp = topCode.get_type.intValue();
            this.asq = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.asr = 0L;
            } else {
                this.asr = topCode.giftworth.longValue();
            }
            this.ass = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.asn = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aso = jSONObject.optString("code_link");
                this.asp = jSONObject.optInt("get_type", 1);
                this.asq = jSONObject.optString("surplusgift");
                this.asr = jSONObject.optLong("giftworth", 0L);
                this.ass = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String An() {
        return this.ass;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
