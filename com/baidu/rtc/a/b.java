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
    private AlaNDKRecorderAdapter aXL;
    private AlaNDKPlayerAdapter aXM;
    private com.baidu.rtc.camera.engine.c.a aXN;
    private RtcVideoPlayController aXO;
    private TextureView aXP;
    private TextureView.SurfaceTextureListener aXQ = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aXN.d(surfaceTexture);
            b.this.aXN.K(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aXN.K(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.aXN.Fp();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a aXR = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void onEncodeVideoFrameRecived(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.aXL != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.aXL.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.aXL = alaNDKRecorderAdapter;
        this.aXM = alaNDKPlayerAdapter;
        this.aXN = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.aXR);
        this.aXP = new TextureView(context);
        this.aXP.setSurfaceTextureListener(this.aXQ);
        this.aXO = new RtcVideoPlayController(context, this.aXM, rtcConfig);
    }

    public View getRecorderView() {
        return this.aXP;
    }

    public void a(RtcConfig rtcConfig) {
        this.aXN.Dd();
        this.aXO.c(rtcConfig);
    }

    public void stopRecording() {
        this.aXN.stopRecording();
        this.aXO.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer FP() {
        return this.aXO.dJ(1) == null ? this.aXO.FQ() : this.aXO.dJ(1);
    }

    public void switchCamera() {
        this.aXN.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.aXO.c(rtcConfig);
    }

    public void resetPreview() {
        this.aXN.Fq();
    }
}
