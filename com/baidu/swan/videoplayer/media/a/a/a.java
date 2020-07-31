package com.baidu.swan.videoplayer.media.a.a;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.mapapi.UIMsg;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final SparseArray<Integer> dCO = new SparseArray<>(32);
    private static final SparseArray<String> dCP;

    static {
        dCO.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        dCO.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        dCO.put(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 2003);
        dCO.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        dCO.put(10004, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND));
        dCO.put(701, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE));
        dCO.put(10005, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE));
        dCO.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        dCO.put(10007, -2301);
        dCO.put(10008, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1));
        dCO.put(CyberPlayerManager.MEDIA_INFO_NET_RECONNECTING, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3));
        dCO.put(10009, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5));
        dCO.put(CyberPlayerManager.MEDIA_INFO_HARDWARE_START_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6));
        dCO.put(10003, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7));
        dCO.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8));
        dCO.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        dCO.put(3002, 3002);
        dCO.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL));
        dCO.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, 3005);
        dCP = new SparseArray<>();
        dCP.put(10007, "MEDIA_ERR_NETWORK");
        dCP.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        dCP.put(3002, "MEDIA_ERR_NETWORK");
        dCP.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, "MEDIA_ERR_NETWORK");
        dCP.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, "MEDIA_ERR_NETWORK");
        dCP.put(-2022, "MEDIA_ERR_NETWORK");
        dCP.put(-111, "MEDIA_ERR_NETWORK");
        dCP.put(10008, "MEDIA_ERR_DECODE");
    }

    public static int ki(int i) {
        if (dCO.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return dCO.get(i).intValue();
    }

    private static JSONObject y(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (obj instanceof Integer) {
                jSONObject.put(str, ((Integer) obj).intValue());
            } else if (obj instanceof String) {
                jSONObject.put(str, obj);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static JSONObject kj(int i) {
        return y("errMsg", kk(i));
    }

    private static String kk(int i) {
        return dCP.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }
}
