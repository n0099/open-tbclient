package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bf {
    private String aPi;
    private String aPj;
    private int aPk;
    private String aPl;
    private long aPm;
    private String aPn;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String xu() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String Aj() {
        return this.aPj;
    }

    public int Ak() {
        return this.aPk;
    }

    public String Al() {
        return this.aPl;
    }

    public long Am() {
        return this.aPm;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.aPi = topCode.game_link;
            this.summary = topCode.summary;
            this.aPj = topCode.code_link;
            this.aPk = topCode.get_type.intValue();
            this.aPl = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.aPm = 0L;
            } else {
                this.aPm = topCode.giftworth.longValue();
            }
            this.aPn = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.aPi = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aPj = jSONObject.optString("code_link");
                this.aPk = jSONObject.optInt("get_type", 1);
                this.aPl = jSONObject.optString("surplusgift");
                this.aPm = jSONObject.optLong("giftworth", 0L);
                this.aPn = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String An() {
        return this.aPn;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
