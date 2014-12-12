package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private ArrayList<UserData> Ef = new ArrayList<>();
    private ArrayList<UserData> Eg = new ArrayList<>();
    private p Eh = new p();
    private int friendNum = 0;
    private int Ei = 0;

    public void a(p pVar) {
        this.Eh = pVar;
    }

    public p mY() {
        return this.Eh;
    }

    public ArrayList<UserData> mZ() {
        return this.Ef;
    }

    public ArrayList<UserData> na() {
        return this.Eg;
    }

    public int getFriendNum() {
        return this.friendNum;
    }

    public int nb() {
        return this.Ei;
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
                        this.Ef.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.Eg.add(userData2);
                    }
                }
                this.Eh.parserJson(jSONObject.optJSONObject("page"));
                this.friendNum = jSONObject.optInt("tafriendnum", 0);
                this.Ei = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
