package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class at {
    private String VT;
    private String VU;
    private int VV;
    private String VW;
    private long VX;
    private String VY;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String sW() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String tX() {
        return this.VU;
    }

    public int tY() {
        return this.VV;
    }

    public String tZ() {
        return this.VW;
    }

    public long ua() {
        return this.VX;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.VT = topCode.game_link;
            this.summary = topCode.summary;
            this.VU = topCode.code_link;
            this.VV = topCode.get_type.intValue();
            this.VW = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.VX = 0L;
            } else {
                this.VX = topCode.giftworth.longValue();
            }
            this.VY = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.VT = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.VU = jSONObject.optString("code_link");
                this.VV = jSONObject.optInt("get_type", 1);
                this.VW = jSONObject.optString("surplusgift");
                this.VX = jSONObject.optLong("giftworth", 0L);
                this.VY = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String ub() {
        return this.VY;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
