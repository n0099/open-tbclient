package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bj {
    private String cdR;
    private String cdS;
    private int cdT;
    private String cdU;
    private long cdV;
    private String cdW;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String ahd() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String akx() {
        return this.cdS;
    }

    public int aky() {
        return this.cdT;
    }

    public String akz() {
        return this.cdU;
    }

    public long akA() {
        return this.cdV;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.cdR = topCode.game_link;
            this.summary = topCode.summary;
            this.cdS = topCode.code_link;
            this.cdT = topCode.get_type.intValue();
            this.cdU = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.cdV = 0L;
            } else {
                this.cdV = topCode.giftworth.longValue();
            }
            this.cdW = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.cdR = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.cdS = jSONObject.optString("code_link");
                this.cdT = jSONObject.optInt("get_type", 1);
                this.cdU = jSONObject.optString("surplusgift");
                this.cdV = jSONObject.optLong("giftworth", 0L);
                this.cdW = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String akB() {
        return this.cdW;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
