package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class r {
    private String AI;
    private String AJ;
    private String AK;
    private int AL;
    private String AM;
    private long AN;
    private String summary;

    public String kJ() {
        return this.AI;
    }

    public String kK() {
        return this.summary;
    }

    public String kL() {
        return this.AK;
    }

    public int kM() {
        return this.AL;
    }

    public String kN() {
        return this.AM;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.AI = topCode.img_url;
            this.AJ = topCode.game_link;
            this.summary = topCode.summary;
            this.AK = topCode.code_link;
            this.AL = topCode.get_type.intValue();
            this.AM = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.AN = 0L;
            } else {
                this.AN = topCode.giftworth.longValue();
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.AI = jSONObject.optString("img_url");
                this.AJ = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.AK = jSONObject.optString("code_link");
                this.AL = jSONObject.optInt("get_type", 1);
                this.AM = jSONObject.optString("surplusgift");
                this.AN = jSONObject.optLong("giftworth", 0L);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
