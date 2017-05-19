package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bt {
    private int Zv = 0;
    private bs Zw = new bs();

    public boolean sV() {
        return this.Zv != 0;
    }

    public bs sW() {
        return this.Zw;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.Zv = yule.activity_show.intValue();
            this.Zw.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Zv = jSONObject.optInt("activity_show");
                this.Zw.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
