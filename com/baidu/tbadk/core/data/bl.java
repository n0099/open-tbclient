package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bl {
    private String duc;
    private String dud;
    private int due;
    private String duf;
    private long dug;
    private String duh;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String aIW() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String aMF() {
        return this.dud;
    }

    public int aMG() {
        return this.due;
    }

    public String aMH() {
        return this.duf;
    }

    public long aMI() {
        return this.dug;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.duc = topCode.game_link;
            this.summary = topCode.summary;
            this.dud = topCode.code_link;
            this.due = topCode.get_type.intValue();
            this.duf = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.dug = 0L;
            } else {
                this.dug = topCode.giftworth.longValue();
            }
            this.duh = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.duc = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.dud = jSONObject.optString("code_link");
                this.due = jSONObject.optInt("get_type", 1);
                this.duf = jSONObject.optString("surplusgift");
                this.dug = jSONObject.optLong("giftworth", 0L);
                this.duh = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aMJ() {
        return this.duh;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
