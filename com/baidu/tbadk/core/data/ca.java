package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class ca {
    private String eML;
    private String eMM;
    private int eMN;
    private String eMO;
    private long eMP;
    private String eMQ;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String bmL() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String brc() {
        return this.eMM;
    }

    public int brd() {
        return this.eMN;
    }

    public String bre() {
        return this.eMO;
    }

    public long brf() {
        return this.eMP;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.eML = topCode.game_link;
            this.summary = topCode.summary;
            this.eMM = topCode.code_link;
            this.eMN = topCode.get_type.intValue();
            this.eMO = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.eMP = 0L;
            } else {
                this.eMP = topCode.giftworth.longValue();
            }
            this.eMQ = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.eML = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.eMM = jSONObject.optString("code_link");
                this.eMN = jSONObject.optInt("get_type", 1);
                this.eMO = jSONObject.optString("surplusgift");
                this.eMP = jSONObject.optLong("giftworth", 0L);
                this.eMQ = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String brg() {
        return this.eMQ;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
