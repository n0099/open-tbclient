package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bt {
    private int VO = 0;
    private bs VP = new bs();

    public boolean ti() {
        return this.VO != 0;
    }

    public bs tj() {
        return this.VP;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.VO = yule.activity_show.intValue();
            this.VP.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VO = jSONObject.optInt("activity_show");
                this.VP.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
