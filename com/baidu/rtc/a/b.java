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
    private AlaNDKRecorderAdapter bOV;
    private AlaNDKPlayerAdapter bOW;
    private com.baidu.rtc.camera.engine.c.a bOX;
    private RtcVideoPlayController bOY;
    private TextureView bOZ;
    private TextureView.SurfaceTextureListener bPa = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bOX.c(surfaceTexture);
            b.this.bOX.U(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bOX.U(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.bOX.WJ();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a bPb = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void a(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.bOV != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.bOV.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.bOV = alaNDKRecorderAdapter;
        this.bOW = alaNDKPlayerAdapter;
        this.bOX = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.bPb);
        this.bOZ = new TextureView(context);
        this.bOZ.setSurfaceTextureListener(this.bPa);
        this.bOY = new RtcVideoPlayController(context, this.bOW, rtcConfig);
    }

    public View getRecorderView() {
        return this.bOZ;
    }

    public void a(RtcConfig rtcConfig) {
        this.bOX.startRecording();
        this.bOY.c(rtcConfig);
    }

    public void stopRecording() {
        this.bOX.stopRecording();
        this.bOY.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer Xj() {
        return this.bOY.gi(1) == null ? this.bOY.Xk() : this.bOY.gi(1);
    }

    public void switchCamera() {
        this.bOX.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.bOY.c(rtcConfig);
    }

    public void resetPreview() {
        this.bOX.WK();
    }
}
