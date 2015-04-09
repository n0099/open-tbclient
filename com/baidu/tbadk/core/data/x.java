package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class x {
    private String QM;
    private String QN;
    private String QO;
    private int QP;
    private String QR;
    private long QS;
    private String summary;

    public String qA() {
        return this.QM;
    }

    public String getSummary() {
        return this.summary;
    }

    public String qV() {
        return this.QO;
    }

    public int qW() {
        return this.QP;
    }

    public String qX() {
        return this.QR;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.QM = topCode.img_url;
            this.QN = topCode.game_link;
            this.summary = topCode.summary;
            this.QO = topCode.code_link;
            this.QP = topCode.get_type.intValue();
            this.QR = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.QS = 0L;
            } else {
                this.QS = topCode.giftworth.longValue();
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.QM = jSONObject.optString("img_url");
                this.QN = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.QO = jSONObject.optString("code_link");
                this.QP = jSONObject.optInt("get_type", 1);
                this.QR = jSONObject.optString("surplusgift");
                this.QS = jSONObject.optLong("giftworth", 0L);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
