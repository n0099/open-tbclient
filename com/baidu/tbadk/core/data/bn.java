package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bn {
    private int aPw = 0;
    private bm aPx = new bm();

    public boolean AA() {
        return this.aPw != 0;
    }

    public bm AB() {
        return this.aPx;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.aPw = yule.activity_show.intValue();
            this.aPx.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aPw = jSONObject.optInt("activity_show");
                this.aPx.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
