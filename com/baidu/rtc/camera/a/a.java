package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes11.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a bNg;
    private Context mContext;
    private c bNf = null;
    private volatile boolean bNh = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.bNg = aVar;
        WE();
    }

    public void WD() {
        WE();
    }

    private void WE() {
        this.bNh = false;
        if (this.bNf != null) {
            this.bNf.release();
            this.bNf = new c(this.mContext);
        }
        if (this.bNf == null) {
            this.bNf = new c(this.mContext);
        }
        this.bNf.a(this.bNg.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.WF().bNk != null) {
                    b.WF().bNk.a(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.bNh = true;
                if (b.WF().bNk != null) {
                    b.WF().bNk.onError(i);
                }
            }
        });
    }

    public void f(int i, long j) {
        if (this.bNh) {
            WE();
        }
        if (this.bNf != null) {
            this.bNf.g(i, j);
        }
    }

    public void release() {
        if (this.bNf != null) {
            this.bNf.release();
        }
    }
}
