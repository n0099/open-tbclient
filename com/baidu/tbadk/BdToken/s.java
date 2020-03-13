package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private long cIS;
    private long cIT;
    private ArrayList<u> cIU;
    private String mUrl;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cIS = jSONObject.optLong("start_date", 0L) * 1000;
                this.cIT = jSONObject.optLong("end_date", 0L) * 1000;
                this.mUrl = jSONObject.optString("ahead_url", "");
                this.cIU = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("time");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        u uVar = new u();
                        uVar.parseJson(optJSONArray2);
                        this.cIU.add(uVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public long getStartDate() {
        return this.cIS;
    }

    public long ayg() {
        return this.cIT;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ArrayList<u> ayh() {
        return this.cIU;
    }
}
