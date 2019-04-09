package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class as {
    private ArrayList<UserData> bzT = new ArrayList<>();
    private ArrayList<UserData> bzU = new ArrayList<>();
    private an bzV = new an();
    private int bzW = 0;
    private int bzX = 0;
    public int bzY;
    public String bzZ;
    public boolean hasMore;
    public int pageNum;
    public int type;

    public ArrayList<UserData> XK() {
        return this.bzT;
    }

    public ArrayList<UserData> XL() {
        return this.bzU;
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
                            this.bzT.add(userData);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            UserData userData2 = new UserData();
                            userData2.parserJson(optJSONArray2.getJSONObject(i2));
                            userData2.mAttentionType = 1;
                            this.bzU.add(userData2);
                        }
                    }
                    this.bzV.parserJson(jSONObject.optJSONObject("page"));
                    if (this.bzV != null) {
                        this.pageNum = this.bzV.XF();
                        this.bzY = this.bzV.XD();
                        this.hasMore = this.bzV.XH() == 1;
                    }
                    this.bzW = jSONObject.optInt("tafriendnum", 0);
                    this.bzX = jSONObject.optInt("commonfriendnum", 0);
                } else {
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("follow_list");
                    JSONArray optJSONArray4 = jSONObject.optJSONArray("common_follow_list");
                    if (optJSONArray3 != null) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            UserData userData3 = new UserData();
                            userData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.bzT.add(userData3);
                        }
                    }
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            UserData userData4 = new UserData();
                            userData4.parserJson(optJSONArray4.getJSONObject(i4));
                            userData4.mAttentionType = 1;
                            userData4.setHave_attention(1);
                            this.bzU.add(userData4);
                        }
                    }
                    this.pageNum = jSONObject.optInt(Config.PACKAGE_NAME);
                    this.bzY = jSONObject.optInt("total_follow_num", 0);
                    this.hasMore = jSONObject.optInt("has_more", 0) == 1;
                }
                this.type = jSONObject.optInt("type", 0);
                this.bzZ = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
