package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bd {
    private ArrayList<UserData> bCz = new ArrayList<>();
    private ArrayList<UserData> eHy = new ArrayList<>();
    private ax eHz = new ax();
    private int eHA = 0;
    private int eHB = 0;

    public void setPage(ax axVar) {
        this.eHz = axVar;
    }

    public ax getPage() {
        return this.eHz;
    }

    public ArrayList<UserData> bnI() {
        return this.bCz;
    }

    public ArrayList<UserData> bnJ() {
        return this.eHy;
    }

    public int bnK() {
        return this.eHA;
    }

    public int bnL() {
        return this.eHB;
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
                        this.bCz.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.eHy.add(userData2);
                    }
                }
                this.eHz.parserJson(jSONObject.optJSONObject("page"));
                this.eHA = jSONObject.optInt("tafriendnum", 0);
                this.eHB = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
