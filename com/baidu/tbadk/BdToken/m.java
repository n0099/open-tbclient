package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private long alk;
    private long alm;
    private ArrayList<o> aln;
    private String mUrl;

    public void parseJson(String str) {
        if (!ao.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.alk = jSONObject.optLong("start_date", 0L) * 1000;
                this.alm = jSONObject.optLong("end_date", 0L) * 1000;
                this.mUrl = jSONObject.optString("ahead_url", "");
                this.aln = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("time");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        o oVar = new o();
                        oVar.parseJson(optJSONArray2);
                        this.aln.add(oVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public long vQ() {
        return this.alk;
    }

    public long vR() {
        return this.alm;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ArrayList<o> vS() {
        return this.aln;
    }
}
