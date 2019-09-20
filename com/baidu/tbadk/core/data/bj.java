package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bj {
    private String bMZ;
    private String bNa;
    private int bNb;
    private String bNc;
    private long bNd;
    private String bNe;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String acZ() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String agx() {
        return this.bNa;
    }

    public int agy() {
        return this.bNb;
    }

    public String agz() {
        return this.bNc;
    }

    public long agA() {
        return this.bNd;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.bMZ = topCode.game_link;
            this.summary = topCode.summary;
            this.bNa = topCode.code_link;
            this.bNb = topCode.get_type.intValue();
            this.bNc = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.bNd = 0L;
            } else {
                this.bNd = topCode.giftworth.longValue();
            }
            this.bNe = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.bMZ = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.bNa = jSONObject.optString("code_link");
                this.bNb = jSONObject.optInt("get_type", 1);
                this.bNc = jSONObject.optString("surplusgift");
                this.bNd = jSONObject.optLong("giftworth", 0L);
                this.bNe = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String agB() {
        return this.bNe;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
