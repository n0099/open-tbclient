package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class x {
    private String Ri;
    private String Rj;
    private String Rk;
    private int Rl;
    private String Rm;
    private long Rn;
    private String summary;

    public String rg() {
        return this.Ri;
    }

    public String getSummary() {
        return this.summary;
    }

    public String rB() {
        return this.Rk;
    }

    public int rC() {
        return this.Rl;
    }

    public String rD() {
        return this.Rm;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.Ri = topCode.img_url;
            this.Rj = topCode.game_link;
            this.summary = topCode.summary;
            this.Rk = topCode.code_link;
            this.Rl = topCode.get_type.intValue();
            this.Rm = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Rn = 0L;
            } else {
                this.Rn = topCode.giftworth.longValue();
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ri = jSONObject.optString("img_url");
                this.Rj = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Rk = jSONObject.optString("code_link");
                this.Rl = jSONObject.optInt("get_type", 1);
                this.Rm = jSONObject.optString("surplusgift");
                this.Rn = jSONObject.optLong("giftworth", 0L);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
