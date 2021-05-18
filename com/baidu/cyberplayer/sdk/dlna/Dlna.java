package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
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

    /* renamed from: a  reason: collision with root package name */
    public static String f4928a = "com.baidu.media.dlna.DlnaProviderImpl";

    /* renamed from: b  reason: collision with root package name */
    public static DlnaProvider f4929b;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final Dlna f4930a = new Dlna();
    }

    public Dlna() {
    }

    public static Dlna getInstance() {
        return a.f4930a;
    }

    public static void init(ClassLoader classLoader) {
        try {
            f4929b = (DlnaProvider) Class.forName(f4928a, true, classLoader).newInstance();
        } catch (Exception e2) {
            e2.printStackTrace();
            f4929b = null;
        }
    }

    public PnPController getCtrlPoint(String str) {
        DlnaProvider dlnaProvider = f4929b;
        if (dlnaProvider == null || str == null) {
            return null;
        }
        return new PnPController(str, dlnaProvider);
    }

    public void refresh(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        DlnaProvider dlnaProvider = f4929b;
        if (dlnaProvider != null) {
            dlnaProvider.stop();
            f4929b.search(dlnaSearchListener);
        }
    }

    public void stop() {
        DlnaProvider dlnaProvider = f4929b;
        if (dlnaProvider != null) {
            dlnaProvider.stop();
        }
    }
}
