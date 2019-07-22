package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bi {
    private String bMA;
    private String bMv;
    private String bMw;
    private int bMx;
    private String bMy;
    private long bMz;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String acU() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String agr() {
        return this.bMw;
    }

    public int ags() {
        return this.bMx;
    }

    public String agt() {
        return this.bMy;
    }

    public long agu() {
        return this.bMz;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.bMv = topCode.game_link;
            this.summary = topCode.summary;
            this.bMw = topCode.code_link;
            this.bMx = topCode.get_type.intValue();
            this.bMy = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.bMz = 0L;
            } else {
                this.bMz = topCode.giftworth.longValue();
            }
            this.bMA = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.bMv = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.bMw = jSONObject.optString("code_link");
                this.bMx = jSONObject.optInt("get_type", 1);
                this.bMy = jSONObject.optString("surplusgift");
                this.bMz = jSONObject.optLong("giftworth", 0L);
                this.bMA = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String agv() {
        return this.bMA;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
