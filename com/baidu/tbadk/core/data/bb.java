package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bb {
    private ArrayList<UserData> ewp = new ArrayList<>();
    private ArrayList<UserData> ewq = new ArrayList<>();
    private av ewr = new av();
    private int ews = 0;
    private int ewt = 0;

    public void setPage(av avVar) {
        this.ewr = avVar;
    }

    public av getPage() {
        return this.ewr;
    }

    public ArrayList<UserData> biT() {
        return this.ewp;
    }

    public ArrayList<UserData> biU() {
        return this.ewq;
    }

    public int biV() {
        return this.ews;
    }

    public int biW() {
        return this.ewt;
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
                        this.ewp.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.ewq.add(userData2);
                    }
                }
                this.ewr.parserJson(jSONObject.optJSONObject("page"));
                this.ews = jSONObject.optInt("tafriendnum", 0);
                this.ewt = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
