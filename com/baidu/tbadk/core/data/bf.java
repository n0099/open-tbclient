package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bf {
    private String abX;
    private String abY;
    private int abZ;
    private String aca;
    private long acb;
    private String acc;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String qF() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String tj() {
        return this.abY;
    }

    public int tk() {
        return this.abZ;
    }

    public String tl() {
        return this.aca;
    }

    public long tm() {
        return this.acb;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.abX = topCode.game_link;
            this.summary = topCode.summary;
            this.abY = topCode.code_link;
            this.abZ = topCode.get_type.intValue();
            this.aca = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.acb = 0L;
            } else {
                this.acb = topCode.giftworth.longValue();
            }
            this.acc = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.abX = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.abY = jSONObject.optString("code_link");
                this.abZ = jSONObject.optInt("get_type", 1);
                this.aca = jSONObject.optString("surplusgift");
                this.acb = jSONObject.optLong("giftworth", 0L);
                this.acc = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String tn() {
        return this.acc;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
