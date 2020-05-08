package com.baidu.media.dlna;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
import com.baidu.media.duplayer.Keep;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class CtrlPoint extends CtrlPointProvider {
    private long b;
    CtrlPointProvider.CtrlPointListener bhI;
    private Handler c = new Handler(Looper.getMainLooper()) { // from class: com.baidu.media.dlna.CtrlPoint.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (CtrlPoint.this.bhI != null) {
                        CtrlPoint.this.bhI.onPrepared();
                        break;
                    }
                    break;
                case 2:
                    if (CtrlPoint.this.bhI != null) {
                        CtrlPoint.this.bhI.onComplete();
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    };

    public CtrlPoint(long j) {
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
    private static void onPrepared(Object obj) {
        CtrlPoint ctrlPoint;
        if (obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || ctrlPoint.c == null) {
            return;
        }
        Message.obtain(ctrlPoint.c, 1).sendToTarget();
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public long getCurrentTime() {
        return nativeCtrlPointGetCurrentPos(this.b);
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public long getDuration() {
        return nativeCtrlPointDuration(this.b);
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public int getPlaybackVolume() {
        return nativeCtrlPointGetPlaybackVolume(this.b);
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void pause() {
        nativeCtrlPointPause(this.b);
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void play() {
        nativeCtrlPointPlay(this.b);
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void seek(long j) {
        nativeCtrlPointSeek(this.b, j);
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setAVTransportUrl(String str) {
        nativeCtrlPointSetAVTransportURI(this.b, str);
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        this.bhI = ctrlPointListener;
        nativeCtrlPointSetListener(this.b, new WeakReference(this));
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setPlaybackVolume(int i) {
        nativeCtrlPointSetPlaybackVolume(this.b, i);
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void shutdown() {
        nativeCtrlPointShutdown(this.b);
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void stop() {
        nativeCtrlPointStop(this.b);
    }
}
