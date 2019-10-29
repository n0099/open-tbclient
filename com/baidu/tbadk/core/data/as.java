package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class as {
    private ArrayList<UserData> cam = new ArrayList<>();
    private ArrayList<UserData> can = new ArrayList<>();
    private an cao = new an();
    private int cap = 0;
    private int caq = 0;
    public int car;
    public String cas;
    public boolean hasMore;
    public int pageNum;
    public int type;

    public ArrayList<UserData> ahD() {
        return this.cam;
    }

    public ArrayList<UserData> ahE() {
        return this.can;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optJSONObject("page") != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            UserData userData = new UserData();
                            userData.parserJson(optJSONArray.getJSONObject(i));
                            this.cam.add(userData);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            UserData userData2 = new UserData();
                            userData2.parserJson(optJSONArray2.getJSONObject(i2));
                            userData2.mAttentionType = 1;
                            this.can.add(userData2);
                        }
                    }
                    this.cao.parserJson(jSONObject.optJSONObject("page"));
                    if (this.cao != null) {
                        this.pageNum = this.cao.ahy();
                        this.car = this.cao.ahw();
                        this.hasMore = this.cao.ahA() == 1;
                    }
                    this.cap = jSONObject.optInt("tafriendnum", 0);
                    this.caq = jSONObject.optInt("commonfriendnum", 0);
                } else {
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("follow_list");
                    JSONArray optJSONArray4 = jSONObject.optJSONArray("common_follow_list");
                    if (optJSONArray3 != null) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            UserData userData3 = new UserData();
                            userData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.cam.add(userData3);
                        }
                    }
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            UserData userData4 = new UserData();
                            userData4.parserJson(optJSONArray4.getJSONObject(i4));
                            userData4.mAttentionType = 1;
                            userData4.setHave_attention(1);
                            this.can.add(userData4);
                        }
                    }
                    this.pageNum = jSONObject.optInt(Config.PACKAGE_NAME);
                    this.car = jSONObject.optInt("total_follow_num", 0);
                    this.hasMore = jSONObject.optInt("has_more", 0) == 1;
                }
                this.type = jSONObject.optInt("type", 0);
                this.cas = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
