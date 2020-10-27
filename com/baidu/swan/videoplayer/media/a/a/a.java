package com.baidu.swan.videoplayer.media.a.a;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.mapapi.UIMsg;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final SparseArray<Integer> eiD = new SparseArray<>(32);
    private static final SparseArray<String> eiE;

    static {
        eiD.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        eiD.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        eiD.put(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 2003);
        eiD.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        eiD.put(10004, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND));
        eiD.put(701, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE));
        eiD.put(10005, 2008);
        eiD.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        eiD.put(10007, -2301);
        eiD.put(10008, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1));
        eiD.put(CyberPlayerManager.MEDIA_INFO_NET_RECONNECTING, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3));
        eiD.put(10009, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5));
        eiD.put(CyberPlayerManager.MEDIA_INFO_HARDWARE_START_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6));
        eiD.put(10003, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7));
        eiD.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8));
        eiD.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        eiD.put(3002, 3002);
        eiD.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL));
        eiD.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, 3005);
        eiE = new SparseArray<>();
        eiE.put(10007, "MEDIA_ERR_NETWORK");
        eiE.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        eiE.put(3002, "MEDIA_ERR_NETWORK");
        eiE.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, "MEDIA_ERR_NETWORK");
        eiE.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, "MEDIA_ERR_NETWORK");
        eiE.put(-2022, "MEDIA_ERR_NETWORK");
        eiE.put(-111, "MEDIA_ERR_NETWORK");
        eiE.put(10008, "MEDIA_ERR_DECODE");
    }

    public static int nh(int i) {
        if (eiD.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return eiD.get(i).intValue();
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

    public static JSONObject ni(int i) {
        return x("errMsg", nj(i));
    }

    private static String nj(int i) {
        return eiE.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }
}
