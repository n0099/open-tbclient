package com.baidu.tbadk.core.data;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PraiseData implements Serializable {
    private static final long serialVersionUID = 2658065756886586666L;
    private String title = "";
    private long num = 0;
    private ArrayList<MetaData> users = new ArrayList<>();
    private int isLike = 0;

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
            com.baidu.adp.lib.util.f.b("MetaData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.num = jSONObject.optLong("num", 0L);
                this.isLike = jSONObject.optInt("is_liked", 0);
                JSONArray jSONArray = jSONObject.getJSONArray("liker_list");
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserJson(jSONArray.getJSONObject(i));
                        this.users.add(metaData);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("Praise", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public String toString() {
        return "PraiseData{num='" + this.num + "', isLike=" + this.isLike + ", user='" + this.users.size() + '}';
    }
}
