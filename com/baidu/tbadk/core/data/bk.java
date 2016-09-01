package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bk {
    private String UW;
    private String UX;
    private int UY;
    private String UZ;
    private long Va;
    private String Vb;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String rc() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String sE() {
        return this.UX;
    }

    public int sF() {
        return this.UY;
    }

    public String sG() {
        return this.UZ;
    }

    public long sH() {
        return this.Va;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.UW = topCode.game_link;
            this.summary = topCode.summary;
            this.UX = topCode.code_link;
            this.UY = topCode.get_type.intValue();
            this.UZ = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Va = 0L;
            } else {
                this.Va = topCode.giftworth.longValue();
            }
            this.Vb = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.UW = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.UX = jSONObject.optString("code_link");
                this.UY = jSONObject.optInt("get_type", 1);
                this.UZ = jSONObject.optString("surplusgift");
                this.Va = jSONObject.optLong("giftworth", 0L);
                this.Vb = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sI() {
        return this.Vb;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
