package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> XU = new ArrayList<>();
    private ArrayList<UserData> XV = new ArrayList<>();
    private al XW = new al();
    private int XX = 0;
    private int XY = 0;

    public void a(al alVar) {
        this.XW = alVar;
    }

    public al qy() {
        return this.XW;
    }

    public ArrayList<UserData> qz() {
        return this.XU;
    }

    public ArrayList<UserData> qA() {
        return this.XV;
    }

    public int qB() {
        return this.XX;
    }

    public int qC() {
        return this.XY;
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
                        this.XU.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.XV.add(userData2);
                    }
                }
                this.XW.parserJson(jSONObject.optJSONObject("page"));
                this.XX = jSONObject.optInt("tafriendnum", 0);
                this.XY = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
