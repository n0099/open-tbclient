package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class ci {
    private int eFW = 0;
    private ch eFX = new ch();

    public boolean bnX() {
        return this.eFW != 0;
    }

    public ch bnY() {
        return this.eFX;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.eFW = yule.activity_show.intValue();
            this.eFX.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eFW = jSONObject.optInt("activity_show");
                this.eFX.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
