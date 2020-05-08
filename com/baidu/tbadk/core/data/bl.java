package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bl {
    private String dug;
    private String duh;
    private int dui;
    private String duj;
    private long duk;
    private String dul;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String aIU() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String aMD() {
        return this.duh;
    }

    public int aME() {
        return this.dui;
    }

    public String aMF() {
        return this.duj;
    }

    public long aMG() {
        return this.duk;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.dug = topCode.game_link;
            this.summary = topCode.summary;
            this.duh = topCode.code_link;
            this.dui = topCode.get_type.intValue();
            this.duj = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.duk = 0L;
            } else {
                this.duk = topCode.giftworth.longValue();
            }
            this.dul = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.dug = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.duh = jSONObject.optString("code_link");
                this.dui = jSONObject.optInt("get_type", 1);
                this.duj = jSONObject.optString("surplusgift");
                this.duk = jSONObject.optLong("giftworth", 0L);
                this.dul = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aMH() {
        return this.dul;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
