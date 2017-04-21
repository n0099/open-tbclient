package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bl {
    private String ZP;
    private String ZQ;
    private int ZR;
    private String ZS;
    private long ZT;
    private String ZU;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String qB() {
        return this.imgUrl;
    }

    public String tw() {
        return this.summary;
    }

    public String tx() {
        return this.ZQ;
    }

    public int ty() {
        return this.ZR;
    }

    public String tz() {
        return this.ZS;
    }

    public long tA() {
        return this.ZT;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.ZP = topCode.game_link;
            this.summary = topCode.summary;
            this.ZQ = topCode.code_link;
            this.ZR = topCode.get_type.intValue();
            this.ZS = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.ZT = 0L;
            } else {
                this.ZT = topCode.giftworth.longValue();
            }
            this.ZU = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.ZP = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.ZQ = jSONObject.optString("code_link");
                this.ZR = jSONObject.optInt("get_type", 1);
                this.ZS = jSONObject.optString("surplusgift");
                this.ZT = jSONObject.optLong("giftworth", 0L);
                this.ZU = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String tB() {
        return this.ZU;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
