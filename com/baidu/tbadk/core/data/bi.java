package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bi {
    private String bEb;
    private String bEc;
    private int bEd;
    private String bEe;
    private long bEf;
    private String bEg;
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
        return this.bEc;
    }

    public int aaG() {
        return this.bEd;
    }

    public String aaH() {
        return this.bEe;
    }

    public long aaI() {
        return this.bEf;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.bEb = topCode.game_link;
            this.summary = topCode.summary;
            this.bEc = topCode.code_link;
            this.bEd = topCode.get_type.intValue();
            this.bEe = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.bEf = 0L;
            } else {
                this.bEf = topCode.giftworth.longValue();
            }
            this.bEg = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.bEb = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.bEc = jSONObject.optString("code_link");
                this.bEd = jSONObject.optInt("get_type", 1);
                this.bEe = jSONObject.optString("surplusgift");
                this.bEf = jSONObject.optLong("giftworth", 0L);
                this.bEg = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aaJ() {
        return this.bEg;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
