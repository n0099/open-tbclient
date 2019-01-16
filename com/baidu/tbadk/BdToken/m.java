package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private long alv;
    private long alw;
    private ArrayList<p> alx;
    private String mUrl;

    public void parseJson(String str) {
        if (!ao.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.alv = jSONObject.optLong("start_date", 0L) * 1000;
                this.alw = jSONObject.optLong("end_date", 0L) * 1000;
                this.mUrl = jSONObject.optString("ahead_url", "");
                this.alx = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("time");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        p pVar = new p();
                        pVar.parseJson(optJSONArray2);
                        this.alx.add(pVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public long vU() {
        return this.alv;
    }

    public long vV() {
        return this.alw;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ArrayList<p> vW() {
        return this.alx;
    }
}
