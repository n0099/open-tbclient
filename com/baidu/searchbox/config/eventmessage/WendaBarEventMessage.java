package com.baidu.searchbox.config.eventmessage;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class WendaBarEventMessage {
    public JSONObject extObj;
    public String scheme;
    public int status;
    public String titleName;

    public WendaBarEventMessage(int i, String str, String str2, JSONObject jSONObject) {
        this.extObj = new JSONObject();
        this.status = i;
        this.titleName = str;
        this.scheme = str2;
        this.extObj = jSONObject;
    }

    public String toString() {
        return "status=" + this.status + " titleName=" + this.titleName + " scheme=" + this.scheme + " extObj=" + String.valueOf(this.extObj);
    }
}
