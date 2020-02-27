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
    private AlaNDKRecorderAdapter aXJ;
    private AlaNDKPlayerAdapter aXK;
    private com.baidu.rtc.camera.engine.c.a aXL;
    private RtcVideoPlayController aXM;
    private TextureView aXN;
    private TextureView.SurfaceTextureListener aXO = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aXL.d(surfaceTexture);
            b.this.aXL.K(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aXL.K(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.aXL.Fn();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a aXP = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void onEncodeVideoFrameRecived(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.aXJ != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.aXJ.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.aXJ = alaNDKRecorderAdapter;
        this.aXK = alaNDKPlayerAdapter;
        this.aXL = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.aXP);
        this.aXN = new TextureView(context);
        this.aXN.setSurfaceTextureListener(this.aXO);
        this.aXM = new RtcVideoPlayController(context, this.aXK, rtcConfig);
    }

    public View getRecorderView() {
        return this.aXN;
    }

    public void a(RtcConfig rtcConfig) {
        this.aXL.Db();
        this.aXM.c(rtcConfig);
    }

    public void stopRecording() {
        this.aXL.stopRecording();
        this.aXM.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer FN() {
        return this.aXM.dJ(1) == null ? this.aXM.FO() : this.aXM.dJ(1);
    }

    public void switchCamera() {
        this.aXL.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.aXM.c(rtcConfig);
    }

    public void resetPreview() {
        this.aXL.Fo();
    }
}
