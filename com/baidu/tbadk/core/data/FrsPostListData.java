package com.baidu.tbadk.core.data;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FrsPostListData implements Serializable {
    private static final long serialVersionUID = 2658065756886589999L;
    private long id = 0;
    private MetaData author = new MetaData();
    private String abstract_text = "";
    private ArrayList<j> mMedias = new ArrayList<>();

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String getAbstract_text() {
        return this.abstract_text;
    }

    public void setAbstract_text(String str) {
        this.abstract_text = str;
    }

    public ArrayList<j> getmMedias() {
        return this.mMedias;
    }

    public void setmMedias(ArrayList<j> arrayList) {
        this.mMedias = arrayList;
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
                this.id = jSONObject.optLong("id", 0L);
                StringBuilder sb = new StringBuilder();
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (optJSONArray.getJSONObject(i) != null) {
                            if (optJSONArray.getJSONObject(i).optInt("type") == 0) {
                                sb.append(optJSONArray.getJSONObject(i).optString("text"));
                            }
                        } else {
                            return;
                        }
                    }
                }
                this.abstract_text = sb.toString();
                this.author.parserJson(jSONObject.optJSONObject("author"));
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        j jVar = new j();
                        jVar.a(optJSONArray2.getJSONObject(i2));
                        this.mMedias.add(jVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("Praise", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public String toString() {
        return "FrsPostListData{id='" + this.id + "', abstract_text=" + this.abstract_text + ", author='" + this.author.toString() + '}';
    }
}
