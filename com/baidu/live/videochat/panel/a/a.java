package com.baidu.live.videochat.panel.a;

import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String appId;
    public String bNA;
    public int bNx;
    public String bNy;
    public String bNz;
    public String cuid;
    public String liveId;
    public String portrait;
    public String roomId;
    public String userId;
    public String userName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("show_name");
            this.portrait = jSONObject.optString("portrait");
            this.bNx = jSONObject.optInt("liveconnect_status");
            this.cuid = jSONObject.optString("cuid");
            this.appId = jSONObject.optString("appid");
            this.bNy = jSONObject.optString(HttpRequest.SUBAPP_VERSION);
            this.liveId = jSONObject.optString("live_id");
            this.roomId = jSONObject.optString("room_id");
            this.bNz = jSONObject.optString("im_uk");
            this.bNA = jSONObject.optString("uk");
        }
    }
}
