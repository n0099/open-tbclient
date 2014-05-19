package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsPage.TopNotice;
/* loaded from: classes.dex */
public class p {
    private String a = null;
    private String b = null;
    private String c = null;
    private int d = 0;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        try {
            this.a = jSONObject.getString("title");
            this.b = jSONObject.getString("title_link");
            this.c = jSONObject.getString("author");
            this.d = jSONObject.getInt("id");
            BdLog.d("TOPNotice:title:" + this.a + " link:" + this.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(TopNotice topNotice) {
        if (topNotice != null) {
            this.a = topNotice.title;
            this.b = topNotice.title_link;
            this.c = topNotice.author;
            this.d = topNotice.id.intValue();
        }
    }
}
