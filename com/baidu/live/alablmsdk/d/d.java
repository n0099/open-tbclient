package com.baidu.live.alablmsdk.d;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.rtc.h;
import com.baidu.rtc.i;
import com.baidu.rtc.l;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class d extends i {
    private static final String TAG = d.class.getSimpleName();
    private i.a aBW = null;

    @Override // com.baidu.rtc.i
    public void a(i.a aVar) {
        com.baidu.live.alablmsdk.a.c.d(" BLMRtcVideoCaptureProxy  initialize");
        com.baidu.live.alablmsdk.a.c.fJ(" BLMRtcVideoCaptureProxy  initialize");
        this.aBW = aVar;
    }

    @Override // com.baidu.rtc.i, org.webrtc.VideoCapturer
    public void dispose() {
        super.dispose();
        com.baidu.live.alablmsdk.a.c.d(" BLMRtcVideoCaptureProxy  dispose");
        com.baidu.live.alablmsdk.a.c.fJ(" BLMRtcVideoCaptureProxy  dispose");
        this.aBW = null;
    }

    @Override // com.baidu.rtc.i, org.webrtc.VideoCapturer
    public void startCapture(int i, int i2, int i3) {
        Log.i(TAG, "startCapture.");
    }

    @Override // com.baidu.rtc.i, org.webrtc.VideoCapturer
    public void stopCapture() {
        Log.i(TAG, "stopCapture.");
    }

    @Override // com.baidu.rtc.i, org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i, int i2, int i3) {
    }

    public l o(byte[] bArr, int i, int i2) {
        return new l(new h(bArr, i, i2, null), 0, TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime()));
    }

    public void p(byte[] bArr, int i, int i2) {
        l o = o(bArr, i, i2);
        if (o == null) {
            com.baidu.live.alablmsdk.a.c.d(" videoFrame == null ");
            com.baidu.live.alablmsdk.a.c.fJ(" videoFrame == null ");
            return;
        }
        if (this.aBW != null) {
            this.aBW.a(o);
        }
        o.release();
    }
}
