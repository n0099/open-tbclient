package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class cd {
    private String eUm;
    private String eUn;
    private int eUo;
    private String eUp;
    private long eUq;
    private String eUr;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String bqd() {
        return this.eUn;
    }

    public int bqe() {
        return this.eUo;
    }

    public String bqf() {
        return this.eUp;
    }

    public long bqg() {
        return this.eUq;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.eUm = topCode.game_link;
            this.summary = topCode.summary;
            this.eUn = topCode.code_link;
            this.eUo = topCode.get_type.intValue();
            this.eUp = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.eUq = 0L;
            } else {
                this.eUq = topCode.giftworth.longValue();
            }
            this.eUr = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.eUm = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.eUn = jSONObject.optString("code_link");
                this.eUo = jSONObject.optInt("get_type", 1);
                this.eUp = jSONObject.optString("surplusgift");
                this.eUq = jSONObject.optLong("giftworth", 0L);
                this.eUr = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String bqh() {
        return this.eUr;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
