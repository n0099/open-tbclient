package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bj {
    private int akl = 0;
    private bi akm = new bi();

    public boolean wX() {
        return this.akl != 0;
    }

    public bi wY() {
        return this.akm;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.akl = yule.activity_show.intValue();
            this.akm.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.akl = jSONObject.optInt("activity_show");
                this.akm.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
