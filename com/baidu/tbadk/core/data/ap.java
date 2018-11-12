package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> aoX = new ArrayList<>();
    private ArrayList<UserData> aoY = new ArrayList<>();
    private al aoZ = new al();
    private int apa = 0;
    private int apb = 0;

    public void a(al alVar) {
        this.aoZ = alVar;
    }

    public al xO() {
        return this.aoZ;
    }

    public ArrayList<UserData> xP() {
        return this.aoX;
    }

    public ArrayList<UserData> xQ() {
        return this.aoY;
    }

    public int xR() {
        return this.apa;
    }

    public int xS() {
        return this.apb;
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
                        this.aoX.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.aoY.add(userData2);
                    }
                }
                this.aoZ.parserJson(jSONObject.optJSONObject(SystemScreenshotManager.PAGE));
                this.apa = jSONObject.optInt("tafriendnum", 0);
                this.apb = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
