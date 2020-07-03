package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bw {
    private String dOR;
    private String dOS;
    private int dOT;
    private String dOU;
    private long dOV;
    private String dOW;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String aQl() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String aUy() {
        return this.dOS;
    }

    public int aUz() {
        return this.dOT;
    }

    public String aUA() {
        return this.dOU;
    }

    public long aUB() {
        return this.dOV;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.dOR = topCode.game_link;
            this.summary = topCode.summary;
            this.dOS = topCode.code_link;
            this.dOT = topCode.get_type.intValue();
            this.dOU = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.dOV = 0L;
            } else {
                this.dOV = topCode.giftworth.longValue();
            }
            this.dOW = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.dOR = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.dOS = jSONObject.optString("code_link");
                this.dOT = jSONObject.optInt("get_type", 1);
                this.dOU = jSONObject.optString("surplusgift");
                this.dOV = jSONObject.optLong("giftworth", 0L);
                this.dOW = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aUC() {
        return this.dOW;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
