package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bj {
    private String ceI;
    private String ceJ;
    private int ceK;
    private String ceL;
    private long ceM;
    private String ceN;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String ahf() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String akz() {
        return this.ceJ;
    }

    public int akA() {
        return this.ceK;
    }

    public String akB() {
        return this.ceL;
    }

    public long akC() {
        return this.ceM;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.ceI = topCode.game_link;
            this.summary = topCode.summary;
            this.ceJ = topCode.code_link;
            this.ceK = topCode.get_type.intValue();
            this.ceL = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.ceM = 0L;
            } else {
                this.ceM = topCode.giftworth.longValue();
            }
            this.ceN = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.ceI = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.ceJ = jSONObject.optString("code_link");
                this.ceK = jSONObject.optInt("get_type", 1);
                this.ceL = jSONObject.optString("surplusgift");
                this.ceM = jSONObject.optLong("giftworth", 0L);
                this.ceN = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String akD() {
        return this.ceN;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
