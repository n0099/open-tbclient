package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bl {
    private String cUC;
    private String cUD;
    private int cUE;
    private String cUF;
    private long cUG;
    private String cUH;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String aAE() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String aEl() {
        return this.cUD;
    }

    public int aEm() {
        return this.cUE;
    }

    public String aEn() {
        return this.cUF;
    }

    public long aEo() {
        return this.cUG;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.cUC = topCode.game_link;
            this.summary = topCode.summary;
            this.cUD = topCode.code_link;
            this.cUE = topCode.get_type.intValue();
            this.cUF = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.cUG = 0L;
            } else {
                this.cUG = topCode.giftworth.longValue();
            }
            this.cUH = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.cUC = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.cUD = jSONObject.optString("code_link");
                this.cUE = jSONObject.optInt("get_type", 1);
                this.cUF = jSONObject.optString("surplusgift");
                this.cUG = jSONObject.optLong("giftworth", 0L);
                this.cUH = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aEp() {
        return this.cUH;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
