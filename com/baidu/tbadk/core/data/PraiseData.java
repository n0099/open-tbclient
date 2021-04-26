package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ThreadExpressionActivityConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Zan;
/* loaded from: classes3.dex */
public class PraiseData extends OrmObject implements Serializable {
    public static final long serialVersionUID = 2658065756886586666L;
    public HashMap<String, MetaData> userMap;
    public String title = "";
    public String postId = "";
    public long num = 0;
    public ArrayList<MetaData> users = new ArrayList<>();
    public int isLike = 0;

    public int getIsLike() {
        return this.isLike;
    }

    public long getNum() {
        return this.num;
    }

    public String getPostId() {
        return this.postId;
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<MetaData> getUser() {
        return this.users;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public boolean isPriaseDataValid() {
        ArrayList<MetaData> arrayList;
        return this.num > 0 && (arrayList = this.users) != null && arrayList.size() >= 1;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void parserProtobuf(Zan zan) {
        MetaData metaData;
        if (zan == null) {
            return;
        }
        this.num = zan.num.intValue();
        this.isLike = zan.is_liked.intValue();
        List<Long> list = zan.liker_id;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            String l = list.get(i2).toString();
            if (this.userMap != null && l != null && !l.equals("0") && (metaData = this.userMap.get(l)) != null) {
                this.users.add(metaData);
            }
        }
    }

    public void setIsLike(int i2) {
        this.isLike = i2;
    }

    public void setNum(long j) {
        this.num = j;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUser(ArrayList<MetaData> arrayList) {
        this.users = arrayList;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public void parserJson(JSONObject jSONObject) {
        MetaData metaData;
        if (jSONObject == null) {
            return;
        }
        try {
            this.num = jSONObject.optLong("num", 0L);
            this.isLike = jSONObject.optInt(ThreadExpressionActivityConfig.IS_LIKED, 0);
            JSONArray jSONArray = jSONObject.getJSONArray("liker_id");
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String optString = jSONArray.optString(i2);
                if (this.userMap != null && optString != null && optString.length() > 0 && (metaData = this.userMap.get(optString)) != null) {
                    this.users.add(metaData);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
