package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class aa {
    private String Xp;
    private String Xq;
    private String Xr;
    private int Xs;
    private String Xt;
    private long Xu;
    private String Xv;
    private String Xw;
    private String summary;

    public String sk() {
        return this.Xp;
    }

    public String getSummary() {
        return this.summary;
    }

    public String sS() {
        return this.Xr;
    }

    public int sT() {
        return this.Xs;
    }

    public String sU() {
        return this.Xt;
    }

    public long sV() {
        return this.Xu;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.Xp = topCode.img_url;
            this.Xq = topCode.game_link;
            this.summary = topCode.summary;
            this.Xr = topCode.code_link;
            this.Xs = topCode.get_type.intValue();
            this.Xt = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Xu = 0L;
            } else {
                this.Xu = topCode.giftworth.longValue();
            }
            this.Xv = topCode.type_text;
            this.Xw = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Xp = jSONObject.optString("img_url");
                this.Xq = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Xr = jSONObject.optString("code_link");
                this.Xs = jSONObject.optInt("get_type", 1);
                this.Xt = jSONObject.optString("surplusgift");
                this.Xu = jSONObject.optLong("giftworth", 0L);
                this.Xv = jSONObject.optString("type_text");
                this.Xw = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sW() {
        return this.Xv;
    }

    public String sX() {
        return this.Xw;
    }
}
