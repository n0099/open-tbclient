package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private ArrayList<String> arW;
    private int arX = 0;
    private UserData arU = new UserData();
    private AntiData arV = new AntiData();

    public ae() {
        this.arW = null;
        this.arW = new ArrayList<>();
        cD(0);
    }

    public UserData getUser() {
        return this.arU;
    }

    public AntiData yE() {
        return this.arV;
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
            this.arU.parserJson(jSONObject.optJSONObject("user"));
            this.arV.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.arW.add(optJSONArray.optString(i, null));
                }
            }
            cD(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cD(int i) {
        this.arX = i;
    }
}
