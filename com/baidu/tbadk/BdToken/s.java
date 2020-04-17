package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private long dig;
    private long dih;
    private ArrayList<u> dii;
    private String mUrl;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.dig = jSONObject.optLong("start_date", 0L) * 1000;
                this.dih = jSONObject.optLong("end_date", 0L) * 1000;
                this.mUrl = jSONObject.optString("ahead_url", "");
                this.dii = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("time");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        u uVar = new u();
                        uVar.parseJson(optJSONArray2);
                        this.dii.add(uVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public long getStartDate() {
        return this.dig;
    }

    public long aGu() {
        return this.dih;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ArrayList<u> aGv() {
        return this.dii;
    }
}
