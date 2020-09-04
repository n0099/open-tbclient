package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes11.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a bNk;
    private Context mContext;
    private c bNj = null;
    private volatile boolean bNl = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.bNk = aVar;
        WE();
    }

    public void WD() {
        WE();
    }

    private void WE() {
        this.bNl = false;
        if (this.bNj != null) {
            this.bNj.release();
            this.bNj = new c(this.mContext);
        }
        if (this.bNj == null) {
            this.bNj = new c(this.mContext);
        }
        this.bNj.a(this.bNk.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.WF().bNo != null) {
                    b.WF().bNo.a(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.bNl = true;
                if (b.WF().bNo != null) {
                    b.WF().bNo.onError(i);
                }
            }
        });
    }

    public void f(int i, long j) {
        if (this.bNl) {
            WE();
        }
        if (this.bNj != null) {
            this.bNj.g(i, j);
        }
    }

    public void release() {
        if (this.bNj != null) {
            this.bNj.release();
        }
    }
}
