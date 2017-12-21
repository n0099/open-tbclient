package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private ArrayList<String> Xv;
    private int Xw = 0;
    private UserData Xt = new UserData();
    private AntiData Xu = new AntiData();

    public ae() {
        this.Xv = null;
        this.Xv = new ArrayList<>();
        bE(0);
    }

    public UserData getUser() {
        return this.Xt;
    }

    public AntiData qg() {
        return this.Xu;
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
            this.Xt.parserJson(jSONObject.optJSONObject("user"));
            this.Xu.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Xv.add(optJSONArray.optString(i, null));
                }
            }
            bE(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bE(int i) {
        this.Xw = i;
    }
}
