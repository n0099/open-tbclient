package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class an {
    private ArrayList<String> dYR;
    private int dYS = 0;
    private UserData dYQ = new UserData();
    private AntiData anti = new AntiData();

    public an() {
        this.dYR = null;
        this.dYR = new ArrayList<>();
        mS(0);
    }

    public UserData getUser() {
        return this.dYQ;
    }

    public AntiData getAnti() {
        return this.anti;
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
            this.dYQ.parserJson(jSONObject.optJSONObject("user"));
            this.anti.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.dYR.add(optJSONArray.optString(i, null));
                }
            }
            mS(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void mS(int i) {
        this.dYS = i;
    }
}
