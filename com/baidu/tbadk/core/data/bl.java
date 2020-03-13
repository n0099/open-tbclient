package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bl {
    private String cUE;
    private String cUF;
    private int cUG;
    private String cUH;
    private long cUI;
    private String cUJ;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String aAG() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String aEn() {
        return this.cUF;
    }

    public int aEo() {
        return this.cUG;
    }

    public String aEp() {
        return this.cUH;
    }

    public long aEq() {
        return this.cUI;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.cUE = topCode.game_link;
            this.summary = topCode.summary;
            this.cUF = topCode.code_link;
            this.cUG = topCode.get_type.intValue();
            this.cUH = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.cUI = 0L;
            } else {
                this.cUI = topCode.giftworth.longValue();
            }
            this.cUJ = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.cUE = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.cUF = jSONObject.optString("code_link");
                this.cUG = jSONObject.optInt("get_type", 1);
                this.cUH = jSONObject.optString("surplusgift");
                this.cUI = jSONObject.optLong("giftworth", 0L);
                this.cUJ = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aEr() {
        return this.cUJ;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
