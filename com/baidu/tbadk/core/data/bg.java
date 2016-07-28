package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bg {
    private String Sg;
    private String Sh;
    private int Si;
    private String Sj;
    private long Sk;
    private String Sl;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pY() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String rz() {
        return this.Sh;
    }

    public int rA() {
        return this.Si;
    }

    public String rB() {
        return this.Sj;
    }

    public long rC() {
        return this.Sk;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.Sg = topCode.game_link;
            this.summary = topCode.summary;
            this.Sh = topCode.code_link;
            this.Si = topCode.get_type.intValue();
            this.Sj = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Sk = 0L;
            } else {
                this.Sk = topCode.giftworth.longValue();
            }
            this.Sl = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.Sg = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Sh = jSONObject.optString("code_link");
                this.Si = jSONObject.optInt("get_type", 1);
                this.Sj = jSONObject.optString("surplusgift");
                this.Sk = jSONObject.optLong("giftworth", 0L);
                this.Sl = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String rD() {
        return this.Sl;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
