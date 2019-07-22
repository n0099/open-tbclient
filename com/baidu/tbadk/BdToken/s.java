package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private long bzN;
    private long bzO;
    private ArrayList<u> bzP;
    private String mUrl;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.bzN = jSONObject.optLong("start_date", 0L) * 1000;
                this.bzO = jSONObject.optLong("end_date", 0L) * 1000;
                this.mUrl = jSONObject.optString("ahead_url", "");
                this.bzP = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        u uVar = new u();
                        uVar.e(optJSONArray2);
                        this.bzP.add(uVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public long getStartDate() {
        return this.bzN;
    }

    public long ZN() {
        return this.bzO;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ArrayList<u> ZO() {
        return this.bzP;
    }
}
