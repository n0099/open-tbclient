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
/* loaded from: classes3.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final SparseArray<Integer> eDw = new SparseArray<>(32);
    private static final SparseArray<String> eDx;

    static {
        eDw.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        eDw.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        eDw.put(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 2003);
        eDw.put(10012, 2004);
        eDw.put(10004, 2006);
        eDw.put(701, 2007);
        eDw.put(10005, 2008);
        eDw.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        eDw.put(10007, -2301);
        eDw.put(10008, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1));
        eDw.put(CyberPlayerManager.MEDIA_INFO_NET_RECONNECTING, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3));
        eDw.put(10009, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5));
        eDw.put(10010, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6));
        eDw.put(10003, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7));
        eDw.put(10011, Integer.valueOf((int) RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8));
        eDw.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        eDw.put(3002, 3002);
        eDw.put(3003, 3003);
        eDw.put(3004, Integer.valueOf((int) PluginError.ERROR_INS_CAPACITY));
        eDx = new SparseArray<>();
        eDx.put(10007, "MEDIA_ERR_NETWORK");
        eDx.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        eDx.put(3002, "MEDIA_ERR_NETWORK");
        eDx.put(3003, "MEDIA_ERR_NETWORK");
        eDx.put(3004, "MEDIA_ERR_NETWORK");
        eDx.put(-2022, "MEDIA_ERR_NETWORK");
        eDx.put(-111, "MEDIA_ERR_NETWORK");
        eDx.put(10008, "MEDIA_ERR_DECODE");
    }

    public static int nU(int i) {
        if (eDw.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return eDw.get(i).intValue();
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

    public static JSONObject nV(int i) {
        return w("errMsg", nW(i));
    }

    private static String nW(int i) {
        return eDx.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }
}
