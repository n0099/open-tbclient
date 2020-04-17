package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bu {
    private int duq = 0;
    private bt dur = new bt();

    public boolean aMP() {
        return this.duq != 0;
    }

    public bt aMQ() {
        return this.dur;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.duq = yule.activity_show.intValue();
            this.dur.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.duq = jSONObject.optInt("activity_show");
                this.dur.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
