package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bf {
    private String akb;
    private String akc;
    private int akd;
    private String ake;
    private long akf;
    private String akg;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String ub() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String wI() {
        return this.akc;
    }

    public int wJ() {
        return this.akd;
    }

    public String wK() {
        return this.ake;
    }

    public long wL() {
        return this.akf;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.akb = topCode.game_link;
            this.summary = topCode.summary;
            this.akc = topCode.code_link;
            this.akd = topCode.get_type.intValue();
            this.ake = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.akf = 0L;
            } else {
                this.akf = topCode.giftworth.longValue();
            }
            this.akg = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.akb = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.akc = jSONObject.optString("code_link");
                this.akd = jSONObject.optInt("get_type", 1);
                this.ake = jSONObject.optString("surplusgift");
                this.akf = jSONObject.optLong("giftworth", 0L);
                this.akg = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String wM() {
        return this.akg;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
