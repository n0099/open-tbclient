package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private ArrayList<UserData> Eg = new ArrayList<>();
    private ArrayList<UserData> Eh = new ArrayList<>();
    private q Ei = new q();
    private int friendNum = 0;
    private int Ej = 0;

    public void a(q qVar) {
        this.Ei = qVar;
    }

    public q mT() {
        return this.Ei;
    }

    public ArrayList<UserData> mU() {
        return this.Eg;
    }

    public ArrayList<UserData> mV() {
        return this.Eh;
    }

    public int getFriendNum() {
        return this.friendNum;
    }

    public int mW() {
        return this.Ej;
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
                        this.Eg.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.Eh.add(userData2);
                    }
                }
                this.Ei.parserJson(jSONObject.optJSONObject("page"));
                this.friendNum = jSONObject.optInt("tafriendnum", 0);
                this.Ej = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
