package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private long ZG;
    private long ZH;
    private ArrayList<e> ZI;
    private String mUrl;

    public void parseJson(String str) {
        if (!ap.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.ZG = jSONObject.optLong("start_date", 0L) * 1000;
                this.ZH = jSONObject.optLong("end_date", 0L) * 1000;
                this.mUrl = jSONObject.optString("ahead_url", "");
                this.ZI = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("time");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        e eVar = new e();
                        eVar.b(optJSONArray2);
                        this.ZI.add(eVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public long rn() {
        return this.ZG;
    }

    public long ro() {
        return this.ZH;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ArrayList<e> rp() {
        return this.ZI;
    }
}
