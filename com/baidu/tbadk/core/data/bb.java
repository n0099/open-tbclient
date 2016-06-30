package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bb {
    private long RA;
    private String RB;
    private String Rw;
    private String Rx;
    private int Ry;
    private String Rz;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String qp() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String rA() {
        return this.Rx;
    }

    public int rB() {
        return this.Ry;
    }

    public String rC() {
        return this.Rz;
    }

    public long rD() {
        return this.RA;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.Rw = topCode.game_link;
            this.summary = topCode.summary;
            this.Rx = topCode.code_link;
            this.Ry = topCode.get_type.intValue();
            this.Rz = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.RA = 0L;
            } else {
                this.RA = topCode.giftworth.longValue();
            }
            this.RB = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.Rw = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Rx = jSONObject.optString("code_link");
                this.Ry = jSONObject.optInt("get_type", 1);
                this.Rz = jSONObject.optString("surplusgift");
                this.RA = jSONObject.optLong("giftworth", 0L);
                this.RB = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String rE() {
        return this.RB;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
