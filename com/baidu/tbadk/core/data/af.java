package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private ArrayList<String> aLT;
    private int aLU = 0;
    private UserData aLR = new UserData();
    private AntiData aLS = new AntiData();

    public af() {
        this.aLT = null;
        this.aLT = new ArrayList<>();
        eE(0);
    }

    public UserData getUser() {
        return this.aLR;
    }

    public AntiData xJ() {
        return this.aLS;
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
            this.aLR.parserJson(jSONObject.optJSONObject("user"));
            this.aLS.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aLT.add(optJSONArray.optString(i, null));
                }
            }
            eE(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void eE(int i) {
        this.aLU = i;
    }
}
