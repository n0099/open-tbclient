package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bm {
    private int aPv = 0;
    private bl aPw = new bl();

    public boolean As() {
        return this.aPv != 0;
    }

    public bl At() {
        return this.aPw;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.aPv = yule.activity_show.intValue();
            this.aPw.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aPv = jSONObject.optInt("activity_show");
                this.aPw.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
