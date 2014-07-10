package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Zan;
/* loaded from: classes.dex */
public class PraiseData implements Serializable {
    private static final long serialVersionUID = 2658065756886586666L;
    private HashMap<String, MetaData> userMap;
    private String title = "";
    private String postId = "";
    private long num = 0;
    private ArrayList<MetaData> users = new ArrayList<>();
    private int isLike = 0;

    public boolean isPriaseDataValid() {
        return this.num > 0 && this.users != null && this.users.size() >= 1;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public String getPostId() {
        return this.postId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public long getNum() {
        return this.num;
    }

    public void setNum(long j) {
        this.num = j;
    }

    public ArrayList<MetaData> getUser() {
        return this.users;
    }

    public void setUser(ArrayList<MetaData> arrayList) {
        this.users = arrayList;
    }

    public int getIsLike() {
        return this.isLike;
    }

    public void setIsLike(int i) {
        this.isLike = i;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        MetaData metaData;
        int i = 0;
        if (jSONObject != null) {
            try {
                this.num = jSONObject.optLong("num", 0L);
                this.isLike = jSONObject.optInt("is_liked", 0);
                JSONArray jSONArray = jSONObject.getJSONArray("liker_id");
                if (jSONArray == null || jSONArray.length() <= 0) {
                    return;
                }
                while (true) {
                    int i2 = i;
                    if (i2 < jSONArray.length()) {
                        String optString = jSONArray.optString(i2);
                        if (this.userMap != null && optString != null && optString.length() > 0 && (metaData = this.userMap.get(optString)) != null) {
                            this.users.add(metaData);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserProtobuf(Zan zan) {
        MetaData metaData;
        if (zan != null) {
            this.num = zan.num.intValue();
            this.isLike = zan.is_liked.intValue();
            List<Integer> list = zan.liker_id;
            if (list != null && list.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < list.size()) {
                        String num = list.get(i2).toString();
                        if (this.userMap != null && num != null && !num.equals("0") && (metaData = this.userMap.get(num)) != null) {
                            this.users.add(metaData);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
