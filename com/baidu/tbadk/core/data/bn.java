package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bn {
    private String Zk;
    private String Zl;
    private int Zm;
    private String Zn;
    private long Zo;
    private String Zp;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pT() {
        return this.imgUrl;
    }

    public String sJ() {
        return this.summary;
    }

    public String sK() {
        return this.Zl;
    }

    public int sL() {
        return this.Zm;
    }

    public String sM() {
        return this.Zn;
    }

    public long sN() {
        return this.Zo;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.Zk = topCode.game_link;
            this.summary = topCode.summary;
            this.Zl = topCode.code_link;
            this.Zm = topCode.get_type.intValue();
            this.Zn = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Zo = 0L;
            } else {
                this.Zo = topCode.giftworth.longValue();
            }
            this.Zp = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.Zk = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Zl = jSONObject.optString("code_link");
                this.Zm = jSONObject.optInt("get_type", 1);
                this.Zn = jSONObject.optString("surplusgift");
                this.Zo = jSONObject.optLong("giftworth", 0L);
                this.Zp = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sO() {
        return this.Zp;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
