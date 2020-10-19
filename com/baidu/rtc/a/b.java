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
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private AlaNDKRecorderAdapter car;
    private AlaNDKPlayerAdapter cas;
    private com.baidu.rtc.camera.engine.c.a cat;
    private RtcVideoPlayController cau;
    private TextureView cav;
    private TextureView.SurfaceTextureListener caw = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.cat.c(surfaceTexture);
            b.this.cat.U(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.cat.U(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.cat.ZK();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a cax = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void a(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.car != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.car.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.car = alaNDKRecorderAdapter;
        this.cas = alaNDKPlayerAdapter;
        this.cat = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.cax);
        this.cav = new TextureView(context);
        this.cav.setSurfaceTextureListener(this.caw);
        this.cau = new RtcVideoPlayController(context, this.cas, rtcConfig);
    }

    public View getRecorderView() {
        return this.cav;
    }

    public void a(RtcConfig rtcConfig) {
        this.cat.startRecording();
        this.cau.c(rtcConfig);
    }

    public void stopRecording() {
        this.cat.stopRecording();
        this.cau.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer aaj() {
        return this.cau.gP(1) == null ? this.cau.aaF() : this.cau.gP(1);
    }

    public void switchCamera() {
        this.cat.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.cau.c(rtcConfig);
    }

    public void resetPreview() {
        this.cat.ZL();
    }
}
