package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bi {
    private String ZV;
    private String ZW;
    private int ZX;
    private String ZY;
    private long ZZ;
    private String aaa;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pL() {
        return this.imgUrl;
    }

    public String sH() {
        return this.summary;
    }

    public String sI() {
        return this.ZW;
    }

    public int sJ() {
        return this.ZX;
    }

    public String sK() {
        return this.ZY;
    }

    public long sL() {
        return this.ZZ;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.ZV = topCode.game_link;
            this.summary = topCode.summary;
            this.ZW = topCode.code_link;
            this.ZX = topCode.get_type.intValue();
            this.ZY = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.ZZ = 0L;
            } else {
                this.ZZ = topCode.giftworth.longValue();
            }
            this.aaa = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.ZV = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.ZW = jSONObject.optString("code_link");
                this.ZX = jSONObject.optInt("get_type", 1);
                this.ZY = jSONObject.optString("surplusgift");
                this.ZZ = jSONObject.optLong("giftworth", 0L);
                this.aaa = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String sM() {
        return this.aaa;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
