package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bd {
    private String awq;
    private String awr;
    private int aws;
    private String awt;
    private long awu;
    private String awv;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String yF() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String BA() {
        return this.awr;
    }

    public int BB() {
        return this.aws;
    }

    public String BC() {
        return this.awt;
    }

    public long BD() {
        return this.awu;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.awq = topCode.game_link;
            this.summary = topCode.summary;
            this.awr = topCode.code_link;
            this.aws = topCode.get_type.intValue();
            this.awt = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.awu = 0L;
            } else {
                this.awu = topCode.giftworth.longValue();
            }
            this.awv = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.awq = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.awr = jSONObject.optString("code_link");
                this.aws = jSONObject.optInt("get_type", 1);
                this.awt = jSONObject.optString("surplusgift");
                this.awu = jSONObject.optLong("giftworth", 0L);
                this.awv = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String BE() {
        return this.awv;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
