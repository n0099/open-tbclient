package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bu {
    private int cVf = 0;
    private bt cVg = new bt();

    public boolean aEB() {
        return this.cVf != 0;
    }

    public bt aEC() {
        return this.cVg;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.cVf = yule.activity_show.intValue();
            this.cVg.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cVf = jSONObject.optInt("activity_show");
                this.cVg.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
