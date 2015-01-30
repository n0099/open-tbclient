package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class y {
    private String Fa;
    private String Fb;
    private String Fc;
    private int Fd;
    private String Fe;
    private long Ff;
    private String summary;

    public String mP() {
        return this.Fa;
    }

    public String getSummary() {
        return this.summary;
    }

    public String nO() {
        return this.Fc;
    }

    public int nP() {
        return this.Fd;
    }

    public String nQ() {
        return this.Fe;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.Fa = topCode.img_url;
            this.Fb = topCode.game_link;
            this.summary = topCode.summary;
            this.Fc = topCode.code_link;
            this.Fd = topCode.get_type.intValue();
            this.Fe = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Ff = 0L;
            } else {
                this.Ff = topCode.giftworth.longValue();
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Fa = jSONObject.optString("img_url");
                this.Fb = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Fc = jSONObject.optString("code_link");
                this.Fd = jSONObject.optInt("get_type", 1);
                this.Fe = jSONObject.optString("surplusgift");
                this.Ff = jSONObject.optLong("giftworth", 0L);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
