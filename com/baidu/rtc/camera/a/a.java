package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes15.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a bPk;
    private Context mContext;
    private c bPj = null;
    private volatile boolean bPl = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.bPk = aVar;
        Xn();
    }

    public void Xm() {
        Xn();
    }

    private void Xn() {
        this.bPl = false;
        if (this.bPj != null) {
            this.bPj.release();
            this.bPj = new c(this.mContext);
        }
        if (this.bPj == null) {
            this.bPj = new c(this.mContext);
        }
        this.bPj.a(this.bPk.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.Xo().bPo != null) {
                    b.Xo().bPo.a(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.bPl = true;
                if (b.Xo().bPo != null) {
                    b.Xo().bPo.onError(i);
                }
            }
        });
    }

    public void f(int i, long j) {
        if (this.bPl) {
            Xn();
        }
        if (this.bPj != null) {
            this.bPj.g(i, j);
        }
    }

    public void release() {
        if (this.bPj != null) {
            this.bPj.release();
        }
    }
}
