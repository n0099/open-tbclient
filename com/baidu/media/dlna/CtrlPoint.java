package com.baidu.media.dlna;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
import com.baidu.media.duplayer.Keep;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class CtrlPoint extends CtrlPointProvider {
    private long b;
    CtrlPointProvider.CtrlPointListener buD;
    private Handler c = new Handler(Looper.getMainLooper()) { // from class: com.baidu.media.dlna.CtrlPoint.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (CtrlPoint.this.buD != null) {
                        CtrlPoint.this.buD.onPrepared();
                        break;
                    }
                    break;
                case 2:
                    if (CtrlPoint.this.buD != null) {
                        CtrlPoint.this.buD.onComplete();
                        break;
                    }
                    break;
                case 3:
                    if (CtrlPoint.this.buD != null) {
                        CtrlPoint.this.buD.onError(message.arg1, message.arg2);
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    };

    public CtrlPoint(long j) {
        this.b = 0L;
        this.b = j;
    }

    private static native long nativeCtrlPointDuration(long j);

    private static native long nativeCtrlPointGetCurrentPos(long j);

    private static native int nativeCtrlPointGetPlaybackVolume(long j);

    private static native void nativeCtrlPointPause(long j);

    private static native void nativeCtrlPointPlay(long j);

    private static native void nativeCtrlPointSeek(long j, long j2);

    private static native void nativeCtrlPointSetAVTransportURI(long j, String str);

    private static native void nativeCtrlPointSetListener(long j, Object obj);

    private static native void nativeCtrlPointSetPlaybackVolume(long j, int i);

    private static native void nativeCtrlPointShutdown(long j);

    private static native void nativeCtrlPointStop(long j);

    @Keep
    private static void onComplete(Object obj) {
        CtrlPoint ctrlPoint;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || ctrlPoint.c == null) {
            return;
        }
        Message.obtain(ctrlPoint.c, 2).sendToTarget();
    }

    @Keep
    private static void onError(Object obj, int i, int i2) {
        CtrlPoint ctrlPoint;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || ctrlPoint.c == null) {
            return;
        }
        Message obtain = Message.obtain(ctrlPoint.c, 3);
        obtain.arg1 = i;
        obtain.arg2 = i2;
        obtain.sendToTarget();
    }

    @Keep
    private static void onPrepared(Object obj) {
        CtrlPoint ctrlPoint;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || ctrlPoint.c == null) {
            return;
        }
        Message.obtain(ctrlPoint.c, 1).sendToTarget();
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public long getCurrentTime() {
        if (this.b != 0) {
            return nativeCtrlPointGetCurrentPos(this.b);
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public long getDuration() {
        if (this.b != 0) {
            return nativeCtrlPointDuration(this.b);
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public int getPlaybackVolume() {
        if (this.b != 0) {
            return nativeCtrlPointGetPlaybackVolume(this.b);
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void pause() {
        if (this.b != 0) {
            nativeCtrlPointPause(this.b);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void play() {
        if (this.b != 0) {
            nativeCtrlPointPlay(this.b);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void seek(long j) {
        if (this.b != 0) {
            nativeCtrlPointSeek(this.b, j);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setAVTransportUrl(String str) {
        if (this.b == 0 || str == null || str.length() <= 0) {
            return;
        }
        nativeCtrlPointSetAVTransportURI(this.b, str);
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        if (this.b != 0) {
            this.buD = ctrlPointListener;
            nativeCtrlPointSetListener(this.b, new WeakReference(this));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setPlaybackVolume(int i) {
        if (this.b != 0) {
            nativeCtrlPointSetPlaybackVolume(this.b, i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void shutdown() {
        if (this.b != 0) {
            nativeCtrlPointShutdown(this.b);
            this.b = 0L;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void stop() {
        if (this.b != 0) {
            nativeCtrlPointStop(this.b);
        }
    }
}
