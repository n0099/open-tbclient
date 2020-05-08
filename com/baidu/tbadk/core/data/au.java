package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private ArrayList<UserData> dpz = new ArrayList<>();
    private ArrayList<UserData> dpA = new ArrayList<>();
    private ap dpB = new ap();
    private int dpC = 0;
    private int dpD = 0;

    public void setPage(ap apVar) {
        this.dpB = apVar;
    }

    public ap getPage() {
        return this.dpB;
    }

    public ArrayList<UserData> aJB() {
        return this.dpz;
    }

    public ArrayList<UserData> aJC() {
        return this.dpA;
    }

    public int aJD() {
        return this.dpC;
    }

    public int aJE() {
        return this.dpD;
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
                        this.dpz.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.dpA.add(userData2);
                    }
                }
                this.dpB.parserJson(jSONObject.optJSONObject("page"));
                this.dpC = jSONObject.optInt("tafriendnum", 0);
                this.dpD = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
