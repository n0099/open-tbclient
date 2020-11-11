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
    private static final SparseArray<Integer> eox = new SparseArray<>(32);
    private static final SparseArray<String> eoy;

    static {
        eox.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        eox.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        eox.put(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 2003);
        eox.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        eox.put(10004, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND));
        eox.put(701, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE));
        eox.put(10005, 2008);
        eox.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        eox.put(10007, -2301);
        eox.put(10008, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1));
        eox.put(CyberPlayerManager.MEDIA_INFO_NET_RECONNECTING, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3));
        eox.put(10009, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5));
        eox.put(CyberPlayerManager.MEDIA_INFO_HARDWARE_START_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6));
        eox.put(10003, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7));
        eox.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8));
        eox.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        eox.put(3002, 3002);
        eox.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL));
        eox.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, 3005);
        eoy = new SparseArray<>();
        eoy.put(10007, "MEDIA_ERR_NETWORK");
        eoy.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        eoy.put(3002, "MEDIA_ERR_NETWORK");
        eoy.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, "MEDIA_ERR_NETWORK");
        eoy.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, "MEDIA_ERR_NETWORK");
        eoy.put(-2022, "MEDIA_ERR_NETWORK");
        eoy.put(-111, "MEDIA_ERR_NETWORK");
        eoy.put(10008, "MEDIA_ERR_DECODE");
    }

    public static int nr(int i) {
        if (eox.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return eox.get(i).intValue();
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

    public static JSONObject ns(int i) {
        return x("errMsg", nt(i));
    }

    private static String nt(int i) {
        return eoy.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }
}
