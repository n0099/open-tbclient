package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bo {
    private String VE;
    private String VF;
    private int VG;
    private String VH;
    private long VI;
    private String VJ;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pR() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String sX() {
        return this.VF;
    }

    public int sY() {
        return this.VG;
    }

    public String sZ() {
        return this.VH;
    }

    public long ta() {
        return this.VI;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.VE = topCode.game_link;
            this.summary = topCode.summary;
            this.VF = topCode.code_link;
            this.VG = topCode.get_type.intValue();
            this.VH = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.VI = 0L;
            } else {
                this.VI = topCode.giftworth.longValue();
            }
            this.VJ = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.VE = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.VF = jSONObject.optString("code_link");
                this.VG = jSONObject.optInt("get_type", 1);
                this.VH = jSONObject.optString("surplusgift");
                this.VI = jSONObject.optLong("giftworth", 0L);
                this.VJ = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String tb() {
        return this.VJ;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
