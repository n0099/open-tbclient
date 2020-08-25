package com.baidu.swan.videoplayer.media.a.a;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.mapapi.UIMsg;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final SparseArray<Integer> dLY = new SparseArray<>(32);
    private static final SparseArray<String> dLZ;

    static {
        dLY.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        dLY.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        dLY.put(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 2003);
        dLY.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        dLY.put(10004, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND));
        dLY.put(701, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE));
        dLY.put(10005, 2008);
        dLY.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        dLY.put(10007, -2301);
        dLY.put(10008, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1));
        dLY.put(CyberPlayerManager.MEDIA_INFO_NET_RECONNECTING, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3));
        dLY.put(10009, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5));
        dLY.put(CyberPlayerManager.MEDIA_INFO_HARDWARE_START_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6));
        dLY.put(10003, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7));
        dLY.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8));
        dLY.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        dLY.put(3002, 3002);
        dLY.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL));
        dLY.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, 3005);
        dLZ = new SparseArray<>();
        dLZ.put(10007, "MEDIA_ERR_NETWORK");
        dLZ.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        dLZ.put(3002, "MEDIA_ERR_NETWORK");
        dLZ.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, "MEDIA_ERR_NETWORK");
        dLZ.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, "MEDIA_ERR_NETWORK");
        dLZ.put(-2022, "MEDIA_ERR_NETWORK");
        dLZ.put(-111, "MEDIA_ERR_NETWORK");
        dLZ.put(10008, "MEDIA_ERR_DECODE");
    }

    public static int mo(int i) {
        if (dLY.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return dLY.get(i).intValue();
    }

    private static JSONObject x(String str, Object obj) {
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

    public static JSONObject mp(int i) {
        return x("errMsg", mq(i));
    }

    private static String mq(int i) {
        return dLZ.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }
}
