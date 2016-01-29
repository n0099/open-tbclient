package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class ai {
    private int XA;
    private String XB;
    private long XC;
    private String XD;
    private String XE;
    private String Xy;
    private String Xz;
    private String imgUrl;
    private String summary;

    public String sV() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String tQ() {
        return this.Xz;
    }

    public int tR() {
        return this.XA;
    }

    public String tS() {
        return this.XB;
    }

    public long tT() {
        return this.XC;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.Xy = topCode.game_link;
            this.summary = topCode.summary;
            this.Xz = topCode.code_link;
            this.XA = topCode.get_type.intValue();
            this.XB = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.XC = 0L;
            } else {
                this.XC = topCode.giftworth.longValue();
            }
            this.XD = topCode.type_text;
            this.XE = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.Xy = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Xz = jSONObject.optString("code_link");
                this.XA = jSONObject.optInt("get_type", 1);
                this.XB = jSONObject.optString("surplusgift");
                this.XC = jSONObject.optLong("giftworth", 0L);
                this.XD = jSONObject.optString("type_text");
                this.XE = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String tU() {
        return this.XD;
    }

    public String tV() {
        return this.XE;
    }
}
