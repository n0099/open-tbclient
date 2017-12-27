package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bg {
    private String aPg;
    private String aPh;
    private int aPi;
    private String aPj;
    private long aPk;
    private String aPl;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String xu() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String Aq() {
        return this.aPh;
    }

    public int Ar() {
        return this.aPi;
    }

    public String As() {
        return this.aPj;
    }

    public long At() {
        return this.aPk;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.aPg = topCode.game_link;
            this.summary = topCode.summary;
            this.aPh = topCode.code_link;
            this.aPi = topCode.get_type.intValue();
            this.aPj = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.aPk = 0L;
            } else {
                this.aPk = topCode.giftworth.longValue();
            }
            this.aPl = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.aPg = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aPh = jSONObject.optString("code_link");
                this.aPi = jSONObject.optInt("get_type", 1);
                this.aPj = jSONObject.optString("surplusgift");
                this.aPk = jSONObject.optLong("giftworth", 0L);
                this.aPl = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String Au() {
        return this.aPl;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
