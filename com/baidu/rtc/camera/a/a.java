package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes5.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a aRC;
    private Context mContext;
    private c aRB = null;
    private volatile boolean mRequestEncoderReset = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.aRC = aVar;
        CM();
    }

    public void CL() {
        CM();
    }

    private void CM() {
        this.mRequestEncoderReset = false;
        if (this.aRB != null) {
            this.aRB.release();
            this.aRB = new c(this.mContext);
        }
        if (this.aRB == null) {
            this.aRB = new c(this.mContext);
        }
        this.aRB.a(this.aRC.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.CN().aRF != null) {
                    b.CN().aRF.onEncodeVideoFrameRecived(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.mRequestEncoderReset = true;
                if (b.CN().aRF != null) {
                    b.CN().aRF.onError(i);
                }
            }
        });
    }

    public void e(int i, long j) {
        if (this.mRequestEncoderReset) {
            CM();
        }
        if (this.aRB != null) {
            this.aRB.f(i, j);
        }
    }

    public void release() {
        if (this.aRB != null) {
            this.aRB.release();
        }
    }
}
