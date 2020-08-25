package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bb {
    private ArrayList<UserData> dZz = new ArrayList<>();
    private ArrayList<UserData> dZA = new ArrayList<>();
    private av dZB = new av();
    private int dZC = 0;
    private int dZD = 0;

    public void setPage(av avVar) {
        this.dZB = avVar;
    }

    public av getPage() {
        return this.dZB;
    }

    public ArrayList<UserData> bdx() {
        return this.dZz;
    }

    public ArrayList<UserData> bdy() {
        return this.dZA;
    }

    public int bdz() {
        return this.dZC;
    }

    public int bdA() {
        return this.dZD;
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
                        this.dZz.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.dZA.add(userData2);
                    }
                }
                this.dZB.parserJson(jSONObject.optJSONObject("page"));
                this.dZC = jSONObject.optInt("tafriendnum", 0);
                this.dZD = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
