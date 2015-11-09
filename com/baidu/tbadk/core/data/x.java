package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class x {
    private String Wd;
    private String We;
    private String Wf;
    private int Wg;
    private String Wh;
    private long Wi;
    private String summary;

    public String se() {
        return this.Wd;
    }

    public String getSummary() {
        return this.summary;
    }

    public String sH() {
        return this.Wf;
    }

    public int sI() {
        return this.Wg;
    }

    public String sJ() {
        return this.Wh;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.Wd = topCode.img_url;
            this.We = topCode.game_link;
            this.summary = topCode.summary;
            this.Wf = topCode.code_link;
            this.Wg = topCode.get_type.intValue();
            this.Wh = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Wi = 0L;
            } else {
                this.Wi = topCode.giftworth.longValue();
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wd = jSONObject.optString("img_url");
                this.We = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Wf = jSONObject.optString("code_link");
                this.Wg = jSONObject.optInt("get_type", 1);
                this.Wh = jSONObject.optString("surplusgift");
                this.Wi = jSONObject.optLong("giftworth", 0L);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
