package com.baidu.media.dlna;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
import com.baidu.media.duplayer.Keep;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes.dex */
public class DlnaApi {
    private static DlnaProvider.DlnaSearchListener bhK = null;
    private static Handler b = new Handler(Looper.getMainLooper()) { // from class: com.baidu.media.dlna.DlnaApi.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    DlnaApi.bhK.onDeviceChangeNotification((Map) message.obj);
                    break;
                case 2:
                    DlnaApi.bhK.onRefreshFinishNotification();
                    break;
            }
            super.handleMessage(message);
        }
    };

    public static CtrlPointProvider ctrlPoint(String str) {
        return new CtrlPoint(nativeCtrlPoint(str));
    }

    private static native long nativeCtrlPoint(String str);

    private static native void nativeSearch();

    private static native void nativeStop();

    @Keep
    private static void onDeviceChanged(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("friendlyName", str);
        hashMap.put("uuid", str2);
        Message.obtain(b, 1, hashMap).sendToTarget();
    }

    @Keep
    private static void onRefreshFinished() {
        Message.obtain(b, 2).sendToTarget();
    }

    public static void search(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        bhK = dlnaSearchListener;
        nativeSearch();
    }

    public static void stop() {
        bhK = null;
        nativeStop();
    }
}
