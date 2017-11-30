package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bf {
    private String aaN;
    private String aaO;
    private int aaP;
    private String aaQ;
    private long aaR;
    private String aaS;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pT() {
        return this.imgUrl;
    }

    public String sR() {
        return this.summary;
    }

    public String sS() {
        return this.aaO;
    }

    public int sT() {
        return this.aaP;
    }

    public String sU() {
        return this.aaQ;
    }

    public long sV() {
        return this.aaR;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.aaN = topCode.game_link;
            this.summary = topCode.summary;
            this.aaO = topCode.code_link;
            this.aaP = topCode.get_type.intValue();
            this.aaQ = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.aaR = 0L;
            } else {
                this.aaR = topCode.giftworth.longValue();
            }
            this.aaS = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.aaN = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aaO = jSONObject.optString("code_link");
                this.aaP = jSONObject.optInt("get_type", 1);
                this.aaQ = jSONObject.optString("surplusgift");
                this.aaR = jSONObject.optLong("giftworth", 0L);
                this.aaS = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sW() {
        return this.aaS;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
