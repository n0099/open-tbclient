package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
    private ArrayList<UserData> bIF = new ArrayList<>();
    private ArrayList<UserData> bIG = new ArrayList<>();
    private an bIH = new an();
    private int bII = 0;
    private int bIJ = 0;

    public void setPage(an anVar) {
        this.bIH = anVar;
    }

    public an getPage() {
        return this.bIH;
    }

    public ArrayList<UserData> adz() {
        return this.bIF;
    }

    public ArrayList<UserData> adA() {
        return this.bIG;
    }

    public int adB() {
        return this.bII;
    }

    public int adC() {
        return this.bIJ;
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
                        this.bIF.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.bIG.add(userData2);
                    }
                }
                this.bIH.parserJson(jSONObject.optJSONObject("page"));
                this.bII = jSONObject.optInt("tafriendnum", 0);
                this.bIJ = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
