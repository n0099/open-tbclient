package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bl {
    private String cQA;
    private String cQB;
    private int cQC;
    private String cQD;
    private long cQE;
    private String cQF;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String ayq() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String aCa() {
        return this.cQB;
    }

    public int aCb() {
        return this.cQC;
    }

    public String aCc() {
        return this.cQD;
    }

    public long aCd() {
        return this.cQE;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.cQA = topCode.game_link;
            this.summary = topCode.summary;
            this.cQB = topCode.code_link;
            this.cQC = topCode.get_type.intValue();
            this.cQD = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.cQE = 0L;
            } else {
                this.cQE = topCode.giftworth.longValue();
            }
            this.cQF = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.cQA = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.cQB = jSONObject.optString("code_link");
                this.cQC = jSONObject.optInt("get_type", 1);
                this.cQD = jSONObject.optString("surplusgift");
                this.cQE = jSONObject.optLong("giftworth", 0L);
                this.cQF = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aCe() {
        return this.cQF;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
