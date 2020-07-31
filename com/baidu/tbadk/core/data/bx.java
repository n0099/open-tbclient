package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bx {
    private String dVd;
    private String dVe;
    private int dVf;
    private String dVg;
    private long dVh;
    private String dVi;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String aUh() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String aYs() {
        return this.dVe;
    }

    public int aYt() {
        return this.dVf;
    }

    public String aYu() {
        return this.dVg;
    }

    public long aYv() {
        return this.dVh;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.dVd = topCode.game_link;
            this.summary = topCode.summary;
            this.dVe = topCode.code_link;
            this.dVf = topCode.get_type.intValue();
            this.dVg = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.dVh = 0L;
            } else {
                this.dVh = topCode.giftworth.longValue();
            }
            this.dVi = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.dVd = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.dVe = jSONObject.optString("code_link");
                this.dVf = jSONObject.optInt("get_type", 1);
                this.dVg = jSONObject.optString("surplusgift");
                this.dVh = jSONObject.optLong("giftworth", 0L);
                this.dVi = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aYw() {
        return this.dVi;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
