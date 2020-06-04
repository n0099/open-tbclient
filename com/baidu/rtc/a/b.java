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
    private AlaNDKRecorderAdapter bEg;
    private AlaNDKPlayerAdapter bEh;
    private com.baidu.rtc.camera.engine.c.a bEi;
    private RtcVideoPlayController bEj;
    private TextureView bEk;
    private TextureView.SurfaceTextureListener bEl = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bEi.c(surfaceTexture);
            b.this.bEi.P(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bEi.P(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.bEi.Ps();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a bEm = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void a(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.bEg != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.bEg.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.bEg = alaNDKRecorderAdapter;
        this.bEh = alaNDKPlayerAdapter;
        this.bEi = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.bEm);
        this.bEk = new TextureView(context);
        this.bEk.setSurfaceTextureListener(this.bEl);
        this.bEj = new RtcVideoPlayController(context, this.bEh, rtcConfig);
    }

    public View getRecorderView() {
        return this.bEk;
    }

    public void a(RtcConfig rtcConfig) {
        this.bEi.startRecording();
        this.bEj.c(rtcConfig);
    }

    public void stopRecording() {
        this.bEi.stopRecording();
        this.bEj.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer PT() {
        return this.bEj.ea(1) == null ? this.bEj.PU() : this.bEj.ea(1);
    }

    public void switchCamera() {
        this.bEi.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.bEj.c(rtcConfig);
    }

    public void resetPreview() {
        this.bEi.Pt();
    }
}
