package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bj {
    private int avZ = 0;
    private bi awa = new bi();

    public boolean Bx() {
        return this.avZ != 0;
    }

    public bi By() {
        return this.awa;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.avZ = yule.activity_show.intValue();
            this.awa.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.avZ = jSONObject.optInt("activity_show");
                this.awa.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
