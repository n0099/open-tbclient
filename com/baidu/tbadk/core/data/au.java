package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private ArrayList<UserData> cQc = new ArrayList<>();
    private ArrayList<UserData> cQd = new ArrayList<>();
    private ap cQe = new ap();
    private int cQf = 0;
    private int cQg = 0;

    public void setPage(ap apVar) {
        this.cQe = apVar;
    }

    public ap getPage() {
        return this.cQe;
    }

    public ArrayList<UserData> aBn() {
        return this.cQc;
    }

    public ArrayList<UserData> aBo() {
        return this.cQd;
    }

    public int aBp() {
        return this.cQf;
    }

    public int aBq() {
        return this.cQg;
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
                        this.cQc.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.cQd.add(userData2);
                    }
                }
                this.cQe.parserJson(jSONObject.optJSONObject("page"));
                this.cQf = jSONObject.optInt("tafriendnum", 0);
                this.cQg = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
