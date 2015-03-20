package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes.dex */
public class x {
    private String QK;
    private String QL;
    private String QM;
    private int QN;
    private String QO;
    private long QP;
    private String summary;

    public String qA() {
        return this.QK;
    }

    public String getSummary() {
        return this.summary;
    }

    public String qV() {
        return this.QM;
    }

    public int qW() {
        return this.QN;
    }

    public String qX() {
        return this.QO;
    }

    public void a(TopCode topCode) {
        if (topCode != null) {
            this.QK = topCode.img_url;
            this.QL = topCode.game_link;
            this.summary = topCode.summary;
            this.QM = topCode.code_link;
            this.QN = topCode.get_type.intValue();
            this.QO = topCode.surplusgift;
            if (topCode.giftworth.longValue() < 0) {
                this.QP = 0L;
            } else {
                this.QP = topCode.giftworth.longValue();
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.QK = jSONObject.optString("img_url");
                this.QL = jSONObject.optString("game_link");
                this.summary = jSONObject.optString("summary");
                this.QM = jSONObject.optString("code_link");
                this.QN = jSONObject.optInt("get_type", 1);
                this.QO = jSONObject.optString("surplusgift");
                this.QP = jSONObject.optLong("giftworth", 0L);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
