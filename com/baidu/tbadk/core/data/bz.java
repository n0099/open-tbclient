package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bz {
    private String eFI;
    private String eFJ;
    private int eFK;
    private String eFL;
    private long eFM;
    private String eFN;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String bjy() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String bnN() {
        return this.eFJ;
    }

    public int bnO() {
        return this.eFK;
    }

    public String bnP() {
        return this.eFL;
    }

    public long bnQ() {
        return this.eFM;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.eFI = topCode.game_link;
            this.summary = topCode.summary;
            this.eFJ = topCode.code_link;
            this.eFK = topCode.get_type.intValue();
            this.eFL = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.eFM = 0L;
            } else {
                this.eFM = topCode.giftworth.longValue();
            }
            this.eFN = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.eFI = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.eFJ = jSONObject.optString("code_link");
                this.eFK = jSONObject.optInt("get_type", 1);
                this.eFL = jSONObject.optString("surplusgift");
                this.eFM = jSONObject.optLong("giftworth", 0L);
                this.eFN = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String bnR() {
        return this.eFN;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
