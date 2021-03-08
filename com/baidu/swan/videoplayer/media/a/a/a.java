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
    private static final SparseArray<Integer> eCs = new SparseArray<>(32);
    private static final SparseArray<String> eCt;

    static {
        eCs.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        eCs.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        eCs.put(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 2003);
        eCs.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        eCs.put(10004, 2006);
        eCs.put(701, 2007);
        eCs.put(10005, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE));
        eCs.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        eCs.put(10007, -2301);
        eCs.put(10008, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1));
        eCs.put(CyberPlayerManager.MEDIA_INFO_NET_RECONNECTING, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3));
        eCs.put(10009, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5));
        eCs.put(CyberPlayerManager.MEDIA_INFO_HARDWARE_START_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6));
        eCs.put(10003, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7));
        eCs.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8));
        eCs.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        eCs.put(3002, 3002);
        eCs.put(3003, 3003);
        eCs.put(3004, Integer.valueOf((int) PluginError.ERROR_INS_CAPACITY));
        eCt = new SparseArray<>();
        eCt.put(10007, "MEDIA_ERR_NETWORK");
        eCt.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        eCt.put(3002, "MEDIA_ERR_NETWORK");
        eCt.put(3003, "MEDIA_ERR_NETWORK");
        eCt.put(3004, "MEDIA_ERR_NETWORK");
        eCt.put(-2022, "MEDIA_ERR_NETWORK");
        eCt.put(-111, "MEDIA_ERR_NETWORK");
        eCt.put(10008, "MEDIA_ERR_DECODE");
    }

    public static int ms(int i) {
        if (eCs.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return eCs.get(i).intValue();
    }

    private static JSONObject v(String str, Object obj) {
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

    public static JSONObject mt(int i) {
        return v("errMsg", mu(i));
    }

    private static String mu(int i) {
        return eCt.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }
}
