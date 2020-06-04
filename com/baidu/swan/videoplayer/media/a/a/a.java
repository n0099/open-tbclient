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
    private static final SparseArray<Integer> dsl = new SparseArray<>(32);
    private static final SparseArray<String> dsm;

    static {
        dsl.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        dsl.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        dsl.put(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 2003);
        dsl.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        dsl.put(10004, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND));
        dsl.put(701, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE));
        dsl.put(10005, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE));
        dsl.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        dsl.put(10007, -2301);
        dsl.put(10008, 2101);
        dsl.put(CyberPlayerManager.MEDIA_INFO_NET_RECONNECTING, 2103);
        dsl.put(10009, 2105);
        dsl.put(CyberPlayerManager.MEDIA_INFO_HARDWARE_START_FAIL_CHANGE_MODE, 2106);
        dsl.put(10003, 2107);
        dsl.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, 2108);
        dsl.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        dsl.put(3002, 3002);
        dsl.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL));
        dsl.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, 3005);
        dsm = new SparseArray<>();
        dsm.put(10007, "MEDIA_ERR_NETWORK");
        dsm.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        dsm.put(3002, "MEDIA_ERR_NETWORK");
        dsm.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, "MEDIA_ERR_NETWORK");
        dsm.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, "MEDIA_ERR_NETWORK");
        dsm.put(-2022, "MEDIA_ERR_NETWORK");
        dsm.put(-111, "MEDIA_ERR_NETWORK");
        dsm.put(10008, "MEDIA_ERR_DECODE");
    }

    public static int jE(int i) {
        if (dsl.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return dsl.get(i).intValue();
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

    public static JSONObject jF(int i) {
        return y("errMsg", jG(i));
    }

    private static String jG(int i) {
        return dsm.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }
}
