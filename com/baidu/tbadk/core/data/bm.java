package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bm {
    private int abe = 0;
    private bl abf = new bl();

    public boolean tc() {
        return this.abe != 0;
    }

    public bl td() {
        return this.abf;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.abe = yule.activity_show.intValue();
            this.abf.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.abe = jSONObject.optInt("activity_show");
                this.abf.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
