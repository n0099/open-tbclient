package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class by {
    private String egV;
    private String egW;
    private int egX;
    private String egY;
    private long egZ;
    private String eha;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String bdu() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String bhH() {
        return this.egW;
    }

    public int bhI() {
        return this.egX;
    }

    public String bhJ() {
        return this.egY;
    }

    public long bhK() {
        return this.egZ;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.egV = topCode.game_link;
            this.summary = topCode.summary;
            this.egW = topCode.code_link;
            this.egX = topCode.get_type.intValue();
            this.egY = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.egZ = 0L;
            } else {
                this.egZ = topCode.giftworth.longValue();
            }
            this.eha = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.egV = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.egW = jSONObject.optString("code_link");
                this.egX = jSONObject.optInt("get_type", 1);
                this.egY = jSONObject.optString("surplusgift");
                this.egZ = jSONObject.optLong("giftworth", 0L);
                this.eha = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String bhL() {
        return this.eha;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
