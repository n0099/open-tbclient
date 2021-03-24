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
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class CtrlPoint extends CtrlPointProvider {

    /* renamed from: a  reason: collision with root package name */
    public long f7925a;

    /* renamed from: b  reason: collision with root package name */
    public CtrlPointProvider.CtrlPointListener f7926b;

    /* renamed from: d  reason: collision with root package name */
    public String f7928d;

    /* renamed from: c  reason: collision with root package name */
    public String f7927c = null;

    /* renamed from: e  reason: collision with root package name */
    public Handler f7929e = new a(Looper.getMainLooper());

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CtrlPointProvider.CtrlPointListener ctrlPointListener;
            int i = message.what;
            if (i == 1) {
                CtrlPointProvider.CtrlPointListener ctrlPointListener2 = CtrlPoint.this.f7926b;
                if (ctrlPointListener2 != null) {
                    ctrlPointListener2.onPrepared();
                }
            } else if (i == 2) {
                CtrlPointProvider.CtrlPointListener ctrlPointListener3 = CtrlPoint.this.f7926b;
                if (ctrlPointListener3 != null) {
                    ctrlPointListener3.onComplete();
                }
            } else if (i == 3) {
                CtrlPointProvider.CtrlPointListener ctrlPointListener4 = CtrlPoint.this.f7926b;
                if (ctrlPointListener4 != null) {
                    ctrlPointListener4.onError(message.arg1, message.arg2);
                }
            } else if (i != 4) {
                if (i == 5 && (ctrlPointListener = CtrlPoint.this.f7926b) != null) {
                    ctrlPointListener.onSeekCompleted(message.arg1, message.arg2);
                }
            } else if (CtrlPoint.this.f7926b != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("url", CtrlPoint.this.f7927c);
                hashMap.put("uuid", CtrlPoint.this.f7928d);
                CtrlPoint.this.f7926b.onInfo(message.arg1, message.arg2, hashMap);
            }
            super.handleMessage(message);
        }
    }

    public CtrlPoint(long j, String str) {
        this.f7925a = 0L;
        this.f7928d = null;
        this.f7925a = j;
        this.f7928d = str;
    }

    public static boolean a(Context context) {
        PackageManager packageManager;
        if (context != null && (packageManager = context.getPackageManager()) != null) {
            try {
                return packageManager.checkPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, context.getPackageName()) == 0;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static native long nativeCtrlPointDuration(long j);

    public static native long nativeCtrlPointGetCurrentPos(long j);

    public static native int nativeCtrlPointGetPlaybackVolume(long j);

    public static native void nativeCtrlPointPause(long j);

    public static native void nativeCtrlPointPlay(long j);

    public static native void nativeCtrlPointSeek(long j, long j2);

    public static native void nativeCtrlPointSetAVTransportURI(long j, String str);

    public static native void nativeCtrlPointSetListener(long j, Object obj);

    public static native void nativeCtrlPointSetMute(long j, int i);

    public static native void nativeCtrlPointSetPlaybackVolume(long j, int i);

    public static native void nativeCtrlPointShutdown(long j);

    public static native void nativeCtrlPointStop(long j);

    @Keep
    public static void onComplete(Object obj) {
        CtrlPoint ctrlPoint;
        Handler handler;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || (handler = ctrlPoint.f7929e) == null) {
            return;
        }
        Message.obtain(handler, 2).sendToTarget();
    }

    @Keep
    public static void onError(Object obj, int i, int i2) {
        CtrlPoint ctrlPoint;
        Handler handler;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || (handler = ctrlPoint.f7929e) == null) {
            return;
        }
        Message obtain = Message.obtain(handler, 3);
        obtain.arg1 = i;
        obtain.arg2 = i2;
        obtain.sendToTarget();
    }

    @Keep
    public static void onInfo(Object obj, int i, int i2) {
        CtrlPoint ctrlPoint;
        Handler handler;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || (handler = ctrlPoint.f7929e) == null) {
            return;
        }
        Message obtain = Message.obtain(handler, 4);
        obtain.arg1 = i;
        obtain.arg2 = i2;
        obtain.sendToTarget();
    }

    @Keep
    public static int onNetworkStatus(Object obj) {
        Context applicationContext;
        NetworkInfo activeNetworkInfo;
        if (obj == null || (applicationContext = CyberPlayerManager.getApplicationContext()) == null || !a(applicationContext) || (activeNetworkInfo = ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return 0;
        }
        if (activeNetworkInfo.getType() == 0) {
            return 1;
        }
        return activeNetworkInfo.getType() == 1 ? 2 : 0;
    }

    @Keep
    public static void onPrepared(Object obj) {
        CtrlPoint ctrlPoint;
        Handler handler;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || (handler = ctrlPoint.f7929e) == null) {
            return;
        }
        Message.obtain(handler, 1).sendToTarget();
    }

    @Keep
    public static void onSeekCompleted(Object obj, int i, int i2) {
        CtrlPoint ctrlPoint;
        Handler handler;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || (handler = ctrlPoint.f7929e) == null) {
            return;
        }
        Message obtain = Message.obtain(handler, 5);
        obtain.arg1 = i;
        obtain.arg2 = i2;
        obtain.sendToTarget();
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public long getCurrentTime() {
        long j = this.f7925a;
        if (j != 0) {
            return nativeCtrlPointGetCurrentPos(j);
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public long getDuration() {
        long j = this.f7925a;
        if (j != 0) {
            return nativeCtrlPointDuration(j);
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public int getPlaybackVolume() {
        long j = this.f7925a;
        if (j != 0) {
            return nativeCtrlPointGetPlaybackVolume(j);
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void pause() {
        long j = this.f7925a;
        if (j != 0) {
            nativeCtrlPointPause(j);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void play() {
        long j = this.f7925a;
        if (j != 0) {
            nativeCtrlPointPlay(j);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void seek(long j) {
        long j2 = this.f7925a;
        if (j2 != 0) {
            nativeCtrlPointSeek(j2, j);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setAVTransportUrl(String str) {
        if (this.f7925a == 0 || str == null || str.length() <= 0) {
            return;
        }
        nativeCtrlPointSetAVTransportURI(this.f7925a, str);
        this.f7927c = str;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        long j = this.f7925a;
        if (j != 0) {
            this.f7926b = ctrlPointListener;
            nativeCtrlPointSetListener(j, new WeakReference(this));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setMute(int i) {
        long j = this.f7925a;
        if (j != 0) {
            nativeCtrlPointSetMute(j, i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setPlaybackVolume(int i) {
        long j = this.f7925a;
        if (j != 0) {
            nativeCtrlPointSetPlaybackVolume(j, i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void shutdown() {
        long j = this.f7925a;
        if (j != 0) {
            nativeCtrlPointShutdown(j);
            this.f7925a = 0L;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void stop() {
        long j = this.f7925a;
        if (j != 0) {
            nativeCtrlPointStop(j);
        }
    }
}
