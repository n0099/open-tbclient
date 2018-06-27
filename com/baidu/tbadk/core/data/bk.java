package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bk {
    private int akM = 0;
    private bj akN = new bj();

    public boolean xf() {
        return this.akM != 0;
    }

    public bj xg() {
        return this.akN;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.akM = yule.activity_show.intValue();
            this.akN.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.akM = jSONObject.optInt("activity_show");
                this.akN.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
