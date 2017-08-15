package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bm {
    private String abb;
    private String abc;
    private int abd;
    private String abe;
    private long abf;
    private String abg;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String pV() {
        return this.imgUrl;
    }

    public String sX() {
        return this.summary;
    }

    public String sY() {
        return this.abc;
    }

    public int sZ() {
        return this.abd;
    }

    public String ta() {
        return this.abe;
    }

    public long tb() {
        return this.abf;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.abb = topCode.game_link;
            this.summary = topCode.summary;
            this.abc = topCode.code_link;
            this.abd = topCode.get_type.intValue();
            this.abe = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.abf = 0L;
            } else {
                this.abf = topCode.giftworth.longValue();
            }
            this.abg = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.abb = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.abc = jSONObject.optString("code_link");
                this.abd = jSONObject.optInt("get_type", 1);
                this.abe = jSONObject.optString("surplusgift");
                this.abf = jSONObject.optLong("giftworth", 0L);
                this.abg = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String tc() {
        return this.abg;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
