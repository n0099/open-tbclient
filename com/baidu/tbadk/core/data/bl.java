package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bl {
    private int Sq = 0;
    private bk Sr = new bk();

    public boolean rK() {
        return this.Sq != 0;
    }

    public bk rL() {
        return this.Sr;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.Sq = yule.activity_show.intValue();
            this.Sr.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Sq = jSONObject.optInt("activity_show");
                this.Sr.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
