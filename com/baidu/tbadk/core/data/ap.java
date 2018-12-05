package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> asy = new ArrayList<>();
    private ArrayList<UserData> asz = new ArrayList<>();
    private al asA = new al();
    private int asB = 0;
    private int asC = 0;

    public void a(al alVar) {
        this.asA = alVar;
    }

    public al yS() {
        return this.asA;
    }

    public ArrayList<UserData> yT() {
        return this.asy;
    }

    public ArrayList<UserData> yU() {
        return this.asz;
    }

    public int yV() {
        return this.asB;
    }

    public int yW() {
        return this.asC;
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
                        this.asy.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.asz.add(userData2);
                    }
                }
                this.asA.parserJson(jSONObject.optJSONObject(SystemScreenshotManager.PAGE));
                this.asB = jSONObject.optInt("tafriendnum", 0);
                this.asC = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
