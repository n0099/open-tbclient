package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bp {
    private String Zl;
    private String Zm;
    private int Zn;
    private String Zo;
    private long Zp;
    private String Zq;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pI() {
        return this.imgUrl;
    }

    public String sG() {
        return this.summary;
    }

    public String sH() {
        return this.Zm;
    }

    public int sI() {
        return this.Zn;
    }

    public String sJ() {
        return this.Zo;
    }

    public long sK() {
        return this.Zp;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.Zl = topCode.game_link;
            this.summary = topCode.summary;
            this.Zm = topCode.code_link;
            this.Zn = topCode.get_type.intValue();
            this.Zo = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Zp = 0L;
            } else {
                this.Zp = topCode.giftworth.longValue();
            }
            this.Zq = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.Zl = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Zm = jSONObject.optString("code_link");
                this.Zn = jSONObject.optInt("get_type", 1);
                this.Zo = jSONObject.optString("surplusgift");
                this.Zp = jSONObject.optLong("giftworth", 0L);
                this.Zq = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sL() {
        return this.Zq;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
