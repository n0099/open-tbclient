package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class y {
    private String EX;
    private String EY;
    private String EZ;
    private int Fa;
    private String Fb;
    private long Fc;
    private String summary;

    public String mI() {
        return this.EX;
    }

    public String getSummary() {
        return this.summary;
    }

    public String nH() {
        return this.EZ;
    }

    public int nI() {
        return this.Fa;
    }

    public String nJ() {
        return this.Fb;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.EX = topCode.img_url;
            this.EY = topCode.game_link;
            this.summary = topCode.summary;
            this.EZ = topCode.code_link;
            this.Fa = topCode.get_type.intValue();
            this.Fb = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Fc = 0L;
            } else {
                this.Fc = topCode.giftworth.longValue();
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.EX = jSONObject.optString("img_url");
                this.EY = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.EZ = jSONObject.optString("code_link");
                this.Fa = jSONObject.optInt("get_type", 1);
                this.Fb = jSONObject.optString("surplusgift");
                this.Fc = jSONObject.optLong("giftworth", 0L);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
