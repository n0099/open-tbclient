package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private ArrayList<String> YC;
    private int YD = 0;
    private UserData YA = new UserData();
    private AntiData YB = new AntiData();

    public af() {
        this.YC = null;
        this.YC = new ArrayList<>();
        bC(0);
    }

    public UserData getUser() {
        return this.YA;
    }

    public AntiData qT() {
        return this.YB;
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
            this.YA.parserJson(jSONObject.optJSONObject("user"));
            this.YB.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.YC.add(optJSONArray.optString(i, null));
                }
            }
            bC(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bC(int i) {
        this.YD = i;
    }
}
