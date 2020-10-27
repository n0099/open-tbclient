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
    private AlaNDKRecorderAdapter ciQ;
    private AlaNDKPlayerAdapter ciR;
    private com.baidu.rtc.camera.engine.c.a ciS;
    private RtcVideoPlayController ciT;
    private TextureView ciU;
    private TextureView.SurfaceTextureListener ciV = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.ciS.c(surfaceTexture);
            b.this.ciS.V(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.ciS.V(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.ciS.abE();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a ciW = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void a(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.ciQ != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.ciQ.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.ciQ = alaNDKRecorderAdapter;
        this.ciR = alaNDKPlayerAdapter;
        this.ciS = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.ciW);
        this.ciU = new TextureView(context);
        this.ciU.setSurfaceTextureListener(this.ciV);
        this.ciT = new RtcVideoPlayController(context, this.ciR, rtcConfig);
    }

    public View getRecorderView() {
        return this.ciU;
    }

    public void a(RtcConfig rtcConfig) {
        this.ciS.startRecording();
        this.ciT.c(rtcConfig);
    }

    public void stopRecording() {
        this.ciS.stopRecording();
        this.ciT.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer acd() {
        return this.ciT.ha(1) == null ? this.ciT.acz() : this.ciT.ha(1);
    }

    public void switchCamera() {
        this.ciS.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.ciT.c(rtcConfig);
    }

    public void resetPreview() {
        this.ciS.abF();
    }
}
