package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private long eCQ;
    private ArrayList<x> eCR;
    private long mStartDate;
    private String mUrl;

    public void parseJson(String str) {
        if (!at.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mStartDate = jSONObject.optLong("start_date", 0L) * 1000;
                this.eCQ = jSONObject.optLong("end_date", 0L) * 1000;
                this.mUrl = jSONObject.optString("ahead_url", "");
                this.eCR = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("time");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        x xVar = new x();
                        xVar.parseJson(optJSONArray2);
                        this.eCR.add(xVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public long getStartDate() {
        return this.mStartDate;
    }

    public long bid() {
        return this.eCQ;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ArrayList<x> bie() {
        return this.eCR;
    }
}
