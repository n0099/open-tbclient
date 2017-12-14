package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bm {
    private int aaX = 0;
    private bl aaY = new bl();

    public boolean sZ() {
        return this.aaX != 0;
    }

    public bl ta() {
        return this.aaY;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.aaX = yule.activity_show.intValue();
            this.aaY.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aaX = jSONObject.optInt("activity_show");
                this.aaY.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
