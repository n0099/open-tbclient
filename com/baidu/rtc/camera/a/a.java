package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes11.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a bYG;
    private Context mContext;
    private c bYF = null;
    private volatile boolean bYH = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.bYG = aVar;
        ZF();
    }

    public void ZE() {
        ZF();
    }

    private void ZF() {
        this.bYH = false;
        if (this.bYF != null) {
            this.bYF.release();
            this.bYF = new c(this.mContext);
        }
        if (this.bYF == null) {
            this.bYF = new c(this.mContext);
        }
        this.bYF.a(this.bYG.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.ZG().bYK != null) {
                    b.ZG().bYK.a(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.bYH = true;
                if (b.ZG().bYK != null) {
                    b.ZG().bYK.onError(i);
                }
            }
        });
    }

    public void g(int i, long j) {
        if (this.bYH) {
            ZF();
        }
        if (this.bYF != null) {
            this.bYF.h(i, j);
        }
    }

    public void release() {
        if (this.bYF != null) {
            this.bYF.release();
        }
    }
}
