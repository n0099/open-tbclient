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
/* loaded from: classes18.dex */
public class DlnaApi {
    private static DlnaProvider.DlnaSearchListener bWN = null;
    private static Handler b = new Handler(Looper.getMainLooper()) { // from class: com.baidu.media.dlna.DlnaApi.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    DlnaApi.bWN.onDeviceChangeNotification((Map) message.obj);
                    break;
                case 2:
                    DlnaApi.bWN.onRefreshFinishNotification(message.arg1, message.arg2);
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
    private static void onRefreshFinished(int i, int i2) {
        Message obtain = Message.obtain(b, 2);
        obtain.arg1 = i;
        obtain.arg2 = i2;
        obtain.sendToTarget();
    }

    public static void search(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        bWN = dlnaSearchListener;
        nativeSearch();
    }

    public static void stop() {
        bWN = null;
        nativeStop();
    }
}
