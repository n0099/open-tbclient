package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bm {
    private String aaZ;
    private String aba;
    private int abb;
    private String abc;
    private long abd;
    private String abe;
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
        return this.aba;
    }

    public int sZ() {
        return this.abb;
    }

    public String ta() {
        return this.abc;
    }

    public long tb() {
        return this.abd;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.aaZ = topCode.game_link;
            this.summary = topCode.summary;
            this.aba = topCode.code_link;
            this.abb = topCode.get_type.intValue();
            this.abc = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.abd = 0L;
            } else {
                this.abd = topCode.giftworth.longValue();
            }
            this.abe = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString("img_url");
                this.aaZ = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.aba = jSONObject.optString("code_link");
                this.abb = jSONObject.optInt("get_type", 1);
                this.abc = jSONObject.optString("surplusgift");
                this.abd = jSONObject.optLong("giftworth", 0L);
                this.abe = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String tc() {
        return this.abe;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
