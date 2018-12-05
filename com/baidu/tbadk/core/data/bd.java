package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bd {
    private String avN;
    private String avO;
    private int avP;
    private String avQ;
    private long avR;
    private String avS;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String ys() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String Bn() {
        return this.avO;
    }

    public int Bo() {
        return this.avP;
    }

    public String Bp() {
        return this.avQ;
    }

    public long Bq() {
        return this.avR;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.avN = topCode.game_link;
            this.summary = topCode.summary;
            this.avO = topCode.code_link;
            this.avP = topCode.get_type.intValue();
            this.avQ = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.avR = 0L;
            } else {
                this.avR = topCode.giftworth.longValue();
            }
            this.avS = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.avN = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.avO = jSONObject.optString("code_link");
                this.avP = jSONObject.optInt("get_type", 1);
                this.avQ = jSONObject.optString("surplusgift");
                this.avR = jSONObject.optLong("giftworth", 0L);
                this.avS = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String Br() {
        return this.avS;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
