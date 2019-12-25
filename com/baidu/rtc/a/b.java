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
/* loaded from: classes4.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private AlaNDKRecorderAdapter aSs;
    private AlaNDKPlayerAdapter aSt;
    private com.baidu.rtc.camera.engine.c.a aSu;
    private RtcVideoPlayController aSv;
    private TextureView aSw;
    private TextureView.SurfaceTextureListener aSx = new TextureView.SurfaceTextureListener() { // from class: com.baidu.rtc.a.b.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aSu.d(surfaceTexture);
            b.this.aSu.F(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aSu.F(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.aSu.Cv();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private com.baidu.rtc.camera.b.a aSy = new com.baidu.rtc.camera.b.a() { // from class: com.baidu.rtc.a.b.2
        @Override // com.baidu.rtc.camera.b.a
        public void onEncodeVideoFrameRecived(byte[] bArr, int i, int i2, int i3, long j) {
            if (b.this.aSs != null) {
                Log.d(b.TAG, "sendH364data length:" + i2);
                b.this.aSs.sendH264DataNative(bArr, i2, "", j);
            }
        }

        @Override // com.baidu.rtc.camera.b.a
        public void onError(int i) {
        }
    };
    private Context mContext;

    public b(Context context, RtcConfig rtcConfig, AlaNDKRecorderAdapter alaNDKRecorderAdapter, AlaNDKPlayerAdapter alaNDKPlayerAdapter) {
        this.mContext = context;
        this.aSs = alaNDKRecorderAdapter;
        this.aSt = alaNDKPlayerAdapter;
        this.aSu = new com.baidu.rtc.camera.engine.c.a(context, !rtcConfig.isCameraFront(), this.aSy);
        this.aSw = new TextureView(context);
        this.aSw.setSurfaceTextureListener(this.aSx);
        this.aSv = new RtcVideoPlayController(context, this.aSt, rtcConfig);
    }

    public View getRecorderView() {
        return this.aSw;
    }

    public void a(RtcConfig rtcConfig) {
        this.aSu.Ap();
        this.aSv.c(rtcConfig);
    }

    public void stopRecording() {
        this.aSu.stopRecording();
        this.aSv.stopPlay();
    }

    public RtcVideoPlayController.RtcVideoPlayer CV() {
        return this.aSv.ds(1) == null ? this.aSv.CW() : this.aSv.ds(1);
    }

    public void switchCamera() {
        this.aSu.switchCamera();
    }

    public void b(RtcConfig rtcConfig) {
        this.aSv.c(rtcConfig);
    }

    public void resetPreview() {
        this.aSu.Cw();
    }
}
