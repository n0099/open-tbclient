package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
@Keep
/* loaded from: classes2.dex */
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

    /* renamed from: a  reason: collision with root package name */
    public DlnaProvider f4817a;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final Dlna f4818a = new Dlna();
    }

    public Dlna() {
        this.f4817a = null;
    }

    public static Dlna getInstance() {
        return a.f4818a;
    }

    public synchronized PnPController getCtrlPoint(String str) {
        if (this.f4817a != null && str != null) {
            return new PnPController(str, this.f4817a);
        }
        return null;
    }

    public synchronized void refresh(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        if (this.f4817a == null) {
            this.f4817a = d.f();
        }
        if (this.f4817a != null) {
            this.f4817a.stop();
            if (dlnaSearchListener != null) {
                this.f4817a.search(dlnaSearchListener);
            }
        }
    }

    public synchronized void stop() {
        if (this.f4817a != null) {
            this.f4817a.stop();
        } else {
            CyberLog.d(TAG, "Dlna: provider == null");
        }
    }
}
