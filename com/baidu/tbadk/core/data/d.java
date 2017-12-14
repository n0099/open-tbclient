package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.AppCode;
/* loaded from: classes.dex */
public class d {
    private String button_text;
    private String game_icon;
    private String post_url;

    public String getGameIcon() {
        return this.game_icon;
    }

    public String getPostUrl() {
        return this.post_url;
    }

    public String pA() {
        return this.button_text;
    }

    public void a(AppCode appCode) {
        if (appCode != null) {
            this.game_icon = appCode.game_icon;
            this.post_url = appCode.post_url;
            this.button_text = appCode.button_text;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.game_icon = jSONObject.optString("game_icon");
                this.post_url = jSONObject.optString("post_url");
                this.button_text = jSONObject.optString("button_text");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
