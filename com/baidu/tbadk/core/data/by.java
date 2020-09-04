package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class by {
    private String eeH;
    private String eeI;
    private int eeJ;
    private String eeK;
    private long eeL;
    private String eeM;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String bcA() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String bgN() {
        return this.eeI;
    }

    public int bgO() {
        return this.eeJ;
    }

    public String bgP() {
        return this.eeK;
    }

    public long bgQ() {
        return this.eeL;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.eeH = topCode.game_link;
            this.summary = topCode.summary;
            this.eeI = topCode.code_link;
            this.eeJ = topCode.get_type.intValue();
            this.eeK = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.eeL = 0L;
            } else {
                this.eeL = topCode.giftworth.longValue();
            }
            this.eeM = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.eeH = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.eeI = jSONObject.optString("code_link");
                this.eeJ = jSONObject.optInt("get_type", 1);
                this.eeK = jSONObject.optString("surplusgift");
                this.eeL = jSONObject.optLong("giftworth", 0L);
                this.eeM = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String bgR() {
        return this.eeM;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
