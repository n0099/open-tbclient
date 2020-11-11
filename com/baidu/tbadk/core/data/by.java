package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class by {
    private String eHq;
    private String eHr;
    private int eHs;
    private String eHt;
    private long eHu;
    private String eHv;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String bkw() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String boJ() {
        return this.eHr;
    }

    public int boK() {
        return this.eHs;
    }

    public String boL() {
        return this.eHt;
    }

    public long boM() {
        return this.eHu;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.eHq = topCode.game_link;
            this.summary = topCode.summary;
            this.eHr = topCode.code_link;
            this.eHs = topCode.get_type.intValue();
            this.eHt = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.eHu = 0L;
            } else {
                this.eHu = topCode.giftworth.longValue();
            }
            this.eHv = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.eHq = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.eHr = jSONObject.optString("code_link");
                this.eHs = jSONObject.optInt("get_type", 1);
                this.eHt = jSONObject.optString("surplusgift");
                this.eHu = jSONObject.optLong("giftworth", 0L);
                this.eHv = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String boN() {
        return this.eHv;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
