package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bf {
    private String abW;
    private String abX;
    private int abY;
    private String abZ;
    private long aca;
    private String acb;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String qG() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String tk() {
        return this.abX;
    }

    public int tl() {
        return this.abY;
    }

    public String tm() {
        return this.abZ;
    }

    public long tn() {
        return this.aca;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.abW = topCode.game_link;
            this.summary = topCode.summary;
            this.abX = topCode.code_link;
            this.abY = topCode.get_type.intValue();
            this.abZ = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.aca = 0L;
            } else {
                this.aca = topCode.giftworth.longValue();
            }
            this.acb = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.abW = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.abX = jSONObject.optString("code_link");
                this.abY = jSONObject.optInt("get_type", 1);
                this.abZ = jSONObject.optString("surplusgift");
                this.aca = jSONObject.optLong("giftworth", 0L);
                this.acb = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String tp() {
        return this.acb;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
