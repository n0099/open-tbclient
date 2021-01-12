package com.baidu.swan.videoplayer.media.a.a;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.mapapi.UIMsg;
import com.baidu.swan.apps.b;
import com.kwai.sodler.lib.ext.PluginError;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final SparseArray<Integer> eyK = new SparseArray<>(32);
    private static final SparseArray<String> eyL;

    static {
        eyK.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        eyK.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        eyK.put(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 2003);
        eyK.put(10012, 2004);
        eyK.put(10004, 2006);
        eyK.put(701, 2007);
        eyK.put(10005, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE));
        eyK.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        eyK.put(10007, -2301);
        eyK.put(10008, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1));
        eyK.put(CyberPlayerManager.MEDIA_INFO_NET_RECONNECTING, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3));
        eyK.put(10009, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5));
        eyK.put(10010, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6));
        eyK.put(10003, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7));
        eyK.put(10011, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8));
        eyK.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        eyK.put(3002, 3002);
        eyK.put(3003, 3003);
        eyK.put(3004, Integer.valueOf((int) PluginError.ERROR_INS_CAPACITY));
        eyL = new SparseArray<>();
        eyL.put(10007, "MEDIA_ERR_NETWORK");
        eyL.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        eyL.put(3002, "MEDIA_ERR_NETWORK");
        eyL.put(3003, "MEDIA_ERR_NETWORK");
        eyL.put(3004, "MEDIA_ERR_NETWORK");
        eyL.put(-2022, "MEDIA_ERR_NETWORK");
        eyL.put(-111, "MEDIA_ERR_NETWORK");
        eyL.put(10008, "MEDIA_ERR_DECODE");
    }

    public static int mo(int i) {
        if (eyK.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return eyK.get(i).intValue();
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

    public static JSONObject mp(int i) {
        return w("errMsg", mq(i));
    }

    private static String mq(int i) {
        return eyL.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }
}
