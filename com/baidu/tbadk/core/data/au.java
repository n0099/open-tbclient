package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private ArrayList<UserData> dDy = new ArrayList<>();
    private ArrayList<UserData> dDz = new ArrayList<>();
    private ao dDA = new ao();
    private int dDB = 0;
    private int dDC = 0;

    public void setPage(ao aoVar) {
        this.dDA = aoVar;
    }

    public ao getPage() {
        return this.dDA;
    }

    public ArrayList<UserData> aPw() {
        return this.dDy;
    }

    public ArrayList<UserData> aPx() {
        return this.dDz;
    }

    public int aPy() {
        return this.dDB;
    }

    public int aPz() {
        return this.dDC;
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
                        this.dDy.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.dDz.add(userData2);
                    }
                }
                this.dDA.parserJson(jSONObject.optJSONObject("page"));
                this.dDB = jSONObject.optInt("tafriendnum", 0);
                this.dDC = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
