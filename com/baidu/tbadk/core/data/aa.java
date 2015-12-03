package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class aa {
    private String WN;
    private String WO;
    private String WP;
    private int WQ;
    private String WR;
    private long WS;
    private String WT;
    private String WU;
    private String summary;

    public String sB() {
        return this.WN;
    }

    public String getSummary() {
        return this.summary;
    }

    public String ti() {
        return this.WP;
    }

    public int tj() {
        return this.WQ;
    }

    public String tk() {
        return this.WR;
    }

    public long tl() {
        return this.WS;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.WN = topCode.img_url;
            this.WO = topCode.game_link;
            this.summary = topCode.summary;
            this.WP = topCode.code_link;
            this.WQ = topCode.get_type.intValue();
            this.WR = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.WS = 0L;
            } else {
                this.WS = topCode.giftworth.longValue();
            }
            this.WT = topCode.type_text;
            this.WU = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.WN = jSONObject.optString("img_url");
                this.WO = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.WP = jSONObject.optString("code_link");
                this.WQ = jSONObject.optInt("get_type", 1);
                this.WR = jSONObject.optString("surplusgift");
                this.WS = jSONObject.optLong("giftworth", 0L);
                this.WT = jSONObject.optString("type_text");
                this.WU = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String tm() {
        return this.WT;
    }

    public String tn() {
        return this.WU;
    }
}
