package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class br {
    private int Vq = 0;
    private bq Vr = new bq();

    public boolean te() {
        return this.Vq != 0;
    }

    public bq tf() {
        return this.Vr;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.Vq = yule.activity_show.intValue();
            this.Vr.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vq = jSONObject.optInt("activity_show");
                this.Vr.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
