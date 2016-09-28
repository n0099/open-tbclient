package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bm {
    private String Vg;
    private String Vh;
    private int Vi;
    private String Vj;
    private long Vk;
    private String Vl;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pO() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String sT() {
        return this.Vh;
    }

    public int sU() {
        return this.Vi;
    }

    public String sV() {
        return this.Vj;
    }

    public long sW() {
        return this.Vk;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.Vg = topCode.game_link;
            this.summary = topCode.summary;
            this.Vh = topCode.code_link;
            this.Vi = topCode.get_type.intValue();
            this.Vj = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Vk = 0L;
            } else {
                this.Vk = topCode.giftworth.longValue();
            }
            this.Vl = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.Vg = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Vh = jSONObject.optString("code_link");
                this.Vi = jSONObject.optInt("get_type", 1);
                this.Vj = jSONObject.optString("surplusgift");
                this.Vk = jSONObject.optLong("giftworth", 0L);
                this.Vl = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sX() {
        return this.Vl;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
