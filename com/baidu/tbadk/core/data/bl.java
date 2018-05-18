package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bl {
    private int acj = 0;
    private bk ack = new bk();

    public boolean tu() {
        return this.acj != 0;
    }

    public bk tv() {
        return this.ack;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.acj = yule.activity_show.intValue();
            this.ack.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.acj = jSONObject.optInt("activity_show");
                this.ack.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
