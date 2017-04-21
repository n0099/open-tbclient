package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class at {
    private ArrayList<UserData> Xo = new ArrayList<>();
    private ArrayList<UserData> Xp = new ArrayList<>();
    private ap Xq = new ap();
    private int Xr = 0;
    private int Xs = 0;

    public void a(ap apVar) {
        this.Xq = apVar;
    }

    public ap rr() {
        return this.Xq;
    }

    public ArrayList<UserData> rs() {
        return this.Xo;
    }

    public ArrayList<UserData> rt() {
        return this.Xp;
    }

    public int ru() {
        return this.Xr;
    }

    public int rv() {
        return this.Xs;
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
                        this.Xo.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.Xp.add(userData2);
                    }
                }
                this.Xq.parserJson(jSONObject.optJSONObject("page"));
                this.Xr = jSONObject.optInt("tafriendnum", 0);
                this.Xs = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
