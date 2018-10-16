package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private ArrayList<String> anI;
    private int anJ = 0;
    private UserData anG = new UserData();
    private AntiData anH = new AntiData();

    public ae() {
        this.anI = null;
        this.anI = new ArrayList<>();
        ca(0);
    }

    public UserData getUser() {
        return this.anG;
    }

    public AntiData xs() {
        return this.anH;
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
            this.anG.parserJson(jSONObject.optJSONObject("user"));
            this.anH.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.anI.add(optJSONArray.optString(i, null));
                }
            }
            ca(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void ca(int i) {
        this.anJ = i;
    }
}
