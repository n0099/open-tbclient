package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bi {
    private String bEa;
    private String bEb;
    private int bEc;
    private String bEd;
    private long bEe;
    private String bEf;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String Xk() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String aaF() {
        return this.bEb;
    }

    public int aaG() {
        return this.bEc;
    }

    public String aaH() {
        return this.bEd;
    }

    public long aaI() {
        return this.bEe;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.bEa = topCode.game_link;
            this.summary = topCode.summary;
            this.bEb = topCode.code_link;
            this.bEc = topCode.get_type.intValue();
            this.bEd = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.bEe = 0L;
            } else {
                this.bEe = topCode.giftworth.longValue();
            }
            this.bEf = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.bEa = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.bEb = jSONObject.optString("code_link");
                this.bEc = jSONObject.optInt("get_type", 1);
                this.bEd = jSONObject.optString("surplusgift");
                this.bEe = jSONObject.optLong("giftworth", 0L);
                this.bEf = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aaJ() {
        return this.bEf;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
