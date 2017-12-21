package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bf {
    private String aaK;
    private String aaL;
    private int aaM;
    private String aaN;
    private long aaO;
    private String aaP;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pR() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String sP() {
        return this.aaL;
    }

    public int sQ() {
        return this.aaM;
    }

    public String sR() {
        return this.aaN;
    }

    public long sS() {
        return this.aaO;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.aaK = topCode.game_link;
            this.summary = topCode.summary;
            this.aaL = topCode.code_link;
            this.aaM = topCode.get_type.intValue();
            this.aaN = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.aaO = 0L;
            } else {
                this.aaO = topCode.giftworth.longValue();
            }
            this.aaP = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.aaK = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aaL = jSONObject.optString("code_link");
                this.aaM = jSONObject.optInt("get_type", 1);
                this.aaN = jSONObject.optString("surplusgift");
                this.aaO = jSONObject.optLong("giftworth", 0L);
                this.aaP = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sT() {
        return this.aaP;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
