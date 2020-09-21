package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bb {
    private ArrayList<UserData> ebN = new ArrayList<>();
    private ArrayList<UserData> ebO = new ArrayList<>();
    private av ebP = new av();
    private int ebQ = 0;
    private int ebR = 0;

    public void setPage(av avVar) {
        this.ebP = avVar;
    }

    public av getPage() {
        return this.ebP;
    }

    public ArrayList<UserData> ber() {
        return this.ebN;
    }

    public ArrayList<UserData> bes() {
        return this.ebO;
    }

    public int bet() {
        return this.ebQ;
    }

    public int beu() {
        return this.ebR;
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
                        this.ebN.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.ebO.add(userData2);
                    }
                }
                this.ebP.parserJson(jSONObject.optJSONObject("page"));
                this.ebQ = jSONObject.optInt("tafriendnum", 0);
                this.ebR = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
