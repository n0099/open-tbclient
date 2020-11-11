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
    private AlaNDKRecorderAdapter coM;
    private AlaNDKPlayerAdapter coN;
    private com.baidu.rtc.camera.engine.c.a coO;
    private RtcVideoPlayController coP;
    private TextureView coQ;
    private TextureView.SurfaceTextureListener coR = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.coO.c(surfaceTexture);
            b.this.coO.V(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.coO.V(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.coO.aee();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a coS = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void a(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.coM != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.coM.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.coM = alaNDKRecorderAdapter;
        this.coN = alaNDKPlayerAdapter;
        this.coO = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.coS);
        this.coQ = new TextureView(context);
        this.coQ.setSurfaceTextureListener(this.coR);
        this.coP = new RtcVideoPlayController(context, this.coN, rtcConfig);
    }

    public View getRecorderView() {
        return this.coQ;
    }

    public void a(RtcConfig rtcConfig) {
        this.coO.startRecording();
        this.coP.c(rtcConfig);
    }

    public void stopRecording() {
        this.coO.stopRecording();
        this.coP.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer aeD() {
        return this.coP.hk(1) == null ? this.coP.aeZ() : this.coP.hk(1);
    }

    public void switchCamera() {
        this.coO.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.coP.c(rtcConfig);
    }

    public void resetPreview() {
        this.coO.aef();
    }
}
