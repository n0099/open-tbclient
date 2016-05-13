package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class az {
    private String Re;
    private String Rf;
    private int Rg;
    private String Rh;
    private long Ri;
    private String Rj;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String qv() {
        return this.imgUrl;
    }

    public String rC() {
        return this.summary;
    }

    public String rD() {
        return this.Rf;
    }

    public int rE() {
        return this.Rg;
    }

    public String rF() {
        return this.Rh;
    }

    public long rG() {
        return this.Ri;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.Re = topCode.game_link;
            this.summary = topCode.summary;
            this.Rf = topCode.code_link;
            this.Rg = topCode.get_type.intValue();
            this.Rh = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Ri = 0L;
            } else {
                this.Ri = topCode.giftworth.longValue();
            }
            this.Rj = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.Re = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Rf = jSONObject.optString("code_link");
                this.Rg = jSONObject.optInt("get_type", 1);
                this.Rh = jSONObject.optString("surplusgift");
                this.Ri = jSONObject.optLong("giftworth", 0L);
                this.Rj = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String rH() {
        return this.Rj;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
