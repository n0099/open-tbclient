package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bu {
    private int cUQ = 0;
    private bt cUR = new bt();

    public boolean aEv() {
        return this.cUQ != 0;
    }

    public bt aEw() {
        return this.cUR;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.cUQ = yule.activity_show.intValue();
            this.cUR.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cUQ = jSONObject.optInt("activity_show");
                this.cUR.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
