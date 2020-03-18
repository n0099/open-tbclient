package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private ArrayList<UserData> cQp = new ArrayList<>();
    private ArrayList<UserData> cQq = new ArrayList<>();
    private ap cQr = new ap();
    private int cQs = 0;
    private int cQt = 0;

    public void setPage(ap apVar) {
        this.cQr = apVar;
    }

    public ap getPage() {
        return this.cQr;
    }

    public ArrayList<UserData> aBq() {
        return this.cQp;
    }

    public ArrayList<UserData> aBr() {
        return this.cQq;
    }

    public int aBs() {
        return this.cQs;
    }

    public int aBt() {
        return this.cQt;
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
                        this.cQp.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.cQq.add(userData2);
                    }
                }
                this.cQr.parserJson(jSONObject.optJSONObject("page"));
                this.cQs = jSONObject.optInt("tafriendnum", 0);
                this.cQt = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
