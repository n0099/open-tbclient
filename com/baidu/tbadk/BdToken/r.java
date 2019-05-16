package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private long byQ;
    private long byR;
    private ArrayList<t> byS;
    private String mUrl;

    public void parseJson(String str) {
        if (!ap.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.byQ = jSONObject.optLong("start_date", 0L) * 1000;
                this.byR = jSONObject.optLong("end_date", 0L) * 1000;
                this.mUrl = jSONObject.optString("ahead_url", "");
                this.byS = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        t tVar = new t();
                        tVar.e(optJSONArray2);
                        this.byS.add(tVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public long getStartDate() {
        return this.byQ;
    }

    public long YP() {
        return this.byR;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ArrayList<t> YQ() {
        return this.byS;
    }
}
