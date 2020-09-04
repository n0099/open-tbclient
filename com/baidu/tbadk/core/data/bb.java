package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bb {
    private ArrayList<UserData> dZD = new ArrayList<>();
    private ArrayList<UserData> dZE = new ArrayList<>();
    private av dZF = new av();
    private int dZG = 0;
    private int dZH = 0;

    public void setPage(av avVar) {
        this.dZF = avVar;
    }

    public av getPage() {
        return this.dZF;
    }

    public ArrayList<UserData> bdx() {
        return this.dZD;
    }

    public ArrayList<UserData> bdy() {
        return this.dZE;
    }

    public int bdz() {
        return this.dZG;
    }

    public int bdA() {
        return this.dZH;
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
                        this.dZD.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.dZE.add(userData2);
                    }
                }
                this.dZF.parserJson(jSONObject.optJSONObject("page"));
                this.dZG = jSONObject.optInt("tafriendnum", 0);
                this.dZH = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
