package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bd {
    private ArrayList<UserData> bHm = new ArrayList<>();
    private ArrayList<UserData> eRp = new ArrayList<>();
    private ax eRq = new ax();
    private int eRr = 0;
    private int eRs = 0;

    public void setPage(ax axVar) {
        this.eRq = axVar;
    }

    public ax getPage() {
        return this.eRq;
    }

    public ArrayList<UserData> bqj() {
        return this.bHm;
    }

    public ArrayList<UserData> bqk() {
        return this.eRp;
    }

    public int bql() {
        return this.eRr;
    }

    public int bqm() {
        return this.eRs;
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
                        this.bHm.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.eRp.add(userData2);
                    }
                }
                this.eRq.parserJson(jSONObject.optJSONObject("page"));
                this.eRr = jSONObject.optInt("tafriendnum", 0);
                this.eRs = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
