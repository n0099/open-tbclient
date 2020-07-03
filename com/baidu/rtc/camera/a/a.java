package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes6.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a bHh;
    private Context mContext;
    private c bHg = null;
    private volatile boolean mRequestEncoderReset = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.bHh = aVar;
        Qt();
    }

    public void Qs() {
        Qt();
    }

    private void Qt() {
        this.mRequestEncoderReset = false;
        if (this.bHg != null) {
            this.bHg.release();
            this.bHg = new c(this.mContext);
        }
        if (this.bHg == null) {
            this.bHg = new c(this.mContext);
        }
        this.bHg.a(this.bHh.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.Qu().bHk != null) {
                    b.Qu().bHk.a(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.mRequestEncoderReset = true;
                if (b.Qu().bHk != null) {
                    b.Qu().bHk.onError(i);
                }
            }
        });
    }

    public void f(int i, long j) {
        if (this.mRequestEncoderReset) {
            Qt();
        }
        if (this.bHg != null) {
            this.bHg.g(i, j);
        }
    }

    public void release() {
        if (this.bHg != null) {
            this.bHg.release();
        }
    }
}
