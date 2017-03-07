package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bm {
    private int ZA;
    private String ZB;
    private long ZC;
    private String ZD;
    private String Zy;
    private String Zz;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String qd() {
        return this.imgUrl;
    }

    public String sY() {
        return this.summary;
    }

    public String sZ() {
        return this.Zz;
    }

    public int ta() {
        return this.ZA;
    }

    public String tb() {
        return this.ZB;
    }

    public long tc() {
        return this.ZC;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.Zy = topCode.game_link;
            this.summary = topCode.summary;
            this.Zz = topCode.code_link;
            this.ZA = topCode.get_type.intValue();
            this.ZB = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.ZC = 0L;
            } else {
                this.ZC = topCode.giftworth.longValue();
            }
            this.ZD = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.Zy = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Zz = jSONObject.optString("code_link");
                this.ZA = jSONObject.optInt("get_type", 1);
                this.ZB = jSONObject.optString("surplusgift");
                this.ZC = jSONObject.optLong("giftworth", 0L);
                this.ZD = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String td() {
        return this.ZD;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
