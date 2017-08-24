package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bm {
    private String abb;
    private String abd;
    private int abe;
    private String abf;
    private long abg;
    private String abh;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pW() {
        return this.imgUrl;
    }

    public String sY() {
        return this.summary;
    }

    public String sZ() {
        return this.abd;
    }

    public int ta() {
        return this.abe;
    }

    public String tb() {
        return this.abf;
    }

    public long tc() {
        return this.abg;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.abb = topCode.game_link;
            this.summary = topCode.summary;
            this.abd = topCode.code_link;
            this.abe = topCode.get_type.intValue();
            this.abf = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.abg = 0L;
            } else {
                this.abg = topCode.giftworth.longValue();
            }
            this.abh = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.abb = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.abd = jSONObject.optString("code_link");
                this.abe = jSONObject.optInt("get_type", 1);
                this.abf = jSONObject.optString("surplusgift");
                this.abg = jSONObject.optLong("giftworth", 0L);
                this.abh = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String td() {
        return this.abh;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
