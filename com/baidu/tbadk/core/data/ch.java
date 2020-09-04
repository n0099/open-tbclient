package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class ch {
    private int eeV = 0;
    private cg eeW = new cg();

    public boolean bgX() {
        return this.eeV != 0;
    }

    public cg bgY() {
        return this.eeW;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.eeV = yule.activity_show.intValue();
            this.eeW.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eeV = jSONObject.optInt("activity_show");
                this.eeW.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
