package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class av {
    private ArrayList<UserData> Xy = new ArrayList<>();
    private ArrayList<UserData> Xz = new ArrayList<>();
    private ar XA = new ar();
    private int XB = 0;
    private int XC = 0;

    public void a(ar arVar) {
        this.XA = arVar;
    }

    public ar qD() {
        return this.XA;
    }

    public ArrayList<UserData> qE() {
        return this.Xy;
    }

    public ArrayList<UserData> qF() {
        return this.Xz;
    }

    public int qG() {
        return this.XB;
    }

    public int qH() {
        return this.XC;
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
                        this.Xy.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.Xz.add(userData2);
                    }
                }
                this.XA.parserJson(jSONObject.optJSONObject("page"));
                this.XB = jSONObject.optInt("tafriendnum", 0);
                this.XC = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
