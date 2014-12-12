package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class x {
    private String EW;
    private String EX;
    private int EY;
    private String EZ;
    private long Fa;
    private String imgUrl;
    private String summary;

    public String mN() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String nL() {
        return this.EX;
    }

    public int nM() {
        return this.EY;
    }

    public String nN() {
        return this.EZ;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.EW = topCode.game_link;
            this.summary = topCode.summary;
            this.EX = topCode.code_link;
            this.EY = topCode.get_type.intValue();
            this.EZ = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.Fa = 0L;
            } else {
                this.Fa = topCode.giftworth.longValue();
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.EW = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.EX = jSONObject.optString("code_link");
                this.EY = jSONObject.optInt("get_type", 1);
                this.EZ = jSONObject.optString("surplusgift");
                this.Fa = jSONObject.optLong("giftworth", 0L);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
