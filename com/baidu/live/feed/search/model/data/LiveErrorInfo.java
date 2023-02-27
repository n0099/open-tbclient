package com.baidu.live.feed.search.model.data;

import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveErrorInfo {
    public String errMsg;
    public int errno;
    public String logId;
    public long serverTime;
    public long time;
    public String userMsg;

    public void loadFromJSON(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.errno = jSONObject.optInt("errno");
            this.errMsg = jSONObject.optString("errmsg");
            this.userMsg = jSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
            this.serverTime = jSONObject.optLong("server_time");
            this.time = jSONObject.optLong("time");
            this.logId = jSONObject.optString("logId");
        }
    }
}
