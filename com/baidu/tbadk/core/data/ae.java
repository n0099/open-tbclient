package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private ArrayList<String> aLS;
    private int aLT = 0;
    private UserData aLQ = new UserData();
    private AntiData aLR = new AntiData();

    public ae() {
        this.aLS = null;
        this.aLS = new ArrayList<>();
        eD(0);
    }

    public UserData getUser() {
        return this.aLQ;
    }

    public AntiData xH() {
        return this.aLR;
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
            this.aLQ.parserJson(jSONObject.optJSONObject("user"));
            this.aLR.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aLS.add(optJSONArray.optString(i, null));
                }
            }
            eD(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void eD(int i) {
        this.aLT = i;
    }
}
