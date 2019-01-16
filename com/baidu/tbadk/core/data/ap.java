package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> ata = new ArrayList<>();
    private ArrayList<UserData> atb = new ArrayList<>();
    private al atc = new al();
    private int atd = 0;
    private int ate = 0;

    public void a(al alVar) {
        this.atc = alVar;
    }

    public al zf() {
        return this.atc;
    }

    public ArrayList<UserData> zg() {
        return this.ata;
    }

    public ArrayList<UserData> zh() {
        return this.atb;
    }

    public int zi() {
        return this.atd;
    }

    public int zj() {
        return this.ate;
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
                        this.ata.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.atb.add(userData2);
                    }
                }
                this.atc.parserJson(jSONObject.optJSONObject(SystemScreenshotManager.PAGE));
                this.atd = jSONObject.optInt("tafriendnum", 0);
                this.ate = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
