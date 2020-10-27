package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class ch {
    private int eBP = 0;
    private cg eBQ = new cg();

    public boolean bmt() {
        return this.eBP != 0;
    }

    public cg bmu() {
        return this.eBQ;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.eBP = yule.activity_show.intValue();
            this.eBQ.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eBP = jSONObject.optInt("activity_show");
                this.eBQ.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
