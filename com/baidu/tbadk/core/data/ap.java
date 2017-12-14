package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> XR = new ArrayList<>();
    private ArrayList<UserData> XS = new ArrayList<>();
    private al XT = new al();
    private int XU = 0;
    private int XV = 0;

    public void a(al alVar) {
        this.XT = alVar;
    }

    public al qy() {
        return this.XT;
    }

    public ArrayList<UserData> qz() {
        return this.XR;
    }

    public ArrayList<UserData> qA() {
        return this.XS;
    }

    public int qB() {
        return this.XU;
    }

    public int qC() {
        return this.XV;
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
                        this.XR.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.XS.add(userData2);
                    }
                }
                this.XT.parserJson(jSONObject.optJSONObject("page"));
                this.XU = jSONObject.optInt("tafriendnum", 0);
                this.XV = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
