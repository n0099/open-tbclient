package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bl {
    private int aci = 0;
    private bk acj = new bk();

    public boolean tv() {
        return this.aci != 0;
    }

    public bk tw() {
        return this.acj;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.aci = yule.activity_show.intValue();
            this.acj.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aci = jSONObject.optInt("activity_show");
                this.acj.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
