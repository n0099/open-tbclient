package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bo {
    private String Zj;
    private String Zk;
    private int Zl;
    private String Zm;
    private long Zn;
    private String Zo;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pL() {
        return this.imgUrl;
    }

    public String sI() {
        return this.summary;
    }

    public String sJ() {
        return this.Zk;
    }

    public int sK() {
        return this.Zl;
    }

    public String sL() {
        return this.Zm;
    }

    public long sM() {
        return this.Zn;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.Zj = topCode.game_link;
            this.summary = topCode.summary;
            this.Zk = topCode.code_link;
            this.Zl = topCode.get_type.intValue();
            this.Zm = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Zn = 0L;
            } else {
                this.Zn = topCode.giftworth.longValue();
            }
            this.Zo = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.Zj = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Zk = jSONObject.optString("code_link");
                this.Zl = jSONObject.optInt("get_type", 1);
                this.Zm = jSONObject.optString("surplusgift");
                this.Zn = jSONObject.optLong("giftworth", 0L);
                this.Zo = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sN() {
        return this.Zo;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
