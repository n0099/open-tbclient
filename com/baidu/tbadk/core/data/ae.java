package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private ArrayList<String> aiN;
    private int aiO = 0;
    private UserData aiL = new UserData();
    private AntiData aiM = new AntiData();

    public ae() {
        this.aiN = null;
        this.aiN = new ArrayList<>();
        bP(0);
    }

    public UserData getUser() {
        return this.aiL;
    }

    public AntiData vj() {
        return this.aiM;
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
            this.aiL.parserJson(jSONObject.optJSONObject("user"));
            this.aiM.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aiN.add(optJSONArray.optString(i, null));
                }
            }
            bP(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bP(int i) {
        this.aiO = i;
    }
}
