package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bi {
    private String aah;
    private String aai;
    private int aaj;
    private String aak;
    private long aal;
    private String aam;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pS() {
        return this.imgUrl;
    }

    public String sO() {
        return this.summary;
    }

    public String sP() {
        return this.aai;
    }

    public int sQ() {
        return this.aaj;
    }

    public String sR() {
        return this.aak;
    }

    public long sS() {
        return this.aal;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.aah = topCode.game_link;
            this.summary = topCode.summary;
            this.aai = topCode.code_link;
            this.aaj = topCode.get_type.intValue();
            this.aak = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.aal = 0L;
            } else {
                this.aal = topCode.giftworth.longValue();
            }
            this.aam = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.aah = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aai = jSONObject.optString("code_link");
                this.aaj = jSONObject.optInt("get_type", 1);
                this.aak = jSONObject.optString("surplusgift");
                this.aal = jSONObject.optLong("giftworth", 0L);
                this.aam = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sT() {
        return this.aam;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
