package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private ArrayList<UserData> WY = new ArrayList<>();
    private ArrayList<UserData> WZ = new ArrayList<>();
    private aq mPage = new aq();
    private int Xa = 0;
    private int Xb = 0;

    public void a(aq aqVar) {
        this.mPage = aqVar;
    }

    public aq getPage() {
        return this.mPage;
    }

    public ArrayList<UserData> qU() {
        return this.WY;
    }

    public ArrayList<UserData> qV() {
        return this.WZ;
    }

    public int qW() {
        return this.Xa;
    }

    public int qX() {
        return this.Xb;
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
                        this.WY.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.WZ.add(userData2);
                    }
                }
                this.mPage.parserJson(jSONObject.optJSONObject("page"));
                this.Xa = jSONObject.optInt("tafriendnum", 0);
                this.Xb = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
