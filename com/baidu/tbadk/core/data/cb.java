package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class cb {
    private String eRY;
    private String eRZ;
    private int eSa;
    private String eSb;
    private long eSc;
    private String eSd;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String bpL() {
        return this.eRZ;
    }

    public int bpM() {
        return this.eSa;
    }

    public String bpN() {
        return this.eSb;
    }

    public long bpO() {
        return this.eSc;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.eRY = topCode.game_link;
            this.summary = topCode.summary;
            this.eRZ = topCode.code_link;
            this.eSa = topCode.get_type.intValue();
            this.eSb = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.eSc = 0L;
            } else {
                this.eSc = topCode.giftworth.longValue();
            }
            this.eSd = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.eRY = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.eRZ = jSONObject.optString("code_link");
                this.eSa = jSONObject.optInt("get_type", 1);
                this.eSb = jSONObject.optString("surplusgift");
                this.eSc = jSONObject.optLong("giftworth", 0L);
                this.eSd = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String bpP() {
        return this.eSd;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
