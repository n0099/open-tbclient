package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private ArrayList<String> Xs;
    private int Xt = 0;
    private UserData Xq = new UserData();
    private AntiData Xr = new AntiData();

    public ae() {
        this.Xs = null;
        this.Xs = new ArrayList<>();
        bE(0);
    }

    public UserData getUser() {
        return this.Xq;
    }

    public AntiData qg() {
        return this.Xr;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.Xq.parserJson(jSONObject.optJSONObject("user"));
            this.Xr.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Xs.add(optJSONArray.optString(i, null));
                }
            }
            bE(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bE(int i) {
        this.Xt = i;
    }
}
