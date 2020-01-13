package com.baidu.live.tbadk.core.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OfficialNoticeData extends BaseData {
    public String content;
    public String copyContent;
    public String end_time;
    public long id;
    public JSONObject originJsonObject;
    public String send_time;
    public String subCopyTagContent;
    public String subapp_type;
    public String url;
    public int startCopy = -1;
    public int endCopy = -1;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.originJsonObject = jSONObject;
            this.id = jSONObject.optLong("id", 0L);
            this.content = jSONObject.optString("content");
            this.url = jSONObject.optString("url");
            this.send_time = jSONObject.optString("send_time");
            this.end_time = jSONObject.optString("end_time");
            this.subapp_type = jSONObject.optString("subapp_type");
            if (!TextUtils.isEmpty(this.content)) {
                this.startCopy = this.content.indexOf("$$");
                this.endCopy = this.content.indexOf("%%");
                if (this.startCopy > -1 && this.endCopy > this.startCopy + 1) {
                    this.copyContent = this.content.substring(this.startCopy + 2, this.endCopy);
                    String str = "";
                    if (this.startCopy > 0) {
                        str = this.content.substring(0, this.startCopy);
                    }
                    String str2 = "";
                    if (this.content.length() > this.endCopy + 2) {
                        str2 = this.content.substring(this.endCopy + 2);
                    }
                    this.subCopyTagContent = str + this.copyContent + str2;
                    return;
                }
                this.subCopyTagContent = this.content;
            }
        }
    }

    public JSONObject toJsonObject() {
        return this.originJsonObject;
    }
}
