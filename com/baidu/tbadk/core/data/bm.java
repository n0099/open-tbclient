package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bm {
    private String ZD;
    private String ZE;
    private int ZF;
    private String ZG;
    private long ZH;
    private String ZI;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pL() {
        return this.imgUrl;
    }

    public String sN() {
        return this.summary;
    }

    public String sO() {
        return this.ZE;
    }

    public int sP() {
        return this.ZF;
    }

    public String sQ() {
        return this.ZG;
    }

    public long sR() {
        return this.ZH;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.ZD = topCode.game_link;
            this.summary = topCode.summary;
            this.ZE = topCode.code_link;
            this.ZF = topCode.get_type.intValue();
            this.ZG = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.ZH = 0L;
            } else {
                this.ZH = topCode.giftworth.longValue();
            }
            this.ZI = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.ZD = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.ZE = jSONObject.optString("code_link");
                this.ZF = jSONObject.optInt("get_type", 1);
                this.ZG = jSONObject.optString("surplusgift");
                this.ZH = jSONObject.optLong("giftworth", 0L);
                this.ZI = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sS() {
        return this.ZI;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
