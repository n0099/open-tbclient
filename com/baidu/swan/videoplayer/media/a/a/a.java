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
    private static final SparseArray<Integer> emN = new SparseArray<>(32);
    private static final SparseArray<String> emO;

    static {
        emN.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        emN.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        emN.put(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 2003);
        emN.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        emN.put(10004, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND));
        emN.put(701, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE));
        emN.put(10005, 2008);
        emN.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        emN.put(10007, -2301);
        emN.put(10008, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1));
        emN.put(CyberPlayerManager.MEDIA_INFO_NET_RECONNECTING, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3));
        emN.put(10009, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5));
        emN.put(CyberPlayerManager.MEDIA_INFO_HARDWARE_START_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6));
        emN.put(10003, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7));
        emN.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8));
        emN.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        emN.put(3002, 3002);
        emN.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL));
        emN.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, 3005);
        emO = new SparseArray<>();
        emO.put(10007, "MEDIA_ERR_NETWORK");
        emO.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        emO.put(3002, "MEDIA_ERR_NETWORK");
        emO.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, "MEDIA_ERR_NETWORK");
        emO.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, "MEDIA_ERR_NETWORK");
        emO.put(-2022, "MEDIA_ERR_NETWORK");
        emO.put(-111, "MEDIA_ERR_NETWORK");
        emO.put(10008, "MEDIA_ERR_DECODE");
    }

    public static int nn(int i) {
        if (emN.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return emN.get(i).intValue();
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

    public static JSONObject no(int i) {
        return x("errMsg", np(i));
    }

    private static String np(int i) {
        return emO.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }
}
