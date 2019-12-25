package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bl {
    private String cQq;
    private String cQr;
    private int cQs;
    private String cQt;
    private long cQu;
    private String cQv;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String axX() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String aBH() {
        return this.cQr;
    }

    public int aBI() {
        return this.cQs;
    }

    public String aBJ() {
        return this.cQt;
    }

    public long aBK() {
        return this.cQu;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.cQq = topCode.game_link;
            this.summary = topCode.summary;
            this.cQr = topCode.code_link;
            this.cQs = topCode.get_type.intValue();
            this.cQt = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.cQu = 0L;
            } else {
                this.cQu = topCode.giftworth.longValue();
            }
            this.cQv = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.cQq = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.cQr = jSONObject.optString("code_link");
                this.cQs = jSONObject.optInt("get_type", 1);
                this.cQt = jSONObject.optString("surplusgift");
                this.cQu = jSONObject.optLong("giftworth", 0L);
                this.cQv = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aBL() {
        return this.cQv;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
