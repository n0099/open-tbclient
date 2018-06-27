package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private long aab;
    private long aac;
    private ArrayList<e> aad;
    private String mUrl;

    public void parseJson(String str) {
        if (!ap.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aab = jSONObject.optLong("start_date", 0L) * 1000;
                this.aac = jSONObject.optLong("end_date", 0L) * 1000;
                this.mUrl = jSONObject.optString("ahead_url", "");
                this.aad = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("time");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        e eVar = new e();
                        eVar.b(optJSONArray2);
                        this.aad.add(eVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public long rF() {
        return this.aab;
    }

    public long rG() {
        return this.aac;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ArrayList<e> rH() {
        return this.aad;
    }
}
