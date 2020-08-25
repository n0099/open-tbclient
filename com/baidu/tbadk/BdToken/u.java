package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class u {
    private long dQn;
    private ArrayList<w> dQo;
    private long mStartDate;
    private String mUrl;

    public void parseJson(String str) {
        if (!at.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mStartDate = jSONObject.optLong("start_date", 0L) * 1000;
                this.dQn = jSONObject.optLong("end_date", 0L) * 1000;
                this.mUrl = jSONObject.optString("ahead_url", "");
                this.dQo = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("time");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        w wVar = new w();
                        wVar.parseJson(optJSONArray2);
                        this.dQo.add(wVar);
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

    public long aZv() {
        return this.dQn;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ArrayList<w> aZw() {
        return this.dQo;
    }
}
