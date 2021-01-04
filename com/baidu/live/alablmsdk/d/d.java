package com.baidu.live.alablmsdk.d;

import android.os.SystemClock;
import com.baidu.rtc.h;
import com.baidu.rtc.i;
import com.baidu.rtc.l;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class d extends i {
    private i.a aDL = null;

    @Override // com.baidu.rtc.i
    public void a(i.a aVar) {
        com.baidu.live.alablmsdk.a.b.a.aj(" BLMRtcVideoCaptureProxy  initialize", "");
        this.aDL = aVar;
    }

    @Override // com.baidu.rtc.i, org.webrtc.VideoCapturer
    public void dispose() {
        super.dispose();
        com.baidu.live.alablmsdk.a.b.a.aj(" BLMRtcVideoCaptureProxy  dispose", "");
        this.aDL = null;
    }

    @Override // com.baidu.rtc.i, org.webrtc.VideoCapturer
    public void startCapture(int i, int i2, int i3) {
    }

    @Override // com.baidu.rtc.i, org.webrtc.VideoCapturer
    public void stopCapture() {
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
            com.baidu.live.alablmsdk.a.b.a.d(" videoFrame == null ");
            com.baidu.live.alablmsdk.a.b.a.fI(" videoFrame == null ");
            return;
        }
        if (this.aDL != null) {
            this.aDL.a(o);
        }
        o.release();
    }
}
