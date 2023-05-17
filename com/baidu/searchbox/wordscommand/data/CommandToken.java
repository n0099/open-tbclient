package com.baidu.searchbox.wordscommand.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommandToken implements Serializable {
    public final String content;
    public final JSONObject logparam;

    public CommandToken(JSONObject jSONObject) {
        this.content = jSONObject.optString("content");
        this.logparam = jSONObject.optJSONObject("logparam");
    }
}
