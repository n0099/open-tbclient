package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes2.dex */
public class ch {
    private int eeR = 0;
    private cg eeS = new cg();

    public boolean bgX() {
        return this.eeR != 0;
    }

    public cg bgY() {
        return this.eeS;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.eeR = yule.activity_show.intValue();
            this.eeS.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eeR = jSONObject.optInt("activity_show");
                this.eeS.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
