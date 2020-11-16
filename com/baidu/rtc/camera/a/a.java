package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes16.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a clo;
    private Context mContext;
    private c cln = null;
    private volatile boolean clp = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.clo = aVar;
        adr();
    }

    public void adq() {
        adr();
    }

    private void adr() {
        this.clp = false;
        if (this.cln != null) {
            this.cln.release();
            this.cln = new c(this.mContext);
        }
        if (this.cln == null) {
            this.cln = new c(this.mContext);
        }
        this.cln.a(this.clo.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.ads().cls != null) {
                    b.ads().cls.a(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.clp = true;
                if (b.ads().cls != null) {
                    b.ads().cls.onError(i);
                }
            }
        });
    }

    public void f(int i, long j) {
        if (this.clp) {
            adr();
        }
        if (this.cln != null) {
            this.cln.g(i, j);
        }
    }

    public void release() {
        if (this.cln != null) {
            this.cln.release();
        }
    }
}
