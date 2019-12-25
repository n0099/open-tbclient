package com.baidu.m.a;

import android.content.Context;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.rtc.RtcConfig;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static RtcConfig m(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            RtcConfig rtcConfig = new RtcConfig();
            rtcConfig.roomId = jSONObject.optInt("roomId");
            rtcConfig.lineId = jSONObject.optInt("lineId");
            rtcConfig.hostName = jSONObject.optString("domain");
            rtcConfig.hostPort = jSONObject.optInt(ClientCookie.PORT_ATTR);
            rtcConfig.userId = jSONObject.optInt(TbEnum.SystemMessage.KEY_USER_ID);
            rtcConfig.pushUrl = jSONObject.optString("pushUrl");
            rtcConfig.identity = jSONObject.optInt(HTTP.IDENTITY_CODING);
            rtcConfig.devicePosition = jSONObject.optString("devicePosition");
            rtcConfig.cuid = com.baidu.swan.apps.w.a.Rp().bn(context);
            if (rtcConfig.lineId < 1 || rtcConfig.lineId > 9) {
                return null;
            }
            if (rtcConfig.roomId == 0 || rtcConfig.hostPort == 0) {
                return null;
            }
            return rtcConfig;
        }
        return null;
    }
}
