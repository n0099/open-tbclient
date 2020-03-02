package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bl {
    private String cUD;
    private String cUE;
    private int cUF;
    private String cUG;
    private long cUH;
    private String cUI;
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
        return this.cUE;
    }

    public int aEo() {
        return this.cUF;
    }

    public String aEp() {
        return this.cUG;
    }

    public long aEq() {
        return this.cUH;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.cUD = topCode.game_link;
            this.summary = topCode.summary;
            this.cUE = topCode.code_link;
            this.cUF = topCode.get_type.intValue();
            this.cUG = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.cUH = 0L;
            } else {
                this.cUH = topCode.giftworth.longValue();
            }
            this.cUI = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.cUD = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.cUE = jSONObject.optString("code_link");
                this.cUF = jSONObject.optInt("get_type", 1);
                this.cUG = jSONObject.optString("surplusgift");
                this.cUH = jSONObject.optLong("giftworth", 0L);
                this.cUI = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aEr() {
        return this.cUI;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
