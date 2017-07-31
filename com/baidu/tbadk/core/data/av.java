package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class av {
    private ArrayList<UserData> Yn = new ArrayList<>();
    private ArrayList<UserData> Yo = new ArrayList<>();
    private ar Yp = new ar();
    private int Yq = 0;
    private int Yr = 0;

    public void a(ar arVar) {
        this.Yp = arVar;
    }

    public ar qH() {
        return this.Yp;
    }

    public ArrayList<UserData> qI() {
        return this.Yn;
    }

    public ArrayList<UserData> qJ() {
        return this.Yo;
    }

    public int qK() {
        return this.Yq;
    }

    public int qL() {
        return this.Yr;
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
                        this.Yn.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.Yo.add(userData2);
                    }
                }
                this.Yp.parserJson(jSONObject.optJSONObject("page"));
                this.Yq = jSONObject.optInt("tafriendnum", 0);
                this.Yr = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
