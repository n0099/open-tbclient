package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes7.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a bHG;
    private Context mContext;
    private c bHF = null;
    private volatile boolean mRequestEncoderReset = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.bHG = aVar;
        QI();
    }

    public void QH() {
        QI();
    }

    private void QI() {
        this.mRequestEncoderReset = false;
        if (this.bHF != null) {
            this.bHF.release();
            this.bHF = new c(this.mContext);
        }
        if (this.bHF == null) {
            this.bHF = new c(this.mContext);
        }
        this.bHF.a(this.bHG.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.QJ().bHJ != null) {
                    b.QJ().bHJ.a(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.mRequestEncoderReset = true;
                if (b.QJ().bHJ != null) {
                    b.QJ().bHJ.onError(i);
                }
            }
        });
    }

    public void f(int i, long j) {
        if (this.mRequestEncoderReset) {
            QI();
        }
        if (this.bHF != null) {
            this.bHF.g(i, j);
        }
    }

    public void release() {
        if (this.bHF != null) {
            this.bHF.release();
        }
    }
}
