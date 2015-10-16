package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class x {
    private String Wa;
    private String Wb;
    private String Wc;
    private int Wd;
    private String We;
    private long Wf;
    private String summary;

    public String sf() {
        return this.Wa;
    }

    public String getSummary() {
        return this.summary;
    }

    public String sH() {
        return this.Wc;
    }

    public int sI() {
        return this.Wd;
    }

    public String sJ() {
        return this.We;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.Wa = topCode.img_url;
            this.Wb = topCode.game_link;
            this.summary = topCode.summary;
            this.Wc = topCode.code_link;
            this.Wd = topCode.get_type.intValue();
            this.We = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Wf = 0L;
            } else {
                this.Wf = topCode.giftworth.longValue();
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wa = jSONObject.optString("img_url");
                this.Wb = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Wc = jSONObject.optString("code_link");
                this.Wd = jSONObject.optInt("get_type", 1);
                this.We = jSONObject.optString("surplusgift");
                this.Wf = jSONObject.optLong("giftworth", 0L);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
