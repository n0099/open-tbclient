package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bj {
    private String UX;
    private String UY;
    private int UZ;
    private String Va;
    private long Vb;
    private String Vc;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pS() {
        return this.imgUrl;
    }

    public String sH() {
        return this.summary;
    }

    public String sI() {
        return this.UY;
    }

    public int sJ() {
        return this.UZ;
    }

    public String sK() {
        return this.Va;
    }

    public long sL() {
        return this.Vb;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.UX = topCode.game_link;
            this.summary = topCode.summary;
            this.UY = topCode.code_link;
            this.UZ = topCode.get_type.intValue();
            this.Va = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Vb = 0L;
            } else {
                this.Vb = topCode.giftworth.longValue();
            }
            this.Vc = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.UX = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.UY = jSONObject.optString("code_link");
                this.UZ = jSONObject.optInt("get_type", 1);
                this.Va = jSONObject.optString("surplusgift");
                this.Vb = jSONObject.optLong("giftworth", 0L);
                this.Vc = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sM() {
        return this.Vc;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
