package com.baidu.live.videochat.panel.a;

import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String appId;
    public int bSO;
    public String bSP;
    public String bSQ;
    public String bSR;
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
            this.bSO = jSONObject.optInt("liveconnect_status");
            this.cuid = jSONObject.optString("cuid");
            this.appId = jSONObject.optString("appid");
            this.bSP = jSONObject.optString(HttpRequest.SUBAPP_VERSION);
            this.liveId = jSONObject.optString("live_id");
            this.roomId = jSONObject.optString("room_id");
            this.bSQ = jSONObject.optString("im_uk");
            this.bSR = jSONObject.optString("uk");
        }
    }
}
