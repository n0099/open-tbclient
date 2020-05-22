package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bm {
    private String dIb;
    private String dIc;
    private int dId;
    private String dIe;
    private long dIf;
    private String dIg;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String aOP() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String aSE() {
        return this.dIc;
    }

    public int aSF() {
        return this.dId;
    }

    public String aSG() {
        return this.dIe;
    }

    public long aSH() {
        return this.dIf;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.dIb = topCode.game_link;
            this.summary = topCode.summary;
            this.dIc = topCode.code_link;
            this.dId = topCode.get_type.intValue();
            this.dIe = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.dIf = 0L;
            } else {
                this.dIf = topCode.giftworth.longValue();
            }
            this.dIg = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.dIb = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.dIc = jSONObject.optString("code_link");
                this.dId = jSONObject.optInt("get_type", 1);
                this.dIe = jSONObject.optString("surplusgift");
                this.dIf = jSONObject.optLong("giftworth", 0L);
                this.dIg = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aSI() {
        return this.dIg;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
