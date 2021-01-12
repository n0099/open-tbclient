package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
@Keep
/* loaded from: classes5.dex */
public class Dlna {

    /* renamed from: a  reason: collision with root package name */
    private static String f1756a = "com.baidu.media.dlna.DlnaProviderImpl";

    /* renamed from: b  reason: collision with root package name */
    private static DlnaProvider f1757b = null;
    public static int DLNA_ERROR_PLAY_ACTION_NOT_FOUND = -1001;
    public static int DLNA_ERROR_DEVICE_CONNECT_TIMEOUT = -1002;
    public static int DLNA_ERROR_SET_AV_TRANSPORT_URI_ACTION_NOT_FOUND = -1003;
    public static int DLNA_ERROR_PAUSE_ACTION_NOT_FOUND = -1004;
    public static int DLNA_ERROR_SEEK_ACTION_NOT_FOUND = -1005;
    public static int DLNA_ERROR_GET_MEDIA_INFO_ACTION_NOT_FOUND = -1006;
    public static int DLNA_ERROR_SET_MUTE_ACTION_NOT_FOUND = -1007;
    public static int DLNA_ERROR_GET_MUTE_ACTION_NOT_FOUND = -1008;
    public static int DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND = DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND;
    public static int DLNA_ERROR_GET_TRANSPORT_INFO_ACTION_NOT_FOUND = -1010;
    public static int DLNA_ERROR_CREATE_CTRL_POINT_TIMER_THREAD_FAIL = DlnaManager.DLNA_ERROR_CREATE_CTRL_POINT_TIMER_THREAD_FAIL;
    public static int DLNA_ERROR_STOP_ACTION_NOT_FOUND = -1012;
    public static int DLNA_ERROR_SET_VOLUME_ACTION_NOT_FOUND = DlnaManager.DLNA_ERROR_SET_VOLUME_ACTION_NOT_FOUND;
    public static int DLNA_ERROR_PARSE_FAIL = DlnaManager.DLNA_ERROR_PARSE_FAIL;
    public static int DLNA_ERROR_DATA_INVALIDATE = DlnaManager.DLNA_ERROR_DATA_INVALIDATE;
    public static int DLNA_ERROR_NO_DEVICE = DlnaManager.DLNA_ERROR_NO_DEVICE;
    public static int DLNA_ERROR_CREATE_SSDP_THREAD_FIAL = DlnaManager.DLNA_ERROR_CREATE_SSDP_THREAD_FIAL;
    public static int DLNA_ERROR_STOP_SPCE_INVALIDATE = DlnaManager.DLNA_ERROR_STOP_SPCE_INVALIDATE;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Dlna f1758a = new Dlna();
    }

    private Dlna() {
    }

    public static Dlna getInstance() {
        return a.f1758a;
    }

    public static void init(ClassLoader classLoader) {
        try {
            f1757b = (DlnaProvider) Class.forName(f1756a, true, classLoader).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            f1757b = null;
        }
    }

    public PnPController getCtrlPoint(String str) {
        if (f1757b == null || str == null) {
            return null;
        }
        return new PnPController(str, f1757b);
    }

    public void refresh(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        if (f1757b != null) {
            f1757b.stop();
            f1757b.search(dlnaSearchListener);
        }
    }

    public void stop() {
        if (f1757b != null) {
            f1757b.stop();
        }
    }
}
