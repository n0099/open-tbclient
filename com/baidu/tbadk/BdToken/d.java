package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private long ahh;
    private long ahi;
    private ArrayList<e> ahj;
    private String mUrl;

    public void parseJson(String str) {
        if (!ao.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.ahh = jSONObject.optLong("start_date", 0L) * 1000;
                this.ahi = jSONObject.optLong("end_date", 0L) * 1000;
                this.mUrl = jSONObject.optString("ahead_url", "");
                this.ahj = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("time");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        e eVar = new e();
                        eVar.parseJson(optJSONArray2);
                        this.ahj.add(eVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public long uD() {
        return this.ahh;
    }

    public long uE() {
        return this.ahi;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ArrayList<e> uF() {
        return this.ahj;
    }
}
