package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class w {
    private String VY;
    private String VZ;
    private String Wa;
    private int Wb;
    private String Wc;
    private long Wd;
    private String summary;

    public String sf() {
        return this.VY;
    }

    public String getSummary() {
        return this.summary;
    }

    public String sH() {
        return this.Wa;
    }

    public int sI() {
        return this.Wb;
    }

    public String sJ() {
        return this.Wc;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.VY = topCode.img_url;
            this.VZ = topCode.game_link;
            this.summary = topCode.summary;
            this.Wa = topCode.code_link;
            this.Wb = topCode.get_type.intValue();
            this.Wc = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Wd = 0L;
            } else {
                this.Wd = topCode.giftworth.longValue();
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VY = jSONObject.optString("img_url");
                this.VZ = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.Wa = jSONObject.optString("code_link");
                this.Wb = jSONObject.optInt("get_type", 1);
                this.Wc = jSONObject.optString("surplusgift");
                this.Wd = jSONObject.optLong("giftworth", 0L);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
