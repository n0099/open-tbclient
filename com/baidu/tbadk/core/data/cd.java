package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class cd {
    private String eVL;
    private String eVM;
    private int eVN;
    private String eVO;
    private long eVP;
    private String eVQ;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String bqf() {
        return this.eVM;
    }

    public int bqg() {
        return this.eVN;
    }

    public String bqh() {
        return this.eVO;
    }

    public long bqi() {
        return this.eVP;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.eVL = topCode.game_link;
            this.summary = topCode.summary;
            this.eVM = topCode.code_link;
            this.eVN = topCode.get_type.intValue();
            this.eVO = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.eVP = 0L;
            } else {
                this.eVP = topCode.giftworth.longValue();
            }
            this.eVQ = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.eVL = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.eVM = jSONObject.optString("code_link");
                this.eVN = jSONObject.optInt("get_type", 1);
                this.eVO = jSONObject.optString("surplusgift");
                this.eVP = jSONObject.optLong("giftworth", 0L);
                this.eVQ = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String bqj() {
        return this.eVQ;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
