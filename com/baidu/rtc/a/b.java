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
    private AlaNDKRecorderAdapter aXY;
    private AlaNDKPlayerAdapter aXZ;
    private com.baidu.rtc.camera.engine.c.a aYa;
    private RtcVideoPlayController aYb;
    private TextureView aYc;
    private TextureView.SurfaceTextureListener aYd = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aYa.d(surfaceTexture);
            b.this.aYa.K(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aYa.K(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.aYa.Fu();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a aYe = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void onEncodeVideoFrameRecived(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.aXY != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.aXY.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.aXY = alaNDKRecorderAdapter;
        this.aXZ = alaNDKPlayerAdapter;
        this.aYa = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.aYe);
        this.aYc = new TextureView(context);
        this.aYc.setSurfaceTextureListener(this.aYd);
        this.aYb = new RtcVideoPlayController(context, this.aXZ, rtcConfig);
    }

    public View getRecorderView() {
        return this.aYc;
    }

    public void a(RtcConfig rtcConfig) {
        this.aYa.Dk();
        this.aYb.c(rtcConfig);
    }

    public void stopRecording() {
        this.aYa.stopRecording();
        this.aYb.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer FU() {
        return this.aYb.dJ(1) == null ? this.aYb.FV() : this.aYb.dJ(1);
    }

    public void switchCamera() {
        this.aYa.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.aYb.c(rtcConfig);
    }

    public void resetPreview() {
        this.aYa.Fv();
    }
}
