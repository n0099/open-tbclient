package com.baidu.swan.videoplayer.media.a.a;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.mapapi.UIMsg;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final SparseArray<Integer> etP = new SparseArray<>(32);
    private static final SparseArray<String> etQ;

    static {
        etP.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        etP.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        etP.put(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 2003);
        etP.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        etP.put(10004, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND));
        etP.put(701, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE));
        etP.put(10005, 2008);
        etP.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        etP.put(10007, -2301);
        etP.put(10008, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1));
        etP.put(CyberPlayerManager.MEDIA_INFO_NET_RECONNECTING, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3));
        etP.put(10009, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5));
        etP.put(CyberPlayerManager.MEDIA_INFO_HARDWARE_START_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6));
        etP.put(10003, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7));
        etP.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8));
        etP.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        etP.put(3002, 3002);
        etP.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL));
        etP.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, 3005);
        etQ = new SparseArray<>();
        etQ.put(10007, "MEDIA_ERR_NETWORK");
        etQ.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        etQ.put(3002, "MEDIA_ERR_NETWORK");
        etQ.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, "MEDIA_ERR_NETWORK");
        etQ.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, "MEDIA_ERR_NETWORK");
        etQ.put(-2022, "MEDIA_ERR_NETWORK");
        etQ.put(-111, "MEDIA_ERR_NETWORK");
        etQ.put(10008, "MEDIA_ERR_DECODE");
    }

    public static int nL(int i) {
        if (etP.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return etP.get(i).intValue();
    }

    private static JSONObject w(String str, Object obj) {
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

    public static JSONObject nM(int i) {
        return w("errMsg", nN(i));
    }

    private static String nN(int i) {
        return etQ.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }
}
