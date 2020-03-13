package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes6.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a aWd;
    private Context mContext;
    private c aWc = null;
    private volatile boolean mRequestEncoderReset = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.aWd = aVar;
        Fk();
    }

    public void Fj() {
        Fk();
    }

    private void Fk() {
        this.mRequestEncoderReset = false;
        if (this.aWc != null) {
            this.aWc.release();
            this.aWc = new c(this.mContext);
        }
        if (this.aWc == null) {
            this.aWc = new c(this.mContext);
        }
        this.aWc.a(this.aWd.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.Fl().aWg != null) {
                    b.Fl().aWg.onEncodeVideoFrameRecived(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.mRequestEncoderReset = true;
                if (b.Fl().aWg != null) {
                    b.Fl().aWg.onError(i);
                }
            }
        });
    }

    public void e(int i, long j) {
        if (this.mRequestEncoderReset) {
            Fk();
        }
        if (this.aWc != null) {
            this.aWc.f(i, j);
        }
    }

    public void release() {
        if (this.aWc != null) {
            this.aWc.release();
        }
    }
}
