package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class av {
    private ArrayList<UserData> WR = new ArrayList<>();
    private ArrayList<UserData> WS = new ArrayList<>();
    private ar WT = new ar();
    private int WU = 0;
    private int WV = 0;

    public void a(ar arVar) {
        this.WT = arVar;
    }

    public ar qx() {
        return this.WT;
    }

    public ArrayList<UserData> qy() {
        return this.WR;
    }

    public ArrayList<UserData> qz() {
        return this.WS;
    }

    public int qA() {
        return this.WU;
    }

    public int qB() {
        return this.WV;
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
                        this.WR.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.WS.add(userData2);
                    }
                }
                this.WT.parserJson(jSONObject.optJSONObject("page"));
                this.WU = jSONObject.optInt("tafriendnum", 0);
                this.WV = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
