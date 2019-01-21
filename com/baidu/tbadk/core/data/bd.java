package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bd {
    private String awr;
    private String aws;
    private int awt;
    private String awu;
    private long awv;
    private String aww;
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
        return this.aws;
    }

    public int BB() {
        return this.awt;
    }

    public String BC() {
        return this.awu;
    }

    public long BD() {
        return this.awv;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.awr = topCode.game_link;
            this.summary = topCode.summary;
            this.aws = topCode.code_link;
            this.awt = topCode.get_type.intValue();
            this.awu = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.awv = 0L;
            } else {
                this.awv = topCode.giftworth.longValue();
            }
            this.aww = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.awr = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aws = jSONObject.optString("code_link");
                this.awt = jSONObject.optInt("get_type", 1);
                this.awu = jSONObject.optString("surplusgift");
                this.awv = jSONObject.optLong("giftworth", 0L);
                this.aww = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String BE() {
        return this.aww;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
