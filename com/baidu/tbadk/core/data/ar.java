package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
    private ArrayList<UserData> bzP = new ArrayList<>();
    private ArrayList<UserData> bzQ = new ArrayList<>();
    private an bzR = new an();
    private int bzS = 0;
    private int bzT = 0;

    public void setPage(an anVar) {
        this.bzR = anVar;
    }

    public an getPage() {
        return this.bzR;
    }

    public ArrayList<UserData> XN() {
        return this.bzP;
    }

    public ArrayList<UserData> XO() {
        return this.bzQ;
    }

    public int XP() {
        return this.bzS;
    }

    public int XQ() {
        return this.bzT;
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
                        this.bzP.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.bzQ.add(userData2);
                    }
                }
                this.bzR.parserJson(jSONObject.optJSONObject("page"));
                this.bzS = jSONObject.optInt("tafriendnum", 0);
                this.bzT = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
