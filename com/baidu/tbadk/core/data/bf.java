package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bf {
    private String aaH;
    private String aaI;
    private int aaJ;
    private String aaK;
    private long aaL;
    private String aaM;
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
        return this.aaI;
    }

    public int sQ() {
        return this.aaJ;
    }

    public String sR() {
        return this.aaK;
    }

    public long sS() {
        return this.aaL;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.aaH = topCode.game_link;
            this.summary = topCode.summary;
            this.aaI = topCode.code_link;
            this.aaJ = topCode.get_type.intValue();
            this.aaK = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.aaL = 0L;
            } else {
                this.aaL = topCode.giftworth.longValue();
            }
            this.aaM = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.aaH = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aaI = jSONObject.optString("code_link");
                this.aaJ = jSONObject.optInt("get_type", 1);
                this.aaK = jSONObject.optString("surplusgift");
                this.aaL = jSONObject.optLong("giftworth", 0L);
                this.aaM = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sT() {
        return this.aaM;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
