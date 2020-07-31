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
/* loaded from: classes7.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private AlaNDKRecorderAdapter bJt;
    private AlaNDKPlayerAdapter bJu;
    private com.baidu.rtc.camera.engine.c.a bJv;
    private RtcVideoPlayController bJw;
    private TextureView bJx;
    private TextureView.SurfaceTextureListener bJy = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bJv.c(surfaceTexture);
            b.this.bJv.R(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bJv.R(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.bJv.QN();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a bJz = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void a(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.bJt != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.bJt.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.bJt = alaNDKRecorderAdapter;
        this.bJu = alaNDKPlayerAdapter;
        this.bJv = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.bJz);
        this.bJx = new TextureView(context);
        this.bJx.setSurfaceTextureListener(this.bJy);
        this.bJw = new RtcVideoPlayController(context, this.bJu, rtcConfig);
    }

    public View getRecorderView() {
        return this.bJx;
    }

    public void a(RtcConfig rtcConfig) {
        this.bJv.startRecording();
        this.bJw.c(rtcConfig);
    }

    public void stopRecording() {
        this.bJv.stopRecording();
        this.bJw.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer Ro() {
        return this.bJw.el(1) == null ? this.bJw.Rp() : this.bJw.el(1);
    }

    public void switchCamera() {
        this.bJv.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.bJw.c(rtcConfig);
    }

    public void resetPreview() {
        this.bJv.QO();
    }
}
