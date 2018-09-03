package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private ArrayList<String> agn;
    private int ago = 0;
    private UserData agl = new UserData();
    private AntiData agm = new AntiData();

    public ae() {
        this.agn = null;
        this.agn = new ArrayList<>();
        bG(0);
    }

    public UserData getUser() {
        return this.agl;
    }

    public AntiData ug() {
        return this.agm;
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
            this.agl.parserJson(jSONObject.optJSONObject("user"));
            this.agm.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.agn.add(optJSONArray.optString(i, null));
                }
            }
            bG(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bG(int i) {
        this.ago = i;
    }
}
