package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bf {
    private String aPf;
    private String aPg;
    private int aPh;
    private String aPi;
    private long aPj;
    private String aPk;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String xt() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String Ai() {
        return this.aPg;
    }

    public int Aj() {
        return this.aPh;
    }

    public String Ak() {
        return this.aPi;
    }

    public long Al() {
        return this.aPj;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.aPf = topCode.game_link;
            this.summary = topCode.summary;
            this.aPg = topCode.code_link;
            this.aPh = topCode.get_type.intValue();
            this.aPi = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.aPj = 0L;
            } else {
                this.aPj = topCode.giftworth.longValue();
            }
            this.aPk = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.aPf = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aPg = jSONObject.optString("code_link");
                this.aPh = jSONObject.optInt("get_type", 1);
                this.aPi = jSONObject.optString("surplusgift");
                this.aPj = jSONObject.optLong("giftworth", 0L);
                this.aPk = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String Am() {
        return this.aPk;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
