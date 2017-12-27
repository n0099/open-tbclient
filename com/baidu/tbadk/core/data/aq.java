package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq {
    private ArrayList<UserData> aMs = new ArrayList<>();
    private ArrayList<UserData> aMt = new ArrayList<>();
    private am aMu = new am();
    private int aMv = 0;
    private int aMw = 0;

    public void a(am amVar) {
        this.aMu = amVar;
    }

    public am yb() {
        return this.aMu;
    }

    public ArrayList<UserData> yc() {
        return this.aMs;
    }

    public ArrayList<UserData> yd() {
        return this.aMt;
    }

    public int ye() {
        return this.aMv;
    }

    public int yf() {
        return this.aMw;
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
                        this.aMs.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.aMt.add(userData2);
                    }
                }
                this.aMu.parserJson(jSONObject.optJSONObject("page"));
                this.aMv = jSONObject.optInt("tafriendnum", 0);
                this.aMw = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
