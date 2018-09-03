package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bd {
    private String ajZ;
    private String aka;
    private int akb;
    private String akc;
    private long akd;
    private String ake;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String tT() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String wM() {
        return this.aka;
    }

    public int wN() {
        return this.akb;
    }

    public String wO() {
        return this.akc;
    }

    public long wP() {
        return this.akd;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.ajZ = topCode.game_link;
            this.summary = topCode.summary;
            this.aka = topCode.code_link;
            this.akb = topCode.get_type.intValue();
            this.akc = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.akd = 0L;
            } else {
                this.akd = topCode.giftworth.longValue();
            }
            this.ake = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.ajZ = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aka = jSONObject.optString("code_link");
                this.akb = jSONObject.optInt("get_type", 1);
                this.akc = jSONObject.optString("surplusgift");
                this.akd = jSONObject.optLong("giftworth", 0L);
                this.ake = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String wQ() {
        return this.ake;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
