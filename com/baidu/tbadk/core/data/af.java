package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private ArrayList<String> agT;
    private int agU = 0;
    private UserData agR = new UserData();
    private AntiData agS = new AntiData();

    public af() {
        this.agT = null;
        this.agT = new ArrayList<>();
        bE(0);
    }

    public UserData getUser() {
        return this.agR;
    }

    public AntiData uu() {
        return this.agS;
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
            this.agR.parserJson(jSONObject.optJSONObject("user"));
            this.agS.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.agT.add(optJSONArray.optString(i, null));
                }
            }
            bE(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bE(int i) {
        this.agU = i;
    }
}
