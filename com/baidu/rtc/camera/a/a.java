package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes6.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a buL;
    private Context mContext;
    private c buK = null;
    private volatile boolean mRequestEncoderReset = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.buL = aVar;
        Nb();
    }

    public void Na() {
        Nb();
    }

    private void Nb() {
        this.mRequestEncoderReset = false;
        if (this.buK != null) {
            this.buK.release();
            this.buK = new c(this.mContext);
        }
        if (this.buK == null) {
            this.buK = new c(this.mContext);
        }
        this.buK.a(this.buL.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.Nc().buO != null) {
                    b.Nc().buO.a(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.mRequestEncoderReset = true;
                if (b.Nc().buO != null) {
                    b.Nc().buO.onError(i);
                }
            }
        });
    }

    public void e(int i, long j) {
        if (this.mRequestEncoderReset) {
            Nb();
        }
        if (this.buK != null) {
            this.buK.f(i, j);
        }
    }

    public void release() {
        if (this.buK != null) {
            this.buK.release();
        }
    }
}
