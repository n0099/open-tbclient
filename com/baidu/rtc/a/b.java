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
    private AlaNDKRecorderAdapter aXK;
    private AlaNDKPlayerAdapter aXL;
    private com.baidu.rtc.camera.engine.c.a aXM;
    private RtcVideoPlayController aXN;
    private TextureView aXO;
    private TextureView.SurfaceTextureListener aXP = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aXM.d(surfaceTexture);
            b.this.aXM.K(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aXM.K(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.aXM.Fp();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a aXQ = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void onEncodeVideoFrameRecived(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.aXK != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.aXK.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.aXK = alaNDKRecorderAdapter;
        this.aXL = alaNDKPlayerAdapter;
        this.aXM = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.aXQ);
        this.aXO = new TextureView(context);
        this.aXO.setSurfaceTextureListener(this.aXP);
        this.aXN = new RtcVideoPlayController(context, this.aXL, rtcConfig);
    }

    public View getRecorderView() {
        return this.aXO;
    }

    public void a(RtcConfig rtcConfig) {
        this.aXM.Dd();
        this.aXN.c(rtcConfig);
    }

    public void stopRecording() {
        this.aXM.stopRecording();
        this.aXN.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer FP() {
        return this.aXN.dJ(1) == null ? this.aXN.FQ() : this.aXN.dJ(1);
    }

    public void switchCamera() {
        this.aXM.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.aXN.c(rtcConfig);
    }

    public void resetPreview() {
        this.aXM.Fq();
    }
}
