package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bi {
    private String bLA;
    private String bLv;
    private String bLw;
    private int bLx;
    private String bLy;
    private long bLz;
    private String imgUrl;
    private String subTitle;
    private String summary;

    public String abS() {
        return this.imgUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String afp() {
        return this.bLw;
    }

    public int afq() {
        return this.bLx;
    }

    public String afr() {
        return this.bLy;
    }

    public long afs() {
        return this.bLz;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.bLv = topCode.game_link;
            this.summary = topCode.summary;
            this.bLw = topCode.code_link;
            this.bLx = topCode.get_type.intValue();
            this.bLy = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.bLz = 0L;
            } else {
                this.bLz = topCode.giftworth.longValue();
            }
            this.bLA = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.bLv = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.bLw = jSONObject.optString("code_link");
                this.bLx = jSONObject.optInt("get_type", 1);
                this.bLy = jSONObject.optString("surplusgift");
                this.bLz = jSONObject.optLong("giftworth", 0L);
                this.bLA = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aft() {
        return this.bLA;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
