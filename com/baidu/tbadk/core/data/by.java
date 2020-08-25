package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes2.dex */
public class by {
    private String eeD;
    private String eeE;
    private int eeF;
    private String eeG;
    private long eeH;
    private String eeI;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String bcA() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String bgN() {
        return this.eeE;
    }

    public int bgO() {
        return this.eeF;
    }

    public String bgP() {
        return this.eeG;
    }

    public long bgQ() {
        return this.eeH;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.eeD = topCode.game_link;
            this.summary = topCode.summary;
            this.eeE = topCode.code_link;
            this.eeF = topCode.get_type.intValue();
            this.eeG = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.eeH = 0L;
            } else {
                this.eeH = topCode.giftworth.longValue();
            }
            this.eeI = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.eeD = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.eeE = jSONObject.optString("code_link");
                this.eeF = jSONObject.optInt("get_type", 1);
                this.eeG = jSONObject.optString("surplusgift");
                this.eeH = jSONObject.optLong("giftworth", 0L);
                this.eeI = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String bgR() {
        return this.eeI;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
