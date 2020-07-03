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
    private AlaNDKRecorderAdapter bIU;
    private AlaNDKPlayerAdapter bIV;
    private com.baidu.rtc.camera.engine.c.a bIW;
    private RtcVideoPlayController bIX;
    private TextureView bIY;
    private TextureView.SurfaceTextureListener bIZ = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bIW.c(surfaceTexture);
            b.this.bIW.R(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bIW.R(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.bIW.Qy();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a bJa = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void a(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.bIU != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.bIU.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.bIU = alaNDKRecorderAdapter;
        this.bIV = alaNDKPlayerAdapter;
        this.bIW = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.bJa);
        this.bIY = new TextureView(context);
        this.bIY.setSurfaceTextureListener(this.bIZ);
        this.bIX = new RtcVideoPlayController(context, this.bIV, rtcConfig);
    }

    public View getRecorderView() {
        return this.bIY;
    }

    public void a(RtcConfig rtcConfig) {
        this.bIW.startRecording();
        this.bIX.c(rtcConfig);
    }

    public void stopRecording() {
        this.bIW.stopRecording();
        this.bIX.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer QZ() {
        return this.bIX.el(1) == null ? this.bIX.Ra() : this.bIX.el(1);
    }

    public void switchCamera() {
        this.bIW.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.bIX.c(rtcConfig);
    }

    public void resetPreview() {
        this.bIW.Qz();
    }
}
