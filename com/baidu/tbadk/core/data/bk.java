package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bk {
    private String Ul;
    private String Um;
    private int Un;
    private String Uo;
    private long Up;
    private String Uq;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pL() {
        return this.imgUrl;
    }

    public String sB() {
        return this.summary;
    }

    public String sC() {
        return this.Um;
    }

    public int sD() {
        return this.Un;
    }

    public String sE() {
        return this.Uo;
    }

    public long sF() {
        return this.Up;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.Ul = topCode.game_link;
            this.summary = topCode.summary;
            this.Um = topCode.code_link;
            this.Un = topCode.get_type.intValue();
            this.Uo = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Up = 0L;
            } else {
                this.Up = topCode.giftworth.longValue();
            }
            this.Uq = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.Ul = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Um = jSONObject.optString("code_link");
                this.Un = jSONObject.optInt("get_type", 1);
                this.Uo = jSONObject.optString("surplusgift");
                this.Up = jSONObject.optLong("giftworth", 0L);
                this.Uq = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sG() {
        return this.Uq;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
