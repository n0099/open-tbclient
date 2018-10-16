package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bd {
    private String arA;
    private String arB;
    private int arC;
    private String arD;
    private long arE;
    private String arF;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String xf() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String Ac() {
        return this.arB;
    }

    public int Ad() {
        return this.arC;
    }

    public String Ae() {
        return this.arD;
    }

    public long Af() {
        return this.arE;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.arA = topCode.game_link;
            this.summary = topCode.summary;
            this.arB = topCode.code_link;
            this.arC = topCode.get_type.intValue();
            this.arD = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.arE = 0L;
            } else {
                this.arE = topCode.giftworth.longValue();
            }
            this.arF = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.arA = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.arB = jSONObject.optString("code_link");
                this.arC = jSONObject.optInt("get_type", 1);
                this.arD = jSONObject.optString("surplusgift");
                this.arE = jSONObject.optLong("giftworth", 0L);
                this.arF = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String Ag() {
        return this.arF;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
