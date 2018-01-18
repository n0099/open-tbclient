package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private ArrayList<String> aLP;
    private int aLQ = 0;
    private UserData aLN = new UserData();
    private AntiData aLO = new AntiData();

    public ae() {
        this.aLP = null;
        this.aLP = new ArrayList<>();
        eD(0);
    }

    public UserData getUser() {
        return this.aLN;
    }

    public AntiData xG() {
        return this.aLO;
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
            this.aLN.parserJson(jSONObject.optJSONObject("user"));
            this.aLO.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aLP.add(optJSONArray.optString(i, null));
                }
            }
            eD(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void eD(int i) {
        this.aLQ = i;
    }
}
