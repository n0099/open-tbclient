package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class by {
    private String eBB;
    private String eBC;
    private int eBD;
    private String eBE;
    private long eBF;
    private String eBG;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String bhW() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String bmj() {
        return this.eBC;
    }

    public int bmk() {
        return this.eBD;
    }

    public String bml() {
        return this.eBE;
    }

    public long bmm() {
        return this.eBF;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.eBB = topCode.game_link;
            this.summary = topCode.summary;
            this.eBC = topCode.code_link;
            this.eBD = topCode.get_type.intValue();
            this.eBE = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.eBF = 0L;
            } else {
                this.eBF = topCode.giftworth.longValue();
            }
            this.eBG = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.eBB = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.eBC = jSONObject.optString("code_link");
                this.eBD = jSONObject.optInt("get_type", 1);
                this.eBE = jSONObject.optString("surplusgift");
                this.eBF = jSONObject.optLong("giftworth", 0L);
                this.eBG = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String bmn() {
        return this.eBG;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
