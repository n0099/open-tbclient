package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bf {
    private String aQu;
    private String aQv;
    private int aQw;
    private String aQx;
    private long aQy;
    private String aQz;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String ya() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String AC() {
        return this.aQv;
    }

    public int AD() {
        return this.aQw;
    }

    public String AE() {
        return this.aQx;
    }

    public long AF() {
        return this.aQy;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.aQu = topCode.game_link;
            this.summary = topCode.summary;
            this.aQv = topCode.code_link;
            this.aQw = topCode.get_type.intValue();
            this.aQx = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.aQy = 0L;
            } else {
                this.aQy = topCode.giftworth.longValue();
            }
            this.aQz = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.aQu = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aQv = jSONObject.optString("code_link");
                this.aQw = jSONObject.optInt("get_type", 1);
                this.aQx = jSONObject.optString("surplusgift");
                this.aQy = jSONObject.optLong("giftworth", 0L);
                this.aQz = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String AG() {
        return this.aQz;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
