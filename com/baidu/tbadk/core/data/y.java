package com.baidu.tbadk.core.data;

import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsPage.TopNotice;
/* loaded from: classes.dex */
public class y {
    private String title = null;
    private String title_link = null;
    private String author = null;
    private int id = 0;

    public String getTitle() {
        return this.title;
    }

    public String rE() {
        return this.title_link;
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.title = jSONObject.getString("title");
            this.title_link = jSONObject.getString("title_link");
            this.author = jSONObject.getString("author");
            this.id = jSONObject.getInt("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(TopNotice topNotice) {
        if (topNotice != null) {
            this.title = topNotice.title;
            this.title_link = topNotice.title_link;
            this.author = topNotice.author;
            this.id = topNotice.id.intValue();
        }
    }
}
