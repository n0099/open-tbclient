package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class ch {
    private int etq = 0;
    private cg etr = new cg();

    public boolean bkA() {
        return this.etq != 0;
    }

    public cg bkB() {
        return this.etr;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.etq = yule.activity_show.intValue();
            this.etr.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.etq = jSONObject.optInt("activity_show");
                this.etr.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
