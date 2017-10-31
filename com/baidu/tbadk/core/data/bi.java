package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bi {
    private String aas;
    private String aat;
    private int aau;
    private String aav;
    private long aaw;
    private String aax;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pQ() {
        return this.imgUrl;
    }

    public String sO() {
        return this.summary;
    }

    public String sP() {
        return this.aat;
    }

    public int sQ() {
        return this.aau;
    }

    public String sR() {
        return this.aav;
    }

    public long sS() {
        return this.aaw;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.aas = topCode.game_link;
            this.summary = topCode.summary;
            this.aat = topCode.code_link;
            this.aau = topCode.get_type.intValue();
            this.aav = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.aaw = 0L;
            } else {
                this.aaw = topCode.giftworth.longValue();
            }
            this.aax = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.aas = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aat = jSONObject.optString("code_link");
                this.aau = jSONObject.optInt("get_type", 1);
                this.aav = jSONObject.optString("surplusgift");
                this.aaw = jSONObject.optLong("giftworth", 0L);
                this.aax = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sT() {
        return this.aax;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
