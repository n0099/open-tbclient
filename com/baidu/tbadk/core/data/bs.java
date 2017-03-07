package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bs {
    private int ZJ = 0;
    private br ZK = new br();

    public boolean tk() {
        return this.ZJ != 0;
    }

    public br tl() {
        return this.ZK;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.ZJ = yule.activity_show.intValue();
            this.ZK.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ZJ = jSONObject.optInt("activity_show");
                this.ZK.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
