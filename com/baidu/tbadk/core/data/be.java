package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class be {
    private String akA;
    private String akB;
    private int akC;
    private String akD;
    private long akE;
    private String akF;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String uh() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String wV() {
        return this.akB;
    }

    public int wW() {
        return this.akC;
    }

    public String wX() {
        return this.akD;
    }

    public long wY() {
        return this.akE;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.akA = topCode.game_link;
            this.summary = topCode.summary;
            this.akB = topCode.code_link;
            this.akC = topCode.get_type.intValue();
            this.akD = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.akE = 0L;
            } else {
                this.akE = topCode.giftworth.longValue();
            }
            this.akF = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.akA = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.akB = jSONObject.optString("code_link");
                this.akC = jSONObject.optInt("get_type", 1);
                this.akD = jSONObject.optString("surplusgift");
                this.akE = jSONObject.optLong("giftworth", 0L);
                this.akF = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String wZ() {
        return this.akF;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
