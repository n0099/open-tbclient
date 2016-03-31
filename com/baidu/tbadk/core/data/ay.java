package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class ay {
    private int We = 0;
    private ax Wf = new ax();

    public boolean ui() {
        return this.We != 0;
    }

    public ax uj() {
        return this.Wf;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.We = yule.activity_show.intValue();
            this.Wf.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.We = jSONObject.optInt("activity_show");
                this.Wf.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
