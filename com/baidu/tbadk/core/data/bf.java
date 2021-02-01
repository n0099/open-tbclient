package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bf {
    private ArrayList<UserData> bGk = new ArrayList<>();
    private ArrayList<UserData> eOQ = new ArrayList<>();
    private az eOR = new az();
    private int eOS = 0;
    private int eOT = 0;

    public void setPage(az azVar) {
        this.eOR = azVar;
    }

    public az getPage() {
        return this.eOR;
    }

    public ArrayList<UserData> bmI() {
        return this.bGk;
    }

    public ArrayList<UserData> bmJ() {
        return this.eOQ;
    }

    public int bmK() {
        return this.eOS;
    }

    public int bmL() {
        return this.eOT;
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
                        this.bGk.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.eOQ.add(userData2);
                    }
                }
                this.eOR.parserJson(jSONObject.optJSONObject("page"));
                this.eOS = jSONObject.optInt("tafriendnum", 0);
                this.eOT = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
