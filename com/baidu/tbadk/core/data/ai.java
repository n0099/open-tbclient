package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private ArrayList<String> Xf;
    private int Xg = 0;
    private UserData Xd = new UserData();
    private AntiData Xe = new AntiData();

    public ai() {
        this.Xf = null;
        this.Xf = new ArrayList<>();
        bE(0);
    }

    public UserData getUser() {
        return this.Xd;
    }

    public AntiData qf() {
        return this.Xe;
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
            this.Xd.parserJson(jSONObject.optJSONObject("user"));
            this.Xe.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Xf.add(optJSONArray.optString(i, null));
                }
            }
            bE(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bE(int i) {
        this.Xg = i;
    }
}
