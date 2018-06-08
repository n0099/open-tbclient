package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private ArrayList<String> agE;
    private int agF = 0;
    private UserData agC = new UserData();
    private AntiData agD = new AntiData();

    public af() {
        this.agE = null;
        this.agE = new ArrayList<>();
        bE(0);
    }

    public UserData getUser() {
        return this.agC;
    }

    public AntiData uo() {
        return this.agD;
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
            this.agC.parserJson(jSONObject.optJSONObject("user"));
            this.agD.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.agE.add(optJSONArray.optString(i, null));
                }
            }
            bE(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bE(int i) {
        this.agF = i;
    }
}
