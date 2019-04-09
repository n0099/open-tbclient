package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private long bsd;
    private long bse;
    private ArrayList<p> bsf;
    private String mUrl;

    public void parseJson(String str) {
        if (!ap.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.bsd = jSONObject.optLong("start_date", 0L) * 1000;
                this.bse = jSONObject.optLong("end_date", 0L) * 1000;
                this.mUrl = jSONObject.optString("ahead_url", "");
                this.bsf = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        p pVar = new p();
                        pVar.g(optJSONArray2);
                        this.bsf.add(pVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public long getStartDate() {
        return this.bsd;
    }

    public long Ut() {
        return this.bse;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ArrayList<p> Uu() {
        return this.bsf;
    }
}
