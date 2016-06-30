package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bg {
    private int RG = 0;
    private bf RH = new bf();

    public boolean rL() {
        return this.RG != 0;
    }

    public bf rM() {
        return this.RH;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.RG = yule.activity_show.intValue();
            this.RH.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.RG = jSONObject.optInt("activity_show");
                this.RH.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
