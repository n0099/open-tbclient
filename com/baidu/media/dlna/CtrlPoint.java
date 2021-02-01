package com.baidu.media.dlna;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
import com.baidu.media.duplayer.Keep;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class CtrlPoint extends CtrlPointProvider {
    String c;
    CtrlPointProvider.CtrlPointListener cih;
    private long d;

    /* renamed from: b  reason: collision with root package name */
    String f3186b = null;
    private Handler e = new Handler(Looper.getMainLooper()) { // from class: com.baidu.media.dlna.CtrlPoint.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (CtrlPoint.this.cih != null) {
                        CtrlPoint.this.cih.onPrepared();
                        break;
                    }
                    break;
                case 2:
                    if (CtrlPoint.this.cih != null) {
                        CtrlPoint.this.cih.onComplete();
                        break;
                    }
                    break;
                case 3:
                    if (CtrlPoint.this.cih != null) {
                        CtrlPoint.this.cih.onError(message.arg1, message.arg2);
                        break;
                    }
                    break;
                case 4:
                    if (CtrlPoint.this.cih != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("url", CtrlPoint.this.f3186b);
                        hashMap.put("uuid", CtrlPoint.this.c);
                        CtrlPoint.this.cih.onInfo(message.arg1, message.arg2, hashMap);
                        break;
                    }
                    break;
                case 5:
                    if (CtrlPoint.this.cih != null) {
                        CtrlPoint.this.cih.onSeekCompleted(message.arg1, message.arg2);
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    };

    public CtrlPoint(long j, String str) {
        this.d = 0L;
        this.c = null;
        this.d = j;
        this.c = str;
    }

    public static boolean a(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            return packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static native long nativeCtrlPointDuration(long j);

    private static native long nativeCtrlPointGetCurrentPos(long j);

    private static native int nativeCtrlPointGetPlaybackVolume(long j);

    private static native void nativeCtrlPointPause(long j);

    private static native void nativeCtrlPointPlay(long j);

    private static native void nativeCtrlPointSeek(long j, long j2);

    private static native void nativeCtrlPointSetAVTransportURI(long j, String str);

    private static native void nativeCtrlPointSetListener(long j, Object obj);

    private static native void nativeCtrlPointSetMute(long j, int i);

    private static native void nativeCtrlPointSetPlaybackVolume(long j, int i);

    private static native void nativeCtrlPointShutdown(long j);

    private static native void nativeCtrlPointStop(long j);

    @Keep
    private static void onComplete(Object obj) {
        CtrlPoint ctrlPoint;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || ctrlPoint.e == null) {
            return;
        }
        Message.obtain(ctrlPoint.e, 2).sendToTarget();
    }

    @Keep
    private static void onError(Object obj, int i, int i2) {
        CtrlPoint ctrlPoint;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || ctrlPoint.e == null) {
            return;
        }
        Message obtain = Message.obtain(ctrlPoint.e, 3);
        obtain.arg1 = i;
        obtain.arg2 = i2;
        obtain.sendToTarget();
    }

    @Keep
    private static void onInfo(Object obj, int i, int i2) {
        CtrlPoint ctrlPoint;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || ctrlPoint.e == null) {
            return;
        }
        Message obtain = Message.obtain(ctrlPoint.e, 4);
        obtain.arg1 = i;
        obtain.arg2 = i2;
        obtain.sendToTarget();
    }

    @Keep
    private static int onNetworkStatus(Object obj) {
        Context applicationContext;
        if (obj == null || (applicationContext = CyberPlayerManager.getApplicationContext()) == null || !a(applicationContext)) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) ? 0 : activeNetworkInfo.getType() == 0 ? 1 : activeNetworkInfo.getType() == 1 ? 2 : 0;
    }

    @Keep
    private static void onPrepared(Object obj) {
        CtrlPoint ctrlPoint;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || ctrlPoint.e == null) {
            return;
        }
        Message.obtain(ctrlPoint.e, 1).sendToTarget();
    }

    @Keep
    private static void onSeekCompleted(Object obj, int i, int i2) {
        CtrlPoint ctrlPoint;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || ctrlPoint.e == null) {
            return;
        }
        Message obtain = Message.obtain(ctrlPoint.e, 5);
        obtain.arg1 = i;
        obtain.arg2 = i2;
        obtain.sendToTarget();
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public long getCurrentTime() {
        if (this.d != 0) {
            return nativeCtrlPointGetCurrentPos(this.d);
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public long getDuration() {
        if (this.d != 0) {
            return nativeCtrlPointDuration(this.d);
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public int getPlaybackVolume() {
        if (this.d != 0) {
            return nativeCtrlPointGetPlaybackVolume(this.d);
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void pause() {
        if (this.d != 0) {
            nativeCtrlPointPause(this.d);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void play() {
        if (this.d != 0) {
            nativeCtrlPointPlay(this.d);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void seek(long j) {
        if (this.d != 0) {
            nativeCtrlPointSeek(this.d, j);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setAVTransportUrl(String str) {
        if (this.d == 0 || str == null || str.length() <= 0) {
            return;
        }
        nativeCtrlPointSetAVTransportURI(this.d, str);
        this.f3186b = str;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        if (this.d != 0) {
            this.cih = ctrlPointListener;
            nativeCtrlPointSetListener(this.d, new WeakReference(this));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setMute(int i) {
        if (this.d != 0) {
            nativeCtrlPointSetMute(this.d, i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setPlaybackVolume(int i) {
        if (this.d != 0) {
            nativeCtrlPointSetPlaybackVolume(this.d, i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void shutdown() {
        if (this.d != 0) {
            nativeCtrlPointShutdown(this.d);
            this.d = 0L;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void stop() {
        if (this.d != 0) {
            nativeCtrlPointStop(this.d);
        }
    }
}
