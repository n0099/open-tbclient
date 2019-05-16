package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class bi {
    private String bLu;
    private String bLv;
    private int bLw;
    private String bLx;
    private long bLy;
    private String bLz;
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
        return this.bLv;
    }

    public int afq() {
        return this.bLw;
    }

    public String afr() {
        return this.bLx;
    }

    public long afs() {
        return this.bLy;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.imgUrl = topCode.img_url;
            this.bLu = topCode.game_link;
            this.summary = topCode.summary;
            this.bLv = topCode.code_link;
            this.bLw = topCode.get_type.intValue();
            this.bLx = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.bLy = 0L;
            } else {
                this.bLy = topCode.giftworth.longValue();
            }
            this.bLz = topCode.type_text;
            this.subTitle = topCode.subtitle;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
                this.bLu = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.bLv = jSONObject.optString("code_link");
                this.bLw = jSONObject.optInt("get_type", 1);
                this.bLx = jSONObject.optString("surplusgift");
                this.bLy = jSONObject.optLong("giftworth", 0L);
                this.bLz = jSONObject.optString("type_text");
                this.subTitle = jSONObject.optString("subtitle");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String aft() {
        return this.bLz;
    }

    public String getSubTitle() {
        return this.subTitle;
    }
}
