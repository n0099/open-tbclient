package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bl {
    private String ZO;
    private String ZP;
    private int ZQ;
    private String ZR;
    private long ZS;
    private String ZT;
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
        return this.ZP;
    }

    public int ty() {
        return this.ZQ;
    }

    public String tz() {
        return this.ZR;
    }

    public long tA() {
        return this.ZS;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.ZO = topCode.game_link;
            this.summary = topCode.summary;
            this.ZP = topCode.code_link;
            this.ZQ = topCode.get_type.intValue();
            this.ZR = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.ZS = 0L;
            } else {
                this.ZS = topCode.giftworth.longValue();
            }
            this.ZT = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.ZO = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.ZP = jSONObject.optString("code_link");
                this.ZQ = jSONObject.optInt("get_type", 1);
                this.ZR = jSONObject.optString("surplusgift");
                this.ZS = jSONObject.optLong("giftworth", 0L);
                this.ZT = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String tB() {
        return this.ZT;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
