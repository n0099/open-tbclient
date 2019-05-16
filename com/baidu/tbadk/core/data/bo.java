package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bo {
    private int bLG = 0;
    private bn bLH = new bn();

    public boolean afz() {
        return this.bLG != 0;
    }

    public bn afA() {
        return this.bLH;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.bLG = yule.activity_show.intValue();
            this.bLH.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bLG = jSONObject.optInt("activity_show");
                this.bLH.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
