package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private ArrayList<UserData> cQa = new ArrayList<>();
    private ArrayList<UserData> cQb = new ArrayList<>();
    private ap cQc = new ap();
    private int cQd = 0;
    private int cQe = 0;

    public void setPage(ap apVar) {
        this.cQc = apVar;
    }

    public ap getPage() {
        return this.cQc;
    }

    public ArrayList<UserData> aBl() {
        return this.cQa;
    }

    public ArrayList<UserData> aBm() {
        return this.cQb;
    }

    public int aBn() {
        return this.cQd;
    }

    public int aBo() {
        return this.cQe;
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
                        this.cQa.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.cQb.add(userData2);
                    }
                }
                this.cQc.parserJson(jSONObject.optJSONObject("page"));
                this.cQd = jSONObject.optInt("tafriendnum", 0);
                this.cQe = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
