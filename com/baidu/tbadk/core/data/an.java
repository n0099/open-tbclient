package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class an {
    private int XK = 0;
    private am XL = new am();

    public boolean uc() {
        return this.XK != 0;
    }

    public am ud() {
        return this.XL;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.XK = yule.activity_show.intValue();
            this.XL.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.XK = jSONObject.optInt("activity_show");
                this.XL.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
