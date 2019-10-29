package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bp {
    private int ceU = 0;
    private bo ceV = new bo();

    public boolean akJ() {
        return this.ceU != 0;
    }

    public bo akK() {
        return this.ceV;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.ceU = yule.activity_show.intValue();
            this.ceV.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ceU = jSONObject.optInt("activity_show");
                this.ceV.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
