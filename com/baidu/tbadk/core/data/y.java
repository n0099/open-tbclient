package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class y {
    private String Wg;
    private String Wh;
    private String Wi;
    private int Wj;
    private String Wk;
    private long Wl;
    private String summary;

    public String sk() {
        return this.Wg;
    }

    public String getSummary() {
        return this.summary;
    }

    public String sK() {
        return this.Wi;
    }

    public int sL() {
        return this.Wj;
    }

    public String sM() {
        return this.Wk;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.Wg = topCode.img_url;
            this.Wh = topCode.game_link;
            this.summary = topCode.summary;
            this.Wi = topCode.code_link;
            this.Wj = topCode.get_type.intValue();
            this.Wk = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Wl = 0L;
            } else {
                this.Wl = topCode.giftworth.longValue();
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wg = jSONObject.optString("img_url");
                this.Wh = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Wi = jSONObject.optString("code_link");
                this.Wj = jSONObject.optInt("get_type", 1);
                this.Wk = jSONObject.optString("surplusgift");
                this.Wl = jSONObject.optLong("giftworth", 0L);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
