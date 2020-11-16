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
/* loaded from: classes16.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private AlaNDKRecorderAdapter cna;
    private AlaNDKPlayerAdapter cnb;
    private com.baidu.rtc.camera.engine.c.a cnc;
    private RtcVideoPlayController cnd;
    private TextureView cne;
    private TextureView.SurfaceTextureListener cnf = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.cnc.c(surfaceTexture);
            b.this.cnc.V(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.cnc.V(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.cnc.adw();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a cng = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void a(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.cna != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.cna.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.cna = alaNDKRecorderAdapter;
        this.cnb = alaNDKPlayerAdapter;
        this.cnc = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.cng);
        this.cne = new TextureView(context);
        this.cne.setSurfaceTextureListener(this.cnf);
        this.cnd = new RtcVideoPlayController(context, this.cnb, rtcConfig);
    }

    public View getRecorderView() {
        return this.cne;
    }

    public void a(RtcConfig rtcConfig) {
        this.cnc.startRecording();
        this.cnd.c(rtcConfig);
    }

    public void stopRecording() {
        this.cnc.stopRecording();
        this.cnd.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer adV() {
        return this.cnd.hg(1) == null ? this.cnd.aer() : this.cnd.hg(1);
    }

    public void switchCamera() {
        this.cnc.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.cnd.c(rtcConfig);
    }

    public void resetPreview() {
        this.cnc.adx();
    }
}
