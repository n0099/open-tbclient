package com.baidu.tbadk.core.data;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.YyExt;
/* loaded from: classes3.dex */
public class YyExtData implements Serializable {
    public boolean isYyGame;
    public String mSid;
    public String mSsid;
    public String mTemplateId;
    public String mYyUid;

    public void parseProtoBuf(YyExt yyExt) {
        if (yyExt == null) {
            return;
        }
        this.mSid = yyExt.sid;
        this.mSsid = yyExt.ssid;
        this.mTemplateId = yyExt.template_id;
        this.mYyUid = yyExt.yy_uid;
        this.isYyGame = yyExt.is_yy_game.intValue() == 1;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mSid = jSONObject.optString("sid");
        this.mSsid = jSONObject.optString("ssid");
        this.mTemplateId = jSONObject.optString("template_id");
        this.mYyUid = jSONObject.optString("yy_uid");
        this.isYyGame = jSONObject.optInt("is_yy_game") == 1;
    }
}
