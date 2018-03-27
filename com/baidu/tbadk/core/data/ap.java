package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> aNA = new ArrayList<>();
    private ArrayList<UserData> aNB = new ArrayList<>();
    private al aNC = new al();
    private int aND = 0;
    private int aNE = 0;

    public void a(al alVar) {
        this.aNC = alVar;
    }

    public al yA() {
        return this.aNC;
    }

    public ArrayList<UserData> yB() {
        return this.aNA;
    }

    public ArrayList<UserData> yC() {
        return this.aNB;
    }

    public int yD() {
        return this.aND;
    }

    public int yE() {
        return this.aNE;
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
                        this.aNA.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.aNB.add(userData2);
                    }
                }
                this.aNC.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
                this.aND = jSONObject.optInt("tafriendnum", 0);
                this.aNE = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
