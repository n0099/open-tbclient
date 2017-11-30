package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> XX = new ArrayList<>();
    private ArrayList<UserData> XY = new ArrayList<>();
    private al XZ = new al();
    private int Ya = 0;
    private int Yb = 0;

    public void a(al alVar) {
        this.XZ = alVar;
    }

    public al qA() {
        return this.XZ;
    }

    public ArrayList<UserData> qB() {
        return this.XX;
    }

    public ArrayList<UserData> qC() {
        return this.XY;
    }

    public int qD() {
        return this.Ya;
    }

    public int qE() {
        return this.Yb;
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
                        this.XX.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.XY.add(userData2);
                    }
                }
                this.XZ.parserJson(jSONObject.optJSONObject("page"));
                this.Ya = jSONObject.optInt("tafriendnum", 0);
                this.Yb = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
