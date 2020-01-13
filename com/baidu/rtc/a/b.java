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
/* loaded from: classes5.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private AlaNDKRecorderAdapter aTk;
    private AlaNDKPlayerAdapter aTl;
    private com.baidu.rtc.camera.engine.c.a aTm;
    private RtcVideoPlayController aTn;
    private TextureView aTo;
    private TextureView.SurfaceTextureListener aTp = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aTm.d(surfaceTexture);
            b.this.aTm.J(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aTm.J(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.aTm.CR();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a aTq = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void onEncodeVideoFrameRecived(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.aTk != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.aTk.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.aTk = alaNDKRecorderAdapter;
        this.aTl = alaNDKPlayerAdapter;
        this.aTm = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.aTq);
        this.aTo = new TextureView(context);
        this.aTo.setSurfaceTextureListener(this.aTp);
        this.aTn = new RtcVideoPlayController(context, this.aTl, rtcConfig);
    }

    public View getRecorderView() {
        return this.aTo;
    }

    public void a(RtcConfig rtcConfig) {
        this.aTm.AL();
        this.aTn.c(rtcConfig);
    }

    public void stopRecording() {
        this.aTm.stopRecording();
        this.aTn.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer Dr() {
        return this.aTn.dt(1) == null ? this.aTn.Ds() : this.aTn.dt(1);
    }

    public void switchCamera() {
        this.aTm.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.aTn.c(rtcConfig);
    }

    public void resetPreview() {
        this.aTm.CS();
    }
}
