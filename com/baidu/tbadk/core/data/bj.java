package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bj {
    private int awa = 0;
    private bi awb = new bi();

    public boolean Bx() {
        return this.awa != 0;
    }

    public bi By() {
        return this.awb;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.awa = yule.activity_show.intValue();
            this.awb.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.awa = jSONObject.optInt("activity_show");
                this.awb.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
