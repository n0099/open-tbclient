package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bf {
    private String aQF;
    private String aQG;
    private int aQH;
    private String aQI;
    private long aQJ;
    private String aQK;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String ya() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String AC() {
        return this.aQG;
    }

    public int AD() {
        return this.aQH;
    }

    public String AE() {
        return this.aQI;
    }

    public long AF() {
        return this.aQJ;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.aQF = topCode.game_link;
            this.summary = topCode.summary;
            this.aQG = topCode.code_link;
            this.aQH = topCode.get_type.intValue();
            this.aQI = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.aQJ = 0L;
            } else {
                this.aQJ = topCode.giftworth.longValue();
            }
            this.aQK = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.aQF = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aQG = jSONObject.optString("code_link");
                this.aQH = jSONObject.optInt("get_type", 1);
                this.aQI = jSONObject.optString("surplusgift");
                this.aQJ = jSONObject.optLong("giftworth", 0L);
                this.aQK = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String AG() {
        return this.aQK;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
