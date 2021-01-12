package com.baidu.searchbox.config.eventmessage;

import org.json.JSONObject;
/* loaded from: classes3.dex */
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
        StringBuilder sb = new StringBuilder();
        sb.append("status=").append(this.status).append(" titleName=").append(this.titleName).append(" scheme=").append(this.scheme).append(" extObj=").append(String.valueOf(this.extObj));
        return sb.toString();
    }
}
