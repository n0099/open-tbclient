package com.baidu.swan.videoplayer.media.a.a;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mapapi.UIMsg;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final SparseArray<Integer> dwW = new SparseArray<>(32);
    private static final SparseArray<String> dwX;

    static {
        dwW.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        dwW.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        dwW.put(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 2003);
        dwW.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        dwW.put(10004, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND));
        dwW.put(701, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE));
        dwW.put(10005, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE));
        dwW.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        dwW.put(10007, -2301);
        dwW.put(10008, 2101);
        dwW.put(CyberPlayerManager.MEDIA_INFO_NET_RECONNECTING, 2103);
        dwW.put(10009, 2105);
        dwW.put(CyberPlayerManager.MEDIA_INFO_HARDWARE_START_FAIL_CHANGE_MODE, 2106);
        dwW.put(10003, 2107);
        dwW.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, 2108);
        dwW.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        dwW.put(3002, 3002);
        dwW.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL));
        dwW.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, 3005);
        dwX = new SparseArray<>();
        dwX.put(10007, "MEDIA_ERR_NETWORK");
        dwX.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        dwX.put(3002, "MEDIA_ERR_NETWORK");
        dwX.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, "MEDIA_ERR_NETWORK");
        dwX.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, "MEDIA_ERR_NETWORK");
        dwX.put(-2022, "MEDIA_ERR_NETWORK");
        dwX.put(-111, "MEDIA_ERR_NETWORK");
        dwX.put(10008, "MEDIA_ERR_DECODE");
    }

    public static int jP(int i) {
        if (dwW.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return dwW.get(i).intValue();
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

    public static JSONObject jQ(int i) {
        return y("errMsg", jR(i));
    }

    private static String jR(int i) {
        return dwX.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }
}
