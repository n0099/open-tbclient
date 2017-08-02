package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bt {
    private int ZU = 0;
    private bs ZV = new bs();

    public boolean sZ() {
        return this.ZU != 0;
    }

    public bs ta() {
        return this.ZV;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.ZU = yule.activity_show.intValue();
            this.ZV.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ZU = jSONObject.optInt("activity_show");
                this.ZV.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
