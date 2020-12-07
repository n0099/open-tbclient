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
    private AlaNDKRecorderAdapter ctW;
    private AlaNDKPlayerAdapter ctX;
    private com.baidu.rtc.camera.engine.c.a ctY;
    private RtcVideoPlayController ctZ;
    private TextureView cua;
    private TextureView.SurfaceTextureListener cub = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.ctY.c(surfaceTexture);
            b.this.ctY.X(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.ctY.X(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.ctY.agE();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a cuc = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void a(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.ctW != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.ctW.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.ctW = alaNDKRecorderAdapter;
        this.ctX = alaNDKPlayerAdapter;
        this.ctY = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.cuc);
        this.cua = new TextureView(context);
        this.cua.setSurfaceTextureListener(this.cub);
        this.ctZ = new RtcVideoPlayController(context, this.ctX, rtcConfig);
    }

    public View getRecorderView() {
        return this.cua;
    }

    public void a(RtcConfig rtcConfig) {
        this.ctY.startRecording();
        this.ctZ.c(rtcConfig);
    }

    public void stopRecording() {
        this.ctY.stopRecording();
        this.ctZ.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer ahd() {
        return this.ctZ.hE(1) == null ? this.ctZ.ahz() : this.ctZ.hE(1);
    }

    public void switchCamera() {
        this.ctY.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.ctZ.c(rtcConfig);
    }

    public void resetPreview() {
        this.ctY.agF();
    }
}
