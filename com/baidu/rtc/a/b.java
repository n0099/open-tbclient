package com.baidu.rtc.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.baidu.rtc.RtcConfig;
import com.baidu.rtc.ndk.AlaNDKPlayerAdapter;
import com.baidu.rtc.ndk.AlaNDKRecorderAdapter;
import com.baidu.rtc.player.RtcVideoPlayController;
/* loaded from: classes6.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.rtc.camera.engine.c.a bwA;
    private RtcVideoPlayController bwB;
    private TextureView bwC;
    private TextureView.SurfaceTextureListener bwD = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bwA.c(surfaceTexture);
            b.this.bwA.M(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bwA.M(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.bwA.Ng();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a bwE = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void a(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.bwy != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.bwy.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private AlaNDKRecorderAdapter bwy;
    private AlaNDKPlayerAdapter bwz;
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.bwy = alaNDKRecorderAdapter;
        this.bwz = alaNDKPlayerAdapter;
        this.bwA = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.bwE);
        this.bwC = new TextureView(context);
        this.bwC.setSurfaceTextureListener(this.bwD);
        this.bwB = new RtcVideoPlayController(context, this.bwz, rtcConfig);
    }

    public View getRecorderView() {
        return this.bwC;
    }

    public void a(RtcConfig rtcConfig) {
        this.bwA.startRecording();
        this.bwB.c(rtcConfig);
    }

    public void stopRecording() {
        this.bwA.stopRecording();
        this.bwB.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer NH() {
        return this.bwB.dS(1) == null ? this.bwB.NI() : this.bwB.dS(1);
    }

    public void switchCamera() {
        this.bwA.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.bwB.c(rtcConfig);
    }

    public void resetPreview() {
        this.bwA.Nh();
    }
}
