package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreInvoker;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
@Keep
/* loaded from: classes3.dex */
public class Dlna {
    public static int DLNA_ERROR_CREATE_CTRL_POINT_TIMER_THREAD_FAIL = -1011;
    public static int DLNA_ERROR_CREATE_SSDP_THREAD_FIAL = -1017;
    public static int DLNA_ERROR_DATA_INVALIDATE = -1015;
    public static int DLNA_ERROR_DEVICE_CONNECT_TIMEOUT = -1002;
    public static int DLNA_ERROR_GET_MEDIA_INFO_ACTION_NOT_FOUND = -1006;
    public static int DLNA_ERROR_GET_MUTE_ACTION_NOT_FOUND = -1008;
    public static int DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND = -1009;
    public static int DLNA_ERROR_GET_TRANSPORT_INFO_ACTION_NOT_FOUND = -1010;
    public static int DLNA_ERROR_NO_DEVICE = -1016;
    public static int DLNA_ERROR_PARSE_FAIL = -1014;
    public static int DLNA_ERROR_PAUSE_ACTION_NOT_FOUND = -1004;
    public static int DLNA_ERROR_PLAY_ACTION_NOT_FOUND = -1001;
    public static int DLNA_ERROR_SEEK_ACTION_NOT_FOUND = -1005;
    public static int DLNA_ERROR_SET_AV_TRANSPORT_URI_ACTION_NOT_FOUND = -1003;
    public static int DLNA_ERROR_SET_MUTE_ACTION_NOT_FOUND = -1007;
    public static int DLNA_ERROR_SET_VOLUME_ACTION_NOT_FOUND = -1013;
    public static int DLNA_ERROR_STOP_ACTION_NOT_FOUND = -1012;
    public static int DLNA_ERROR_STOP_SPCE_INVALIDATE = -1018;
    public static String TAG = "DLNA";
    public DlnaProvider provider;

    /* loaded from: classes3.dex */
    public static class DlnaHolder {
        public static final Dlna sInstance = new Dlna();
    }

    public Dlna() {
        this.provider = null;
    }

    public static Dlna getInstance() {
        return DlnaHolder.sInstance;
    }

    public synchronized void stop() {
        if (this.provider != null) {
            this.provider.stop();
        } else {
            CyberLog.d(TAG, "Dlna: provider == null");
        }
    }

    public synchronized PnPController getCtrlPoint(String str) {
        if (this.provider != null && str != null) {
            return new PnPController(str, this.provider);
        }
        return null;
    }

    public synchronized void refresh(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        if (this.provider == null) {
            this.provider = CyberPlayerCoreInvoker.createDLNA();
        }
        if (this.provider != null) {
            this.provider.stop();
            if (dlnaSearchListener != null) {
                this.provider.search(dlnaSearchListener);
            }
        }
    }
}
