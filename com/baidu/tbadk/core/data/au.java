package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private ArrayList<UserData> cLN = new ArrayList<>();
    private ArrayList<UserData> cLO = new ArrayList<>();
    private ap cLP = new ap();
    private int cLQ = 0;
    private int cLR = 0;

    public void setPage(ap apVar) {
        this.cLP = apVar;
    }

    public ap getPage() {
        return this.cLP;
    }

    public ArrayList<UserData> ayB() {
        return this.cLN;
    }

    public ArrayList<UserData> ayC() {
        return this.cLO;
    }

    public int ayD() {
        return this.cLQ;
    }

    public int ayE() {
        return this.cLR;
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
                        this.cLN.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.cLO.add(userData2);
                    }
                }
                this.cLP.parserJson(jSONObject.optJSONObject("page"));
                this.cLQ = jSONObject.optInt("tafriendnum", 0);
                this.cLR = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
