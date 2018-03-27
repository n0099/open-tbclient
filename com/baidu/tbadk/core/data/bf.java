package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bf {
    private long aQA;
    private String aQB;
    private String aQw;
    private String aQx;
    private int aQy;
    private String aQz;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String ya() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String AD() {
        return this.aQx;
    }

    public int AE() {
        return this.aQy;
    }

    public String AF() {
        return this.aQz;
    }

    public long AG() {
        return this.aQA;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.aQw = topCode.game_link;
            this.summary = topCode.summary;
            this.aQx = topCode.code_link;
            this.aQy = topCode.get_type.intValue();
            this.aQz = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.aQA = 0L;
            } else {
                this.aQA = topCode.giftworth.longValue();
            }
            this.aQB = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.aQw = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aQx = jSONObject.optString("code_link");
                this.aQy = jSONObject.optInt("get_type", 1);
                this.aQz = jSONObject.optString("surplusgift");
                this.aQA = jSONObject.optLong("giftworth", 0L);
                this.aQB = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String AH() {
        return this.aQB;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
