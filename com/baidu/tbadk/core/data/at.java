package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class at {
    private ArrayList<UserData> Xz = new ArrayList<>();
    private ArrayList<UserData> XA = new ArrayList<>();
    private ap XB = new ap();
    private int XC = 0;
    private int XD = 0;

    public void a(ap apVar) {
        this.XB = apVar;
    }

    public ap qx() {
        return this.XB;
    }

    public ArrayList<UserData> qy() {
        return this.Xz;
    }

    public ArrayList<UserData> qz() {
        return this.XA;
    }

    public int qA() {
        return this.XC;
    }

    public int qB() {
        return this.XD;
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
                JSONArray optJSONArray = jSONObject.optJSONArray(StoryPageActivityConfig.USER_LIST);
                JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i));
                        userData.mAttentionType = 2;
                        this.Xz.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.XA.add(userData2);
                    }
                }
                this.XB.parserJson(jSONObject.optJSONObject("page"));
                this.XC = jSONObject.optInt("tafriendnum", 0);
                this.XD = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
