package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private ArrayList<UserData> WG = new ArrayList<>();
    private ArrayList<UserData> WH = new ArrayList<>();
    private aq WI = new aq();
    private int WJ = 0;
    private int WK = 0;

    public void a(aq aqVar) {
        this.WI = aqVar;
    }

    public aq qB() {
        return this.WI;
    }

    public ArrayList<UserData> qC() {
        return this.WG;
    }

    public ArrayList<UserData> qD() {
        return this.WH;
    }

    public int qE() {
        return this.WJ;
    }

    public int qF() {
        return this.WK;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i));
                        userData.mAttentionType = 2;
                        this.WG.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.WH.add(userData2);
                    }
                }
                this.WI.parserJson(jSONObject.optJSONObject("page"));
                this.WJ = jSONObject.optInt("tafriendnum", 0);
                this.WK = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
