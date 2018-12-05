package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq {
    public int asD;
    public String asE;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<UserData> asy = new ArrayList<>();
    private ArrayList<UserData> asz = new ArrayList<>();
    private al asA = new al();
    private int asB = 0;
    private int asC = 0;

    public ArrayList<UserData> yT() {
        return this.asy;
    }

    public ArrayList<UserData> yU() {
        return this.asz;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optJSONObject(SystemScreenshotManager.PAGE) != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            UserData userData = new UserData();
                            userData.parserJson(optJSONArray.getJSONObject(i));
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
                    if (this.asA != null) {
                        this.pageNum = this.asA.yN();
                        this.asD = this.asA.yL();
                        this.hasMore = this.asA.yP() == 1;
                    }
                    this.asB = jSONObject.optInt("tafriendnum", 0);
                    this.asC = jSONObject.optInt("commonfriendnum", 0);
                } else {
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("follow_list");
                    JSONArray optJSONArray4 = jSONObject.optJSONArray("common_follow_list");
                    if (optJSONArray3 != null) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            UserData userData3 = new UserData();
                            userData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.asy.add(userData3);
                        }
                    }
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            UserData userData4 = new UserData();
                            userData4.parserJson(optJSONArray4.getJSONObject(i4));
                            userData4.mAttentionType = 1;
                            userData4.setHave_attention(1);
                            this.asz.add(userData4);
                        }
                    }
                    this.pageNum = jSONObject.optInt(Config.PACKAGE_NAME);
                    this.asD = jSONObject.optInt("total_follow_num", 0);
                    this.hasMore = jSONObject.optInt("has_more", 0) == 1;
                }
                this.type = jSONObject.optInt("type", 0);
                this.asE = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
