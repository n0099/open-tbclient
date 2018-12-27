package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bd {
    private String avO;
    private String avP;
    private int avQ;
    private String avR;
    private long avS;
    private String avT;
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
        return this.avP;
    }

    public int Bo() {
        return this.avQ;
    }

    public String Bp() {
        return this.avR;
    }

    public long Bq() {
        return this.avS;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.avO = topCode.game_link;
            this.summary = topCode.summary;
            this.avP = topCode.code_link;
            this.avQ = topCode.get_type.intValue();
            this.avR = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.avS = 0L;
            } else {
                this.avS = topCode.giftworth.longValue();
            }
            this.avT = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.avO = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.avP = jSONObject.optString("code_link");
                this.avQ = jSONObject.optInt("get_type", 1);
                this.avR = jSONObject.optString("surplusgift");
                this.avS = jSONObject.optLong("giftworth", 0L);
                this.avT = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String Br() {
        return this.avT;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
